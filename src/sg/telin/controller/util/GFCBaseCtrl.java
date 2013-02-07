/**
 * Copyright 2010 the original author or authors.
 * 
 * This file is part of Zksample2. http://zksample2.sourceforge.net/
 *
 * Zksample2 is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * Zksample2 is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Zksample2.  If not, see <http://www.gnu.org/licenses/gpl.html>.
 */
package sg.telin.controller.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.apache.commons.io.FileUtils;
import org.springframework.security.access.annotation.Secured;
import org.zkforge.ckez.CKeditor;
import org.zkoss.zk.ui.event.CreateEvent;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.ForwardEvent;
import org.zkoss.zk.ui.sys.ComponentsCtrl;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Comboitem;
import org.zkoss.zul.Datebox;
import org.zkoss.zul.Intbox;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Radio;
import org.zkoss.zul.Radiogroup;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Window;

import sg.telin.UserWorkspace;



/**
 * Base controller for creating the controllers of the zul files with the spring
 * framework.
 * 
 * @changes 05/18/2010 sge cleaned up from old stuff.
 * 
 * @author bbruhns
 * @author sgerth
 */
abstract public class GFCBaseCtrl extends GenericForwardComposer implements Serializable {

	private static final long serialVersionUID = -1171206258809472640L;

	protected transient Map<String, Object> args;
	

	/**
	 * Get the params map that are overhanded at creation time. <br>
	 * Reading the params that are binded to the createEvent.<br>
	 * 
	 * @param event
	 * @return params map
	 */
	@SuppressWarnings("unchecked")
	public Map<String, Object> getCreationArgsMap(Event event) {
		CreateEvent ce = (CreateEvent) ((ForwardEvent) event).getOrigin();
		return (Map<String, Object>) ce.getArg();
	}

	@SuppressWarnings("unchecked")
	public void doOnCreateCommon(Window w, Event fe) throws Exception {
		CreateEvent ce = (CreateEvent) ((ForwardEvent) fe).getOrigin();
		args = (Map<String, Object>) ce.getArg();
	}

	private transient UserWorkspace userWorkspace;
	

	/**
	 * Workaround! Do not use it otherwise!
	 */
	@Override
	public void onEvent(Event evt) throws Exception {
		final Object controller = getController();
		final Method mtd = ComponentsCtrl.getEventMethod(controller.getClass(), evt.getName());

		if (mtd != null) {
			isAllowed(mtd);
		}
		super.onEvent(evt);
	}

	/**
	 * With this method we get the @Secured Annotation for a method.<br>
	 * Captured the method call and check if it's allowed. <br>
	 * sample: @Secured({"rightName"})
	 * 
	 * @param mtd
	 */
	private void isAllowed(Method mtd) {
		Annotation[] annotations = mtd.getAnnotations();
		for (Annotation annotation : annotations) {
			if (annotation instanceof Secured) {
				Secured secured = (Secured) annotation;
				for (String rightName : secured.value()) {
					if (!userWorkspace.isAllowed(rightName)) {
						throw new SecurityException("Call of this method is not allowed! Missing right: \n\n" + "needed RightName: " + rightName + "\n\n" + "Method: " + mtd);
					}
				}
				return;
			}
		}
	}
	protected void setDateBoxValue(Datebox comp,Date val){
		if(val!=null)
			comp.setValue(val);
	}
	protected void setLblValue(org.zkoss.zul.Label comp,String val){
		if (val==null) comp.setValue("");
		comp.setValue(val);
	}
	protected void setTxtValue(Textbox comp,String val){
		if(val==null) comp.setValue("");
		comp.setValue(val);
	}

	protected void setIntTxtValue(Intbox comp,Integer val){
		if(val==null) comp.setValue(0);
		comp.setValue(val);
	}
	protected Date getDateBoxValue(Datebox comp){
		return comp.getValue();
	}
	protected String getTxtValue(Textbox comp){
		return comp.getValue();
	}
	protected Integer getIntTxtValue(Intbox comp){
		if(comp!=null)
			if(comp.getValue()!=null)
				return comp.getValue();
		return 0;
	}
	protected void setComboValue(Combobox cb,Integer val){
		Integer temp = null;
		if(val!=null){
		if(cb!=null) {
			for (int i = 0; i < cb.getItemCount(); i++) {			
				temp = (Integer) cb.getItemAtIndex(i).getValue();
				if (temp.intValue() == val.intValue()) {
					cb.setSelectedIndex(i);
				}
			}		
		}
		}
	}
	protected void setComboValue(Combobox cb,String val){
		String temp = null;
		if(val!=null){
		if(cb!=null) {
			for (int i = 0; i < cb.getItemCount(); i++) {			
				temp = (String) cb.getItemAtIndex(i).getValue();
				if (temp.equals(val)) {
					cb.setSelectedIndex(i);
				}
			}		
		}
		}
	}
	protected void setComboLabel(Combobox cb,String lbl){
		String temp = null;
		if(lbl!=null){
		if(cb!=null) {
			for (int i = 0; i < cb.getItemCount(); i++) {			
				temp = (String) cb.getItemAtIndex(i).getLabel();
				if (temp.equals(lbl)) {
					cb.setSelectedIndex(i);
				}
			}		
		}
		}
	}
	
	static Locale ina = new Locale("in", "ID", "ID");
	
	protected String getIndonesiaCurrency(String value){
		if(value==null){
			return "";
		}else if(value.length()<=3)
			return value;
		try{
		Long val = parseLong(value);
		
		NumberFormat myFormatter = NumberFormat.getInstance(ina);		

		String inaCurrency = myFormatter.format(val.longValue());		
		//String inaCurrency = myFormatter.format(val);		
		return inaCurrency;
		}catch(Exception ex){
			
		}
		return value;
	}
	
	protected String getDecimalFormat(String pattern, Double value){
		DecimalFormat myFormatter = new DecimalFormat(pattern);
		String output = myFormatter.format(value);
		return output;		
	}
	
	protected Integer getComboValue(Combobox cb){
		Comboitem item = cb.getSelectedItem();
		if(item==null) return null;
		/*if((item.getValue().toString()).equals("0"))
			return null;*/
		String id = item.getValue().toString();
		return Integer.valueOf(id);
	}
	protected String getComboValueString(Combobox cb){
		Comboitem item = cb.getSelectedItem();
		if(item==null) return null;
//		if((item.getValue().toString()).equals("0"))
//			return null;
		String id = item.getValue().toString();
		return id;
	}
	protected String getComboLabel(Combobox cb){
		Comboitem item = cb.getSelectedItem();
		if(item==null) return null;
		String label = item.getLabel();
		return label;
	}
	protected Comboitem createComboitem(Integer value,String label){
		Comboitem item=new Comboitem(label);
		if(item==null) return null;
		item.setValue(value);
		return item;
	}
	protected Comboitem createComboitem(String value,String label){
		Comboitem item=new Comboitem(label);
		item.setValue(value);
		return item;
	}
	protected Radio createRadioButton(Integer value,String label){
		Radio item=new Radio(label);
		if (value!=null)
			item.setValue(String.valueOf(value));
		else
			item.setValue(null);
		return item;
	}
	protected void clearComboBox(Combobox cb){
		cb.getItems().clear();
	}
	List<String> months;
	
	protected void createMonthsData(){
		months = new ArrayList<String>();
		months.add("Januari");
		months.add("Februari");
		months.add("Maret");
		months.add("April");
		months.add("Mei");
		months.add("Juni");
		months.add("Juli");
		months.add("Agustus");
		months.add("September");
		months.add("Oktober");
		months.add("November");
		months.add("Desember");
	}
	
	protected void initMonth(Combobox cb){
		createMonthsData();
		Calendar cal = Calendar.getInstance();
		int month = cal.get(Calendar.MONTH)-1;
		int i=1;
		for(String obj : months){
			Comboitem item=new Comboitem(obj);
			item.setValue(Integer.valueOf(i));
			cb.appendChild(createComboitem(Integer.valueOf(i),obj));
			i++;
        }	
		cb.setSelectedIndex(month);
	}
	protected void initYear(Combobox cb){
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR)-10;
		
		for(int i=0;i<12;i++){
			String obj = String.valueOf(year);
			Comboitem item=new Comboitem(obj);
			item.setValue(Integer.valueOf(i));
			cb.appendChild(createComboitem(Integer.valueOf(year),obj));
			year++;
        }
		cb.setSelectedIndex(10);
		if(cal.get(Calendar.MONTH)==1)
			cb.setSelectedIndex(9);
	}
	protected Integer getRadiogroupValue(Radiogroup rg){
		Integer value=new Integer(0);
		try{
			if(rg!=null){
				Radio radioValue = rg.getSelectedItem();
				if(radioValue==null) return value;
				String strVal = radioValue.getValue();
				value = Integer.valueOf(strVal);
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return value;
	}
	protected String getRadiogroupStringValue(Radiogroup rg){
		String value=new String("");
		try{
			if(rg!=null){
				Radio radioValue = rg.getSelectedItem();
				if(radioValue==null) return value;
				String strVal = radioValue.getValue();
				value = strVal;
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return value;
	}
	protected void setRadioGroupValue(Radiogroup rg,String value){
		try{
			if(rg!=null){
			List<Radio> radios = rg.getItems();
				for(Radio radioValue :radios){
					if(radioValue.getValue().equals(value)){
						rg.setSelectedItem(radioValue);
						return;
					}
				}
				
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	protected void disabledRadioGroup(Radiogroup rg,boolean status){
		try{
			if(rg!=null){
			List<Radio> radios = rg.getItems();
				for(Radio radioValue :radios){
					radioValue.setDisabled(status);
				}
				
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	protected String getRadiogroupLabel(Radiogroup rg){
		String value="";
		try{
			if(rg!=null){
				Radio radioValue = rg.getSelectedItem();
				if(radioValue!=null)
					value = radioValue.getLabel();
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return value;
	}
	protected String toStringYear(Integer year){
		if(year!=null){
			String strYear=String.valueOf(year);
					if(strYear.length()==1){
						strYear = "0"+strYear;
					}
				return strYear;
		}
		return "";
	}
	protected String toStringMonth(Integer month){
		if(month!=null){
			String strMonth=String.valueOf(month);
					if(strMonth.length()==1){
						strMonth = "0"+strMonth;
					}
				return strMonth;
		}
		return "";
	}
	protected Integer parseInt(String str){
		if(str!=null){
			try{
			Integer  intMonth=Integer.parseInt(str);
				return intMonth;
			}catch (Exception ex){
				ex.printStackTrace();
			}
		}
		return 0;
	}
	protected Long parseLong(String str){
		if(str!=null){
			try{
			Long  val=Long.parseLong(str);
				return val;
			}catch (Exception ex){
				ex.printStackTrace();
			}
		}
		return new Long(0);
	}
	protected Double parseDouble(String str){
		if(str!=null){
			try{
				str=str.replaceAll(",", "\\.");
				Double  val=Double.parseDouble(str);
				return val;
			}catch (Exception ex){
				ex.printStackTrace();
			}
		}
		return new Double(0);
	}
 
	protected String parseString(Double str){
		if(str!=null){
			try{
				String  val= Double.toString(str);
				return val;
			}catch (Exception ex){
				ex.printStackTrace();
			}
		}
		return new String();
	}
 
	
	final protected UserWorkspace getUserWorkspace() {
		return userWorkspace;
	}

	public void setUserWorkspace(UserWorkspace userWorkspace) {
		this.userWorkspace = userWorkspace;
	}

	public void message(String msg) throws InterruptedException {
		Messagebox.show(msg, "Warning", Messagebox.OK,
				Messagebox.EXCLAMATION);
	}
	public void messageInfo(String msg) throws InterruptedException {
		Messagebox.show(msg, "Information", Messagebox.OK,
				Messagebox.INFORMATION);
	}
	
	public void createZipFromMultipleFiles(String zipFile, String[] sourceFiles){
		 try
         {
			 byte[] buffer = new byte[1024];                         
			 FileOutputStream fout = new FileOutputStream(zipFile);                 
	         ZipOutputStream zout = new ZipOutputStream(fout);
	          System.out.println("array size : "+sourceFiles.length);
	          for(int i=0; i < sourceFiles.length; i++)
	          {	                
	                 System.out.println("Adding " + sourceFiles[i]);
	                 FileInputStream fin = new FileInputStream(sourceFiles[i]);
	                 File file = new File(sourceFiles[i]);
	                 zout.putNextEntry(new ZipEntry(file.getName()));
	                 int length;
	
	                 while((length = fin.read(buffer)) > 0)
	                 {
	                    zout.write(buffer, 0, length);
	                 }	
	                  zout.closeEntry();	
	                  fin.close();	                
	          }	        
	           zout.close();	          
	           System.out.println("Zip file has been created!");
	
			 }
			 catch(IOException ioe)
			 {
			         System.out.println("IOException :" + ioe);
			 }	
	}
	
	public void createZipFolder(String namaFolder,String namaZip){
		try
		{
			
				File inFolder=new File(namaFolder);
				File outFolder=new File(namaZip);
				ZipOutputStream out = new ZipOutputStream(new 
						BufferedOutputStream(new FileOutputStream(outFolder)));
				BufferedInputStream in = null;
				byte[] data  = new byte[1000];
				String files[] = inFolder.list();
				if(files!=null){
					for (int i=0; i<files.length; i++)
					{
						in = new BufferedInputStream(new FileInputStream
								(inFolder.getPath() + "/" + files[i]), 1000);  
						out.putNextEntry(new ZipEntry(files[i])); 
						int count;
						while((count = in.read(data,0,1000)) != -1)
						{
							out.write(data, 0, count);
						}
						out.closeEntry();
					}
					out.flush();
					out.close();
					
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		} 
	}
	public void createDirectory(String folderName){
		File file = new File(folderName);
		if(file.exists()){
			try {
				FileUtils.cleanDirectory(file);
				FileUtils.deleteDirectory(file);
				System.out.println("============ Directory Deleted =====================");
				file = new File(folderName);
				boolean wasDirecotyMade = file.mkdirs();
			    if(wasDirecotyMade)System.out.println(" ============== Directory Created ============");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else{
		    boolean wasDirecotyMade = file.mkdirs();
		    if(wasDirecotyMade)System.out.println(" ============== Directory Created ============");
		    else System.out.println("Sorry could not create directory");
		}
	}
	public boolean removeDirectory(File directory) {

		 System.out.println("===================== RemoveDirectory " + directory);

		if (directory == null)
			return false;
		if (!directory.exists())
			return true;
		if (!directory.isDirectory())
			return false;

		String[] list = directory.list();

		// Some JVMs return null for File.list() when the
		// directory is empty.
		if (list != null) {
			for (int i = 0; i < list.length; i++) {
				File entry = new File(directory, list[i]);

				//        System.out.println("\tremoving entry " + entry);

				if (entry.isDirectory())
				{
					if (!removeDirectory(entry))
						return false;
				}
				else
				{
					if (!entry.delete())
						return false;
				}
			}
		}

		return directory.delete();
	}

	
	protected static <T> T[] insertElementToArray(T[] arr, T element) {
	    final int N = arr.length;
	    arr = Arrays.copyOf(arr, N + 1);
	    arr[N] = element;
	    return arr;
	}
	
	protected String deviationFormat(String val){
		String result="";
		//System.out.println("nilai Format Deviasi "+val);
		Double percentage= new Double (0);
		try{
			percentage = Double.valueOf(val);
		//	System.out.println("Double "+percentage);
			result = getDecimalFormat("###.##", percentage);
		}catch (Exception ex){
			if(val!=null)
				result  = val;
			else
				result="";
		}
		
		return result;
	}
	
	protected void setTxtValueFromCke(CKeditor comp,String val){
		if(val==null) comp.setValue("");
		comp.setValue(val);
	}
	protected String getTxtValueFromCke(CKeditor comp){
		return comp.getValue();
	}

	
}
