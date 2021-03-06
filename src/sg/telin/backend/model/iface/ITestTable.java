package sg.telin.backend.model.iface;
import javax.persistence.Basic;


/** 
 * Object interface mapping for hibernate-handled table: test_table.
 * @author autogenerated
 */

public interface ITestTable {



    /**
     * Return the value associated with the column: field1.
	 * @return A String object (this.field1)
	 */
	String getField1();
	

  
    /**  
     * Set the value related to the column: field1.
	 * @param field1 the field1 value you wish to set
	 */
	void setField1(final String field1);

    /**
     * Return the value associated with the column: field2.
	 * @return A String object (this.field2)
	 */
	String getField2();
	

  
    /**  
     * Set the value related to the column: field2.
	 * @param field2 the field2 value you wish to set
	 */
	void setField2(final String field2);

    /**
     * Return the value associated with the column: field3.
	 * @return A String object (this.field3)
	 */
	String getField3();
	

  
    /**  
     * Set the value related to the column: field3.
	 * @param field3 the field3 value you wish to set
	 */
	void setField3(final String field3);

    /**
     * Return the value associated with the column: id.
	 * @return A String object (this.id)
	 */
	String getId();
	

  
    /**  
     * Set the value related to the column: id.
	 * @param id the id value you wish to set
	 */
	void setId(final String id);

	// end of interface
}