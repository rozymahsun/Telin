package sg.telin.controller.test;


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
import sg.telin.backend.model.TestTable;
import sg.telin.backend.service.TestTableService;



public class TestTableFormController {
	@Wire("#testTableForm")				//buat di Zul
	private Window win;

	private TestTable currentObject;
	private String recordMode;
	

	@WireVariable
	private TestTableService testTableService;

	@Init
	public void initSetup(@ContextParam(ContextType.VIEW) Component view,
			@ExecutionArgParam("sObject") TestTable c1,
			@ExecutionArgParam("recordMode") String recordMode) throws CloneNotSupportedException {
		Selectors.wireComponents(view, this, false);

		setRecordMode(recordMode);
		if (recordMode.equals(Constants.MODE_NEW)) {
			this.currentObject = new TestTable();
		}
		if (recordMode.equals(Constants.MODE_EDIT)) {
			this.currentObject = (TestTable) c1.clone();
		}
		
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Command
	public void save() {
		if (recordMode.equals(Constants.MODE_NEW)) {
			testTableService.insert(this.currentObject);
		}
		if (recordMode.equals(Constants.MODE_EDIT)) {
			testTableService.update(this.currentObject);
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
//=======end code =====	

	public TestTable getCurrentObject() {
		return currentObject;
	}

	public void setCurrentObject(TestTable currentObject) {
		this.currentObject = currentObject;
	}

	public String getRecordMode() {
		return recordMode;
	}

	public void setRecordMode(String recordMode) {
		this.recordMode = recordMode;
	}

	public TestTableService getTestTableService() {
		return testTableService;
	}

	public void setTestTableService(TestTableService testTableService) {
		this.testTableService = testTableService;
	}


}
