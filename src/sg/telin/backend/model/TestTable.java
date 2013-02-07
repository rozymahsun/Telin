package sg.telin.backend.model;

import com.felees.hbnpojogen.persistence.IPojoGenEntity;
import java.io.Serializable;
import java.util.Collections;
import java.util.Map;
import java.util.WeakHashMap;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import org.hibernate.proxy.HibernateProxy;

import sg.telin.backend.model.iface.ITestTable;


/** 
 * Object mapping for hibernate-handled table: test_table.
 * @author autogenerated
 */

@Entity
@Table(name = "test_table", catalog = "test")
public class TestTable implements Cloneable, Serializable, IPojoGenEntity, ITestTable {

	/** Serial Version UID. */
	private static final long serialVersionUID = -559017558L;

	/** Use a WeakHashMap so entries will be garbage collected once all entities 
		referring to a saved hash are garbage collected themselves. */
	private static final Map<Serializable, String> SAVED_HASHES =
		Collections.synchronizedMap(new WeakHashMap<Serializable, String>());
	
	/** hashCode temporary storage. */
	private volatile String hashCode;
	

	/** Field mapping. */
	private String field1;
	/** Field mapping. */
	private String field2;
	/** Field mapping. */
	private String field3;
	/** Field mapping. */
	private String id;
	/**
	 * Default constructor, mainly for hibernate use.
	 */
	public TestTable() {
		// Default constructor
	} 

	/** Constructor taking a given ID.
	 * @param id to set
	 */
	public TestTable(String id) {
		this.id = id;
	}
	
 


 
	/** Return the type of this class. Useful for when dealing with proxies.
	* @return Defining class.
	*/
	@Transient
	public Class<?> getClassType() {
		return TestTable.class;
	}
 

    /**
     * Return the value associated with the column: field1.
	 * @return A String object (this.field1)
	 */
	@Basic( optional = true )
	@Column( name = "field_1", length = 20  )
	public String getField1() {
		return this.field1;
		
	}
	

  
    /**  
     * Set the value related to the column: field1.
	 * @param field1 the field1 value you wish to set
	 */
	public void setField1(final String field1) {
		this.field1 = field1;
	}

    /**
     * Return the value associated with the column: field2.
	 * @return A String object (this.field2)
	 */
	@Basic( optional = true )
	@Column( name = "field_2", length = 20  )
	public String getField2() {
		return this.field2;
		
	}
	

  
    /**  
     * Set the value related to the column: field2.
	 * @param field2 the field2 value you wish to set
	 */
	public void setField2(final String field2) {
		this.field2 = field2;
	}

    /**
     * Return the value associated with the column: field3.
	 * @return A String object (this.field3)
	 */
	@Basic( optional = true )
	@Column( name = "field_3", length = 20  )
	public String getField3() {
		return this.field3;
		
	}
	

  
    /**  
     * Set the value related to the column: field3.
	 * @param field3 the field3 value you wish to set
	 */
	public void setField3(final String field3) {
		this.field3 = field3;
	}

    /**
     * Return the value associated with the column: id.
	 * @return A String object (this.id)
	 */
    @Id 
	@Basic( optional = false )
	@Column( name = "field_id", nullable = false, length = 3  )
	public String getId() {
		return this.id;
		
	}
	

  
    /**  
     * Set the value related to the column: id.
	 * @param id the id value you wish to set
	 */
	public void setId(final String id) {
		// If we've just been persisted and hashCode has been
		// returned then make sure other entities with this
		// ID return the already returned hash code
		if ( (this.id == null ) &&
				(id != null) &&
				(this.hashCode != null) ) {
		SAVED_HASHES.put( id, this.hashCode );
		}
		this.id = id;
	}


   /**
    * Deep copy.
	* @return cloned object
	* @throws CloneNotSupportedException on error
    */
    @Override
    public TestTable clone() throws CloneNotSupportedException {
		
        final TestTable copy = (TestTable)super.clone();

		copy.setField1(this.getField1());
		copy.setField2(this.getField2());
		copy.setField3(this.getField3());
		copy.setId(this.getId());
		return copy;
	}
	


	/** Provides toString implementation.
	 * @see java.lang.Object#toString()
	 * @return String representation of this class.
	 */
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		
		sb.append("field1: " + this.getField1() + ", ");
		sb.append("field2: " + this.getField2() + ", ");
		sb.append("field3: " + this.getField3() + ", ");
		sb.append("id: " + this.getId());
		return sb.toString();		
	}


	/** Equals implementation. 
	 * @see java.lang.Object#equals(java.lang.Object)
	 * @param aThat Object to compare with
	 * @return true/false
	 */
	@Override
	public boolean equals(final Object aThat) {
		Object proxyThat = aThat;
		
		if ( this == aThat ) {
			 return true;
		}

		
		if (aThat instanceof HibernateProxy) {
 			// narrow down the proxy to the class we are dealing with.
 			try {
				proxyThat = ((HibernateProxy) aThat).getHibernateLazyInitializer().getImplementation(); 
			} catch (org.hibernate.ObjectNotFoundException e) {
				return false;
		   	}
		}
		if (aThat == null)  {
			 return false;
		}
		
		final TestTable that; 
		try {
			that = (TestTable) proxyThat;
			if ( !(that.getClassType().equals(this.getClassType()))){
				return false;
			}
		} catch (org.hibernate.ObjectNotFoundException e) {
				return false;
		} catch (ClassCastException e) {
				return false;
		}
		
		
		boolean result = true;
		result = result && (((this.getId() == null) && ( that.getId() == null)) || (this.getId() != null  && this.getId().equals(that.getId())));
		result = result && (((getField1() == null) && (that.getField1() == null)) || (getField1() != null && getField1().equals(that.getField1())));
		result = result && (((getField2() == null) && (that.getField2() == null)) || (getField2() != null && getField2().equals(that.getField2())));
		result = result && (((getField3() == null) && (that.getField3() == null)) || (getField3() != null && getField3().equals(that.getField3())));
		return result;
	}
	
	/** Calculate the hashcode.
	 * @see java.lang.Object#hashCode()
	 * @return a calculated number
	 */
//	@Override
//	public int hashCode() {
//		if ( this.hashCode == null ) {
//			synchronized ( this ) {
//				if ( this.hashCode == null ) {
//					String newHashCode = null;
//
//					if ( getId() != null ) {
//					newHashCode = SAVED_HASHES.get( getId() );
//					}
//					
//					if ( newHashCode == null ) {
//						if ( getId() != null ) {
//							newHashCode = getId();
//						} else {
//						newHashCode = String.valueOf(super.hashCode());
//
//						}
//					}
//					
//					this.hashCode = newHashCode;
//				}
//			}
//		}
//	return this.hashCode.hashCode();
//	}
	

	
}
