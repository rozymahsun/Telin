package sg.telin.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.zkoss.bind.BindUtils;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.GlobalCommand;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zul.Messagebox;

import sg.telin.backend.model.User;
import sg.telin.backend.service.UserService;
import sg.telin.controller.util.BaseVMController;


public class UserListController extends BaseVMController {
	  private List<User> userList= new ArrayList<User>();
	  private User currentUser;
	  private Integer currentUserIdx;
	  
	  @WireVariable
	  private UserService userService;
	  
	    @Init
	    public void initSetup() {
	    	userList= userService.findAll();
	    }
	    @Command
	    public void addNewCustomer() {
	        //Messagebox.show("Add New Customer Code goes here");
	        final HashMap<String, Object> map = new HashMap<String, Object>();
	        map.put("sUser", null);
	        map.put("recordMode", "NEW");
	        Executions.createComponents("/WEB-INF/pages/userForm.zul", null, map);
	    }

	    @Command
	    public void editThisCustomer() {
	    	final HashMap<String, Object> map = new HashMap<String, Object>();
	        map.put("sUser", this.currentUser);
	        map.put("recordMode", "EDIT");
	        setCurrentUserIdx(userList.indexOf(currentUser));
	        Executions.createComponents("/WEB-INF/pages/userForm.zul", null, map);
	    }

	    @Command
	    public void deleteThisCustomer() {
	    	int OkCancel;

	        String str = "The Selected  Customer LastName \""
	                + currentUser.getUsername() + "\" will be deleted.";
	        /* OkCancel = Messagebox.show(str, "Confirm", Messagebox.OK
	                | Messagebox.CANCEL, Messagebox.QUESTION);
	        if (OkCancel == Messagebox.CANCEL) {
	            return;
	        }*/

	        str = "The Selected Customer LastName \""
	                + currentUser.getUsername()
	                + "\" will be permanently deleted and the action cannot be undone.";

	        Messagebox.show(str, "Confirm", Messagebox.OK | Messagebox.CANCEL,
			        Messagebox.QUESTION, new EventListener() {
			            @Override
			            public void onEvent(Event event) throws Exception {
			                if (((Integer) event.getData()).intValue() == Messagebox.OK) {
			                	userService.delete(currentUser);
			                    userList.remove(userList
			                            .indexOf(currentUser));
			                    BindUtils.postNotifyChange(null, null,
			                    		UserListController.this, "userList");
			                }
			            }
			        });
	    }

		public List<User> getUserList() {
			return userList;
		}
		 // The following method will be called from CustomerCRUDVM after the save
	    // When we say Notifychange("allcustomers), then ZUL list items will be
	    // updated
	    @GlobalCommand
	    @NotifyChange("userList")
	    public void updateUserList(@BindingParam("pUser") User cust1,
	            @BindingParam("recordMode") String recordMode) {
	        if (recordMode.equals("NEW")) {
	        	userList.add(cust1);
	        } 
	        if (recordMode.equals("EDIT")) {
	        	userList.set(this.currentUserIdx, cust1);
	        }
	    }


		public User getCurrentUser() {
			return currentUser;
		}



		public void setCurrentUser(User currentUser) {
			this.currentUser = currentUser;
		}
		public Integer getCurrentUserIdx() {
			return currentUserIdx;
		}
		public void setCurrentUserIdx(Integer currentUserIdx) {
			this.currentUserIdx = currentUserIdx;
		}
		
		
}
