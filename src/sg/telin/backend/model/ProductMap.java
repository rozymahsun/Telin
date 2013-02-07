package sg.telin.backend.model;

import com.felees.hbnpojogen.persistence.IPojoGenEntity;
import java.io.Serializable;
import java.util.Collections;
import java.util.Map;
import java.util.WeakHashMap;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import org.hibernate.proxy.HibernateProxy;

import sg.telin.backend.model.iface.IProductMap;


/** 
 * Object mapping for hibernate-handled table: product_map.
 * @author autogenerated
 */

@Entity
@Table(name = "product_map", catalog = "test")
public class ProductMap implements Cloneable, Serializable, IPojoGenEntity, IProductMap {

	/** Serial Version UID. */
	private static final long serialVersionUID = -559017559L;

	/** Use a WeakHashMap so entries will be garbage collected once all entities 
		referring to a saved hash are garbage collected themselves. */
	private static final Map<Serializable, Integer> SAVED_HASHES =
		Collections.synchronizedMap(new WeakHashMap<Serializable, Integer>());
	
	/** hashCode temporary storage. */
	private volatile Integer hashCode;
	

	/** Field mapping. */
	private Integer id = 0; // init for hibernate bug workaround
	/** Field mapping. */
	private String licenseFee;
	/** Field mapping. */
	private String mainProduct;
	/** Field mapping. */
	private String prodcutMapUnit;
	/** Field mapping. */
	private String productCode;
	/** Field mapping. */
	private String productGroup;
	/** Field mapping. */
	private String productMapCategory;
	/** Field mapping. */
	private String productMapGst;
	/** Field mapping. */
	private String revGlCode;
	/** Field mapping. */
	private String stdListPrice;
	/**
	 * Default constructor, mainly for hibernate use.
	 */
	public ProductMap() {
		// Default constructor
	} 

	/** Constructor taking a given ID.
	 * @param id to set
	 */
	public ProductMap(Integer id) {
		this.id = id;
	}
	
 


 
	/** Return the type of this class. Useful for when dealing with proxies.
	* @return Defining class.
	*/
	@Transient
	public Class<?> getClassType() {
		return ProductMap.class;
	}
 

    /**
     * Return the value associated with the column: id.
	 * @return A Integer object (this.id)
	 */
    @Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic( optional = false )
	@Column( name = "product_map_id", nullable = false  )
	public Integer getId() {
		return this.id;
		
	}
	

  
    /**  
     * Set the value related to the column: id.
	 * @param id the id value you wish to set
	 */
	public void setId(final Integer id) {
		// If we've just been persisted and hashCode has been
		// returned then make sure other entities with this
		// ID return the already returned hash code
		if ( (this.id == null || this.id == 0) &&
				(id != null) &&
				(this.hashCode != null) ) {
		SAVED_HASHES.put( id, this.hashCode );
		}
		this.id = id;
	}

    /**
     * Return the value associated with the column: licenseFee.
	 * @return A Integer object (this.licenseFee)
	 */
	@Basic( optional = true )
	@Column( name = "license_fee"  )
	public String getLicenseFee() {
		return this.licenseFee;
		
	}
	

  
    /**  
     * Set the value related to the column: licenseFee.
	 * @param licenseFee the licenseFee value you wish to set
	 */
	public void setLicenseFee(final String licenseFee) {
		this.licenseFee = licenseFee;
	}

    /**
     * Return the value associated with the column: mainProduct.
	 * @return A String object (this.mainProduct)
	 */
	@Basic( optional = true )
	@Column( name = "main_product", length = 50  )
	public String getMainProduct() {
		return this.mainProduct;
		
	}
	

  
    /**  
     * Set the value related to the column: mainProduct.
	 * @param mainProduct the mainProduct value you wish to set
	 */
	public void setMainProduct(final String mainProduct) {
		this.mainProduct = mainProduct;
	}

    /**
     * Return the value associated with the column: prodcutMapUnit.
	 * @return A String object (this.prodcutMapUnit)
	 */
	@Basic( optional = true )
	@Column( name = "prodcut_map_unit", length = 50  )
	public String getProdcutMapUnit() {
		return this.prodcutMapUnit;
		
	}
	

  
    /**  
     * Set the value related to the column: prodcutMapUnit.
	 * @param prodcutMapUnit the prodcutMapUnit value you wish to set
	 */
	public void setProdcutMapUnit(final String prodcutMapUnit) {
		this.prodcutMapUnit = prodcutMapUnit;
	}

    /**
     * Return the value associated with the column: productCode.
	 * @return A String object (this.productCode)
	 */
	@Basic( optional = true )
	@Column( name = "product_code", length = 3  )
	public String getProductCode() {
		return this.productCode;
		
	}
	

  
    /**  
     * Set the value related to the column: productCode.
	 * @param productCode the productCode value you wish to set
	 */
	public void setProductCode(final String productCode) {
		this.productCode = productCode;
	}

    /**
     * Return the value associated with the column: productGroup.
	 * @return A String object (this.productGroup)
	 */
	@Basic( optional = true )
	@Column( name = "product_group", length = 50  )
	public String getProductGroup() {
		return this.productGroup;
		
	}
	

  
    /**  
     * Set the value related to the column: productGroup.
	 * @param productGroup the productGroup value you wish to set
	 */
	public void setProductGroup(final String productGroup) {
		this.productGroup = productGroup;
	}

    /**
     * Return the value associated with the column: productMapCategory.
	 * @return A String object (this.productMapCategory)
	 */
	@Basic( optional = true )
	@Column( name = "product_map_category", length = 50  )
	public String getProductMapCategory() {
		return this.productMapCategory;
		
	}
	

  
    /**  
     * Set the value related to the column: productMapCategory.
	 * @param productMapCategory the productMapCategory value you wish to set
	 */
	public void setProductMapCategory(final String productMapCategory) {
		this.productMapCategory = productMapCategory;
	}

    /**
     * Return the value associated with the column: productMapGst.
	 * @return A String object (this.productMapGst)
	 */
	@Basic( optional = true )
	@Column( name = "product_map_gst", length = 50  )
	public String getProductMapGst() {
		return this.productMapGst;
		
	}
	

  
    /**  
     * Set the value related to the column: productMapGst.
	 * @param productMapGst the productMapGst value you wish to set
	 */
	public void setProductMapGst(final String productMapGst) {
		this.productMapGst = productMapGst;
	}

    /**
     * Return the value associated with the column: revGlCode.
	 * @return A String object (this.revGlCode)
	 */
	@Basic( optional = true )
	@Column( name = "rev_gl_code", length = 100  )
	public String getRevGlCode() {
		return this.revGlCode;
		
	}
	

  
    /**  
     * Set the value related to the column: revGlCode.
	 * @param revGlCode the revGlCode value you wish to set
	 */
	public void setRevGlCode(final String revGlCode) {
		this.revGlCode = revGlCode;
	}

    /**
     * Return the value associated with the column: stdListPrice.
	 * @return A String object (this.stdListPrice)
	 */
	@Basic( optional = true )
	@Column( name = "std_list_price", length = 50  )
	public String getStdListPrice() {
		return this.stdListPrice;
		
	}
	

  
    /**  
     * Set the value related to the column: stdListPrice.
	 * @param stdListPrice the stdListPrice value you wish to set
	 */
	public void setStdListPrice(final String stdListPrice) {
		this.stdListPrice = stdListPrice;
	}


   /**
    * Deep copy.
	* @return cloned object
	* @throws CloneNotSupportedException on error
    */
    @Override
    public ProductMap clone() throws CloneNotSupportedException {
		
        final ProductMap copy = (ProductMap)super.clone();

		copy.setId(this.getId());
		copy.setLicenseFee(this.getLicenseFee());
		copy.setMainProduct(this.getMainProduct());
		copy.setProdcutMapUnit(this.getProdcutMapUnit());
		copy.setProductCode(this.getProductCode());
		copy.setProductGroup(this.getProductGroup());
		copy.setProductMapCategory(this.getProductMapCategory());
		copy.setProductMapGst(this.getProductMapGst());
		copy.setRevGlCode(this.getRevGlCode());
		copy.setStdListPrice(this.getStdListPrice());
		return copy;
	}
	


	/** Provides toString implementation.
	 * @see java.lang.Object#toString()
	 * @return String representation of this class.
	 */
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		
		sb.append("id: " + this.getId() + ", ");
		sb.append("licenseFee: " + this.getLicenseFee() + ", ");
		sb.append("mainProduct: " + this.getMainProduct() + ", ");
		sb.append("prodcutMapUnit: " + this.getProdcutMapUnit() + ", ");
		sb.append("productCode: " + this.getProductCode() + ", ");
		sb.append("productGroup: " + this.getProductGroup() + ", ");
		sb.append("productMapCategory: " + this.getProductMapCategory() + ", ");
		sb.append("productMapGst: " + this.getProductMapGst() + ", ");
		sb.append("revGlCode: " + this.getRevGlCode() + ", ");
		sb.append("stdListPrice: " + this.getStdListPrice());
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
		
		final ProductMap that; 
		try {
			that = (ProductMap) proxyThat;
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
		result = result && (((getLicenseFee() == null) && (that.getLicenseFee() == null)) || (getLicenseFee() != null && getLicenseFee().equals(that.getLicenseFee())));
		result = result && (((getMainProduct() == null) && (that.getMainProduct() == null)) || (getMainProduct() != null && getMainProduct().equals(that.getMainProduct())));
		result = result && (((getProdcutMapUnit() == null) && (that.getProdcutMapUnit() == null)) || (getProdcutMapUnit() != null && getProdcutMapUnit().equals(that.getProdcutMapUnit())));
		result = result && (((getProductCode() == null) && (that.getProductCode() == null)) || (getProductCode() != null && getProductCode().equals(that.getProductCode())));
		result = result && (((getProductGroup() == null) && (that.getProductGroup() == null)) || (getProductGroup() != null && getProductGroup().equals(that.getProductGroup())));
		result = result && (((getProductMapCategory() == null) && (that.getProductMapCategory() == null)) || (getProductMapCategory() != null && getProductMapCategory().equals(that.getProductMapCategory())));
		result = result && (((getProductMapGst() == null) && (that.getProductMapGst() == null)) || (getProductMapGst() != null && getProductMapGst().equals(that.getProductMapGst())));
		result = result && (((getRevGlCode() == null) && (that.getRevGlCode() == null)) || (getRevGlCode() != null && getRevGlCode().equals(that.getRevGlCode())));
		result = result && (((getStdListPrice() == null) && (that.getStdListPrice() == null)) || (getStdListPrice() != null && getStdListPrice().equals(that.getStdListPrice())));
		return result;
	}
	
	/** Calculate the hashcode.
	 * @see java.lang.Object#hashCode()
	 * @return a calculated number
	 *//*
	@Override
	public int hashCode() {
		if ( this.hashCode == null ) {
			synchronized ( this ) {
				if ( this.hashCode == null ) {
					Integer newHashCode = null;

					if ( getId() != null ) {
					newHashCode = SAVED_HASHES.get( getId() );
					}
					
					if ( newHashCode == null ) {
						if ( getId() != null && getId() != 0) {
							newHashCode = getId();
						} else {

						}
					}
					
					this.hashCode = newHashCode;
				}
			}
		}
	return this.hashCode;
	}*/
	

	
}