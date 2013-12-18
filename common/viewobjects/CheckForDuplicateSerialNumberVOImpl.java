package oracle.apps.po.rscapps.oss.iftransactions.common.viewobjects;
import oracle.apps.fnd.framework.server.OAViewObjectImpl;
//  ---------------------------------------------------------------
//  ---    File generated by Oracle Business Components for Java.
//  ---------------------------------------------------------------

public class CheckForDuplicateSerialNumberVOImpl extends OAViewObjectImpl 
{
  /**
   * 
   * This is the default constructor (do not remove)
   */
  public CheckForDuplicateSerialNumberVOImpl()
  {
  }

  /**
   * Init Query with input
   */
  public void initQuery(String itemNumberInput) 
  {
    setWhereClauseParam(0, itemNumberInput);
    executeQuery();
  }

  /**
   * Init Query
   */
  public void initQuery() 
  {
    initQuery("000");
  }
}