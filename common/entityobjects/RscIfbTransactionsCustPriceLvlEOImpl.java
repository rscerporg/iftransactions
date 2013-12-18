package oracle.apps.po.rscapps.oss.iftransactions.common.entityobjects;
import oracle.apps.fnd.framework.server.OAEntityImpl;
import oracle.jbo.server.EntityDefImpl;
import oracle.jbo.server.AttributeDefImpl;
import oracle.jbo.AttributeList;
import oracle.jbo.server.TransactionEvent;
import oracle.jbo.domain.Number;
import oracle.jbo.domain.Date;
import oracle.jbo.Key;
//  ---------------------------------------------------------------
//  ---    File generated by Oracle Business Components for Java.
//  ---------------------------------------------------------------

public class RscIfbTransactionsCustPriceLvlEOImpl extends OAEntityImpl 
{
  protected static final int CUSTOMERPARTYID = 0;
  protected static final int CUSTOMERNAME = 1;
  protected static final int PRICINGLEVELID = 2;
  protected static final int PRICINGLEVELNAME = 3;
  protected static final int CREATEDBY = 4;
  protected static final int LASTUPDATELOGIN = 5;
  protected static final int LASTUPDATEDBY = 6;
  protected static final int CREATIONDATE = 7;
  protected static final int LASTUPDATEDATE = 8;
  private static oracle.apps.fnd.framework.server.OAEntityDefImpl mDefinitionObject;

  /**
   * 
   * This is the default constructor (do not remove)
   */
  public RscIfbTransactionsCustPriceLvlEOImpl()
  {
  }

  /**
   * 
   * Retrieves the definition object for this instance class.
   */
  public static synchronized EntityDefImpl getDefinitionObject()
  {
    if (mDefinitionObject == null)
    {
      mDefinitionObject = (oracle.apps.fnd.framework.server.OAEntityDefImpl)EntityDefImpl.findDefObject("oracle.apps.po.rscapps.oss.iftransactions.common.entityobjects.RscIfbTransactionsCustPriceLvlEO");
    }
    return mDefinitionObject;
  }

  /**
   * 
   * Add attribute defaulting logic in this method.
   */
  public void create(AttributeList attributeList)
  {
    super.create(attributeList);
  }

  /**
   * 
   * Add entity remove logic in this method.
   */
  public void remove()
  {
    super.remove();
  }

  /**
   * 
   * Add Entity validation code in this method.
   */
  protected void validateEntity()
  {
    super.validateEntity();
  }

  /**
   * 
   * Add locking logic here.
   */
  public void lock()
  {
    super.lock();
  }

  /**
   * 
   * Custom DML update/insert/delete logic here.
   */
  protected void doDML(int operation, TransactionEvent e)
  {
    super.doDML(operation, e);
  }

  /**
   * 
   * Gets the attribute value for CustomerPartyId, using the alias name CustomerPartyId
   */
  public Number getCustomerPartyId()
  {
    return (Number)getAttributeInternal(CUSTOMERPARTYID);
  }

  /**
   * 
   * Sets <code>value</code> as the attribute value for CustomerPartyId
   */
  public void setCustomerPartyId(Number value)
  {
    setAttributeInternal(CUSTOMERPARTYID, value);
  }

  /**
   * 
   * Gets the attribute value for CustomerName, using the alias name CustomerName
   */
  public String getCustomerName()
  {
    return (String)getAttributeInternal(CUSTOMERNAME);
  }

  /**
   * 
   * Sets <code>value</code> as the attribute value for CustomerName
   */
  public void setCustomerName(String value)
  {
    setAttributeInternal(CUSTOMERNAME, value);
  }

  /**
   * 
   * Gets the attribute value for PricingLevelId, using the alias name PricingLevelId
   */
  public Number getPricingLevelId()
  {
    return (Number)getAttributeInternal(PRICINGLEVELID);
  }

  /**
   * 
   * Sets <code>value</code> as the attribute value for PricingLevelId
   */
  public void setPricingLevelId(Number value)
  {
    setAttributeInternal(PRICINGLEVELID, value);
  }

  /**
   * 
   * Gets the attribute value for PricingLevelName, using the alias name PricingLevelName
   */
  public String getPricingLevelName()
  {
    return (String)getAttributeInternal(PRICINGLEVELNAME);
  }

  /**
   * 
   * Sets <code>value</code> as the attribute value for PricingLevelName
   */
  public void setPricingLevelName(String value)
  {
    setAttributeInternal(PRICINGLEVELNAME, value);
  }

  /**
   * 
   * Gets the attribute value for CreatedBy, using the alias name CreatedBy
   */
  public Number getCreatedBy()
  {
    return (Number)getAttributeInternal(CREATEDBY);
  }

  /**
   * 
   * Sets <code>value</code> as the attribute value for CreatedBy
   */
  public void setCreatedBy(Number value)
  {
    setAttributeInternal(CREATEDBY, value);
  }

  /**
   * 
   * Gets the attribute value for LastUpdateLogin, using the alias name LastUpdateLogin
   */
  public Number getLastUpdateLogin()
  {
    return (Number)getAttributeInternal(LASTUPDATELOGIN);
  }

  /**
   * 
   * Sets <code>value</code> as the attribute value for LastUpdateLogin
   */
  public void setLastUpdateLogin(Number value)
  {
    setAttributeInternal(LASTUPDATELOGIN, value);
  }

  /**
   * 
   * Gets the attribute value for LastUpdatedBy, using the alias name LastUpdatedBy
   */
  public Number getLastUpdatedBy()
  {
    return (Number)getAttributeInternal(LASTUPDATEDBY);
  }

  /**
   * 
   * Sets <code>value</code> as the attribute value for LastUpdatedBy
   */
  public void setLastUpdatedBy(Number value)
  {
    setAttributeInternal(LASTUPDATEDBY, value);
  }

  /**
   * 
   * Gets the attribute value for CreationDate, using the alias name CreationDate
   */
  public Date getCreationDate()
  {
    return (Date)getAttributeInternal(CREATIONDATE);
  }

  /**
   * 
   * Sets <code>value</code> as the attribute value for CreationDate
   */
  public void setCreationDate(Date value)
  {
    setAttributeInternal(CREATIONDATE, value);
  }

  /**
   * 
   * Gets the attribute value for LastUpdateDate, using the alias name LastUpdateDate
   */
  public Date getLastUpdateDate()
  {
    return (Date)getAttributeInternal(LASTUPDATEDATE);
  }

  /**
   * 
   * Sets <code>value</code> as the attribute value for LastUpdateDate
   */
  public void setLastUpdateDate(Date value)
  {
    setAttributeInternal(LASTUPDATEDATE, value);
  }
  //  Generated method. Do not modify.

  protected Object getAttrInvokeAccessor(int index, AttributeDefImpl attrDef) throws Exception
  {
    switch (index)
      {
      case CUSTOMERPARTYID:
        return getCustomerPartyId();
      case CUSTOMERNAME:
        return getCustomerName();
      case PRICINGLEVELID:
        return getPricingLevelId();
      case PRICINGLEVELNAME:
        return getPricingLevelName();
      case CREATEDBY:
        return getCreatedBy();
      case LASTUPDATELOGIN:
        return getLastUpdateLogin();
      case LASTUPDATEDBY:
        return getLastUpdatedBy();
      case CREATIONDATE:
        return getCreationDate();
      case LASTUPDATEDATE:
        return getLastUpdateDate();
      default:
        return super.getAttrInvokeAccessor(index, attrDef);
      }
  }
  //  Generated method. Do not modify.

  protected void setAttrInvokeAccessor(int index, Object value, AttributeDefImpl attrDef) throws Exception
  {
    switch (index)
      {
      case CUSTOMERPARTYID:
        setCustomerPartyId((Number)value);
        return;
      case CUSTOMERNAME:
        setCustomerName((String)value);
        return;
      case PRICINGLEVELID:
        setPricingLevelId((Number)value);
        return;
      case PRICINGLEVELNAME:
        setPricingLevelName((String)value);
        return;
      case CREATEDBY:
        setCreatedBy((Number)value);
        return;
      case LASTUPDATELOGIN:
        setLastUpdateLogin((Number)value);
        return;
      case LASTUPDATEDBY:
        setLastUpdatedBy((Number)value);
        return;
      case CREATIONDATE:
        setCreationDate((Date)value);
        return;
      case LASTUPDATEDATE:
        setLastUpdateDate((Date)value);
        return;
      default:
        super.setAttrInvokeAccessor(index, value, attrDef);
        return;
      }
  }

  /**
   * 
   * Creates a Key object based on given key constituents
   */
  public static Key createPrimaryKey(Number customerPartyId)
  {
    return new Key(new Object[] {customerPartyId});
  }
}