package oracle.apps.po.rscapps.oss.iftransactions.common.viewobjects.nonentityobjects;
import oracle.apps.fnd.framework.server.OAViewRowImpl;
import oracle.jbo.server.AttributeDefImpl;
//  ---------------------------------------------------------------
//  ---    File generated by Oracle Business Components for Java.
//  ---------------------------------------------------------------

public class CreateBatchTypeVORowImpl extends OAViewRowImpl
{










  protected static final int CREATEBATCHTYPE = 0;

  /**
   * 
   * This is the default constructor (do not remove)
   */
  public CreateBatchTypeVORowImpl()
  {
  }


  //  Generated method. Do not modify.

  protected Object getAttrInvokeAccessor(int index, AttributeDefImpl attrDef) throws Exception
  {
    switch (index)
      {
      case CREATEBATCHTYPE:
        return getCreatebatchtype();
      default:
        return super.getAttrInvokeAccessor(index, attrDef);
      }
  }
  //  Generated method. Do not modify.

  protected void setAttrInvokeAccessor(int index, Object value, AttributeDefImpl attrDef) throws Exception
  {
    switch (index)
      {
      case CREATEBATCHTYPE:
        setCreatebatchtype((String)value);
        return;
      default:
        super.setAttrInvokeAccessor(index, value, attrDef);
        return;
      }
  }

  /**
   * 
   * Gets the attribute value for the calculated attribute Createbatchtype
   */
  public String getCreatebatchtype()
  {
    return (String)getAttributeInternal(CREATEBATCHTYPE);
  }

  /**
   * 
   * Sets <code>value</code> as the attribute value for the calculated attribute Createbatchtype
   */
  public void setCreatebatchtype(String value)
  {
    setAttributeInternal(CREATEBATCHTYPE, value);
  }



}