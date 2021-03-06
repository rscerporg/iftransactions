package oracle.apps.po.rscapps.oss.iftransactions.common.applicationmodules;
import oracle.apps.fnd.framework.server.OAApplicationModuleImpl;
import oracle.apps.po.rscapps.oss.iftransactions.common.viewobjects.nonentityobjects.CreateBatchTypeVOImpl;

import oracle.jbo.Row;
//  ---------------------------------------------------------------
//  ---    File generated by Oracle Business Components for Java.
//  ---------------------------------------------------------------

public class BatchTypeAMImpl extends OAApplicationModuleImpl 
{
  /**
   * 
   * This is the default constructor (do not remove)
   */
  public BatchTypeAMImpl()
  {
  }

  /**
   * Create a new row
   */
  public void createNewRow() 
  {
      CreateBatchTypeVOImpl batchObj = getCreateBatchTypeVO1();
      batchObj.initQuery();
      Row batchRow = batchObj.first();
      batchRow.setNewRowState(Row.STATUS_INITIALIZED);
  }

  /**
   * 
   */
  public String getBatchType()   
  {    
    CreateBatchTypeVOImpl batchObj = getCreateBatchTypeVO1();
    Row batchRow = batchObj.getCurrentRow();
    String batchType = (String)batchRow.getAttribute("Createbatchtype");
    return batchType;
  }  


  /**
   * 
   * Sample main for debugging Business Components code using the tester.
   */
  public static void main(String[] args)
  {
    launchTester("oracle.apps.po.rscapps.oss.iftransactions.common.applicationmodules", "BatchTypeAMLocal");
  }

  /**
   * 
   * Container's getter for CreateBatchTypeVO1
   */
  public CreateBatchTypeVOImpl getCreateBatchTypeVO1()
  {
    return (CreateBatchTypeVOImpl)findViewObject("CreateBatchTypeVO1");
  }


}