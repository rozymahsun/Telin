package sg.telin.controller.product;


import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.zkoss.bind.BindUtils;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.GlobalCommand;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.exporter.excel.ExcelExporter;
import org.zkoss.exporter.pdf.PdfExporter;
import org.zkoss.util.media.AMedia;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zul.Filedownload;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Messagebox;

import sg.telin.Constants;
import sg.telin.backend.model.ProductMap;
import sg.telin.backend.service.ProductMapService;
import sg.telin.controller.util.BaseVMController;


public class ProductMapController extends BaseVMController {
	private List<ProductMap> objectList= new ArrayList<ProductMap>();
	private ProductMap currentObject;
	private ProductMap filterObject;
	private Integer currentObjectIdx;



	@WireVariable
	private ProductMapService productMapService;

	@Init
	public void initSetup() {
		objectList= productMapService.findAll();
		filterObject = new ProductMap();
		
	}

	@Command
	public void addObject() {
		//Messagebox.show("Add New Customer Code goes here");
		final HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("sObject", null);
		map.put("recordMode", Constants.MODE_NEW);
		Executions.createComponents(Constants.PRODUCT_MAP_FORM, null, map);
	}
	@Command
	public void searchObject() {
		objectList= productMapService.findByObject(filterObject);
		BindUtils.postNotifyChange(null, null,
				ProductMapController.this, "objectList");
		
	}
	@NotifyChange("filterObject")
	@Command
	public void resetObject(){
		filterObject = new ProductMap();
		objectList= productMapService.findAll();
		BindUtils.postNotifyChange(null, null,
				ProductMapController.this, "objectList");
	}
	@Command
	public void editObject() {
		final HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("sObject", this.currentObject);
		map.put("recordMode", Constants.MODE_EDIT);
		setCurrentObjectIdx(objectList.indexOf(currentObject));
		Executions.createComponents(Constants.PRODUCT_MAP_FORM, null, map);
	}

	@Command
	public void deleteObject() {
		int OkCancel;

		String str = "The Selected  Object will be deleted.";
		/* OkCancel = Messagebox.show(str, "Confirm", Messagebox.OK
	                | Messagebox.CANCEL, Messagebox.QUESTION);
	        if (OkCancel == Messagebox.CANCEL) {
	            return;
	        }*/

		str = "The Selected Object "
			+ " "
			+ " will be permanently deleted and the action cannot be undone.";

		Messagebox.show(str, "Confirm", Messagebox.OK | Messagebox.CANCEL,
				Messagebox.QUESTION, new EventListener() {
			@Override
			public void onEvent(Event event) throws Exception {
				if (((Integer) event.getData()).intValue() == Messagebox.OK) {
					productMapService.delete(currentObject);
					objectList.remove(objectList
							.indexOf(currentObject));
					BindUtils.postNotifyChange(null, null,
							ProductMapController.this, "objectList");
				}
			}
		});
	}


	// The following method will be called from CustomerCRUDVM after the save
	// When we say Notifychange("allcustomers), then ZUL list items will be
	// updated
	@GlobalCommand
	@NotifyChange("objectList")
	public void updateObjectList(@BindingParam("retObject") ProductMap obj,
			@BindingParam("recordMode") String recordMode) {
		if (recordMode.equals(Constants.MODE_NEW)) {
			objectList.add(obj);
		} 
		if (recordMode.equals(Constants.MODE_EDIT)) {
			objectList.set(this.currentObjectIdx, obj);
		}
	}
	@Command
	public void exportPDF(@BindingParam("ref") Listbox objectListbox) throws Exception {
	    ByteArrayOutputStream out = new ByteArrayOutputStream();
	    System.out.println("export to pdf : "+ objectListbox);
	    PdfExporter exporter = new PdfExporter();
	    exporter.export(objectListbox, out);
	     
	    AMedia amedia = new AMedia("FirstReport.pdf", "pdf", "application/pdf", out.toByteArray());
	    Filedownload.save(amedia);      
	    out.close();
	}
	@Command
	public void exportListboxToExcel(@BindingParam("ref") Listbox objectListbox) throws Exception {
	    ByteArrayOutputStream out = new ByteArrayOutputStream();
	     
	    ExcelExporter exporter = new ExcelExporter();
	    exporter.export(objectListbox, out);
	     
	    AMedia amedia = new AMedia("FirstReport.xlsx", "xls", "application/file", out.toByteArray());
	    Filedownload.save(amedia);
	    out.close();
	}
	public List<ProductMap> getObjectList() {
		return objectList;
	}
	public void setObjectList(List<ProductMap> objectList) {
		this.objectList = objectList;
	}
	public ProductMap getCurrentObject() {
		return currentObject;
	}
	public void setCurrentObject(ProductMap currentObject) {
		this.currentObject = currentObject;
	}
	public Integer getCurrentObjectIdx() {
		return currentObjectIdx;
	}
	public void setCurrentObjectIdx(Integer currentObjectIdx) {
		this.currentObjectIdx = currentObjectIdx;
	}
	public ProductMapService getProductMapService() {
		return productMapService;
	}
	public void setProductMapService(ProductMapService productMapService) {
		this.productMapService = productMapService;
	}
	public ProductMap getFilterObject() {
		return filterObject;
	}
	public void setFilterObject(ProductMap filterObject) {
		this.filterObject = filterObject;
	}




}
