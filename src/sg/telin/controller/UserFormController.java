package sg.telin.controller;

import java.util.HashMap;
import java.util.Map;

import org.zkoss.bind.BindUtils;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.bind.annotation.ExecutionArgParam;
import org.zkoss.bind.annotation.Init;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.Selectors;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zul.Window;

import sg.telin.backend.model.User;
import sg.telin.backend.service.UserService;


public class UserFormController {
	 /*
     * This is the window ID used in CustomerCRUD.Zul File. Using this only, we
     * can close the model window after save and cancel button
     */
    @Wire("#userForm")
    private Window win;

    private User currentUser;
    private String recordMode;

    @WireVariable
	 private UserService userService;
    

    @Init
    public void initSetup(@ContextParam(ContextType.VIEW) Component view,
            @ExecutionArgParam("sUser") User c1,
            @ExecutionArgParam("recordMode") String recordMode) throws CloneNotSupportedException {
        Selectors.wireComponents(view, this, false);

        setRecordMode(recordMode);
        if (recordMode.equals("NEW")) {
            this.currentUser = new User();
        }
        if (recordMode.equals("EDIT")) {
            this.currentUser = (User) c1.clone();
        }
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Command
    public void save() {
    	if (recordMode.equals("NEW")) {
            userService.insert(this.currentUser);
        }
        if (recordMode.equals("EDIT")) {
        	userService.update(this.currentUser);
        }
        Map args = new HashMap();
        args.put("pUser", this.currentUser);
        args.put("recordMode", this.recordMode);
        BindUtils.postGlobalCommand(null, null, "updateUserList", args);
        win.detach();
    }

    @Command
    public void closeThis() {
        win.detach();
    }

	public User getCurrentUser() {
		return currentUser;
	}

	public void setCurrentUser(User currentUser) {
		this.currentUser = currentUser;
	}
	public String getRecordMode() {
        return recordMode;
    }

    public void setRecordMode(String recordMode) {
        this.recordMode = recordMode;
    }

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

}
