package sg.telin.controller.product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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

import sg.telin.Constants;
import sg.telin.backend.model.ProductCode;
import sg.telin.backend.model.ProductMap;
import sg.telin.backend.service.ProductCodeService;
import sg.telin.backend.service.ProductMapService;


public class ProductMapFormController {
	@Wire("#productMapForm")
	private Window win;

	private ProductMap currentObject;
	private String recordMode;
	private List<ProductCode> producCodeList= new ArrayList<ProductCode>();
	private ProductCode producCodeObject;
	

	@WireVariable
	private ProductMapService productMapService;
	@WireVariable
	private ProductCodeService productCodeService;

	@Init
	public void initSetup(@ContextParam(ContextType.VIEW) Component view,
			@ExecutionArgParam("sObject") ProductMap c1,
			@ExecutionArgParam("recordMode") String recordMode) throws CloneNotSupportedException {
		Selectors.wireComponents(view, this, false);

		setRecordMode(recordMode);
		if (recordMode.equals(Constants.MODE_NEW)) {
			this.currentObject = new ProductMap();
		}
		if (recordMode.equals(Constants.MODE_EDIT)) {
			this.currentObject = (ProductMap) c1.clone();
			this.producCodeObject = new ProductCode();
			this.producCodeObject.setId(this.currentObject.getProductCode());
			this.producCodeObject.setProductCodeShortDesc(this.currentObject.getMainProduct());
		}
		
		initProductCodeList();
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Command
	public void save() {
		if(producCodeObject!=null){
			this.currentObject.setProductCode(this.producCodeObject.getId());
			this.currentObject.setMainProduct(this.getProducCodeObject().getProductCodeShortDesc());
		}
		if (recordMode.equals(Constants.MODE_NEW)) {
			productMapService.insert(this.currentObject);
		}
		if (recordMode.equals(Constants.MODE_EDIT)) {
			productMapService.update(this.currentObject);
		}
		Map args = new HashMap();
		args.put("retObject", this.currentObject);
		args.put("recordMode", this.recordMode);
		BindUtils.postGlobalCommand(null, null, "updateObjectList", args);
		win.detach();
	}

	@Command
	public void close() {
		win.detach();
	}
	
	public void initProductCodeList(){
		producCodeList = productCodeService.findAll();
	}
	

	public ProductMap getCurrentObject() {
		return currentObject;
	}

	public void setCurrentObject(ProductMap currentObject) {
		this.currentObject = currentObject;
	}

	public String getRecordMode() {
		return recordMode;
	}

	public void setRecordMode(String recordMode) {
		this.recordMode = recordMode;
	}

	public ProductMapService getProductMapService() {
		return productMapService;
	}

	public void setProductMapService(ProductMapService productMapService) {
		this.productMapService = productMapService;
	}

	public List<ProductCode> getProducCodeList() {
		return producCodeList;
	}

	public void setProducCodeList(List<ProductCode> producCodeList) {
		this.producCodeList = producCodeList;
	}

	public ProductCode getProducCodeObject() {
		return producCodeObject;
	}

	public void setProducCodeObject(ProductCode producCodeObject) {
		this.producCodeObject = producCodeObject;
	}

	public ProductCodeService getProductCodeService() {
		return productCodeService;
	}

	public void setProductCodeService(ProductCodeService productCodeService) {
		this.productCodeService = productCodeService;
	}

}
