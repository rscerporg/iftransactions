package oracle.apps.po.rscapps.oss.iftransactions.common.viewobjects.nonentityobjects;
import oracle.apps.fnd.framework.server.OAViewRowImpl;
import oracle.jbo.server.AttributeDefImpl;
import oracle.jbo.domain.Number;
//  ---------------------------------------------------------------
//  ---    File generated by Oracle Business Components for Java.
//  ---------------------------------------------------------------

public class LPUsedVORowImpl extends OAViewRowImpl 
{
  protected static final int LPUSED = 0;


  protected static final int LPUSEDVALUE = 1;
  /**
   * 
   * This is the default constructor (do not remove)
   */
  public LPUsedVORowImpl()
  {
  }

  /**
   * 
   * Gets the attribute value for the calculated attribute Lpused
   */
  public String getLpused()
  {
    return (String)getAttributeInternal(LPUSED);
  }

  /**
   * 
   * Sets <code>value</code> as the attribute value for the calculated attribute Lpused
   */
  public void setLpused(String value)
  {
    setAttributeInternal(LPUSED, value);
  }

  /**
   * 
   * Gets the attribute value for the calculated attribute Lpusedvalue
   */
  public Number getLpusedvalue()
  {
    return (Number)getAttributeInternal(LPUSEDVALUE);
  }

  /**
   * 
   * Sets <code>value</code> as the attribute value for the calculated attribute Lpusedvalue
   */
  public void setLpusedvalue(Number value)
  {
    setAttributeInternal(LPUSEDVALUE, value);
  }
  //  Generated method. Do not modify.

  protected Object getAttrInvokeAccessor(int index, AttributeDefImpl attrDef) throws Exception
  {
    switch (index)
      {
      case LPUSED:
        return getLpused();
      case LPUSEDVALUE:
        return getLpusedvalue();
      default:
        return super.getAttrInvokeAccessor(index, attrDef);
      }
  }
  //  Generated method. Do not modify.

  protected void setAttrInvokeAccessor(int index, Object value, AttributeDefImpl attrDef) throws Exception
  {
    switch (index)
      {
      case LPUSED:
        setLpused((String)value);
        return;
      case LPUSEDVALUE:
        setLpusedvalue((Number)value);
        return;
      default:
        super.setAttrInvokeAccessor(index, value, attrDef);
        return;
      }
  }
}