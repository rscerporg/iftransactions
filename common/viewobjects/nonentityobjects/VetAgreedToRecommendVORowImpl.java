package oracle.apps.po.rscapps.oss.iftransactions.common.viewobjects.nonentityobjects;
import oracle.apps.fnd.framework.server.OAViewRowImpl;
import oracle.jbo.server.AttributeDefImpl;
import oracle.jbo.domain.Number;
//  ---------------------------------------------------------------
//  ---    File generated by Oracle Business Components for Java.
//  ---------------------------------------------------------------

public class VetAgreedToRecommendVORowImpl extends OAViewRowImpl 
{




  protected static final int VETAGREEDTORECOMMEND = 0;
  protected static final int VETAGREEDTORECOMMENDVALUE = 1;
  /**
   * 
   * This is the default constructor (do not remove)
   */
  public VetAgreedToRecommendVORowImpl()
  {
  }

  /**
   * 
   * Gets the attribute value for the calculated attribute Vetagreedtorecommend
   */
  public String getVetagreedtorecommend()
  {
    return (String)getAttributeInternal(VETAGREEDTORECOMMEND);
  }

  /**
   * 
   * Sets <code>value</code> as the attribute value for the calculated attribute Vetagreedtorecommend
   */
  public void setVetagreedtorecommend(String value)
  {
    setAttributeInternal(VETAGREEDTORECOMMEND, value);
  }
  //  Generated method. Do not modify.

  protected Object getAttrInvokeAccessor(int index, AttributeDefImpl attrDef) throws Exception
  {
    switch (index)
      {
      case VETAGREEDTORECOMMEND:
        return getVetagreedtorecommend();
      case VETAGREEDTORECOMMENDVALUE:
        return getVetagreedtorecommendvalue();
      default:
        return super.getAttrInvokeAccessor(index, attrDef);
      }
  }
  //  Generated method. Do not modify.

  protected void setAttrInvokeAccessor(int index, Object value, AttributeDefImpl attrDef) throws Exception
  {
    switch (index)
      {
      case VETAGREEDTORECOMMEND:
        setVetagreedtorecommend((String)value);
        return;
      case VETAGREEDTORECOMMENDVALUE:
        setVetagreedtorecommendvalue((Number)value);
        return;
      default:
        super.setAttrInvokeAccessor(index, value, attrDef);
        return;
      }
  }

  /**
   * 
   * Gets the attribute value for the calculated attribute Vetagreedtorecommendvalue
   */
  public Number getVetagreedtorecommendvalue()
  {
    return (Number)getAttributeInternal(VETAGREEDTORECOMMENDVALUE);
  }

  /**
   * 
   * Sets <code>value</code> as the attribute value for the calculated attribute Vetagreedtorecommendvalue
   */
  public void setVetagreedtorecommendvalue(Number value)
  {
    setAttributeInternal(VETAGREEDTORECOMMENDVALUE, value);
  }
}