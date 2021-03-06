package oracle.apps.po.rscapps.oss.iftransactions.common.applicationmodules;
import oracle.apps.fnd.framework.server.OAApplicationModuleImpl;
import oracle.apps.po.rscapps.oss.iftransactions.common.viewobjects.DealerViewBatchSummaryVOImpl;
import oracle.apps.po.rscapps.oss.iftransactions.common.viewobjects.IsThisUserADealerVOImpl;
import oracle.apps.po.rscapps.oss.iftransactions.common.viewobjects.IsThisUserADistributorVOImpl;
import oracle.apps.po.rscapps.oss.iftransactions.common.viewobjects.CurrentBatchVOImpl;

import oracle.jbo.Row;
import oracle.apps.po.rscapps.oss.iftransactions.common.viewobjects.RscItemsInVOImpl;
import oracle.apps.po.rscapps.oss.iftransactions.common.viewobjects.RscItemsOutVOImpl;
import oracle.apps.po.rscapps.oss.iftransactions.common.viewobjects.NonRscItemsInVOImpl;
import oracle.apps.po.rscapps.oss.iftransactions.influencer.viewobjects.TransientYesNoAndDropdownsVOImpl;
import oracle.apps.po.rscapps.oss.iftransactions.common.viewobjects.GetDropDownForTableIdandItemIdVOImpl;
import oracle.apps.po.rscapps.oss.iftransactions.moneyback.viewobjects.MBTransientYesNoAndDropdownsVOImpl;
//  ---------------------------------------------------------------
//  ---    File generated by Oracle Business Components for Java.
//  ---------------------------------------------------------------

public class BatchSummaryAMImpl extends OAApplicationModuleImpl 
{
  /**
   * 
   * This is the default constructor (do not remove)
   */
  public BatchSummaryAMImpl()
  {
  }

  /**
   * Get list of batches for this uses
   */
  public void initNonRSCDealerBatchList() 
  {
    DealerViewBatchSummaryVOImpl batchSummaryObj = getDealerViewBatchSummaryVO1();
    batchSummaryObj.initQuery();

    IsThisUserADealerVOImpl isThisADealerObj = getIsThisUserADealerVO1();
    isThisADealerObj.initQuery();
    
    IsThisUserADistributorVOImpl isThisADistributorObj = getIsThisUserADistributorVO1();    
    isThisADistributorObj.initQuery();
  }

  /**
   * Get the batch type associated with this batch
   */
  public String getThisBatchType(String batchIdInput) 
  {
    String returnValue = null;
    CurrentBatchVOImpl currBatchObj = getCurrentBatchVO1();
    currBatchObj.initQuery(batchIdInput);
    if(currBatchObj!=null)     
    {
      Row currRowObj = currBatchObj.first();
      if(currRowObj!=null) 
      {
        String thisBatchType = "" + currRowObj.getAttribute("AdditionalInfo1");
        
        if(thisBatchType!=null && thisBatchType.length() > 0 && !thisBatchType.equalsIgnoreCase("null")) 
        {
          try
          {
            returnValue = thisBatchType;
          } catch(Exception err) {
              err.printStackTrace();
          }
        }
      }
    }

    return returnValue;
  }

  /**
   * Get the current batch to view
   */
  public void initCurrentBatch(String batchIdInput) 
  {
    CurrentBatchVOImpl currentBatchObj = getCurrentBatchVO1();
    RscItemsInVOImpl rscItemsInObj = getRscItemsInVO1();
    NonRscItemsInVOImpl nonRscItemsInObj = getNonRscItemsInVO1();
    RscItemsOutVOImpl rscItemsOutObj = getRscItemsOutVO1();
    TransientYesNoAndDropdownsVOImpl transientYesNoAndDropdownsObj = getTransientYesNoAndDropdownsVO1();
    MBTransientYesNoAndDropdownsVOImpl mbTransientYesNoAndDropdownsObj = getMBTransientYesNoAndDropdownsVO1();
    
    currentBatchObj.initQuery(batchIdInput);
    rscItemsInObj.initQuery(batchIdInput);
    nonRscItemsInObj.initQuery(batchIdInput);
    rscItemsOutObj.initQuery(batchIdInput);

    // Get the values for the booleans and drop downs from the original table
    Row currentRowObj = currentBatchObj.first();
    transientYesNoAndDropdownsObj.setMaxFetchSize(0);
    Row transientYesNoAndDropdownsObjRow = transientYesNoAndDropdownsObj.createRow();
    transientYesNoAndDropdownsObjRow.setNewRowState(Row.STATUS_INITIALIZED);
    mbTransientYesNoAndDropdownsObj.setMaxFetchSize(0);
    Row mbTransientYesNoAndDropdownsObjRow = mbTransientYesNoAndDropdownsObj.createRow();
    mbTransientYesNoAndDropdownsObjRow.setNewRowState(Row.STATUS_INITIALIZED);

    setValueFromYesNo("BatteryPlan", "BatteryPlan", currentRowObj, transientYesNoAndDropdownsObjRow);
    setValueFromDropDown("Breed1", "Breed1", 1, currentRowObj, transientYesNoAndDropdownsObjRow);
    setValueFromDropDown("Sex1", "Sex1", 2, currentRowObj, transientYesNoAndDropdownsObjRow);
    setValueFromYesNo("SpayNeuter1", "SpayNeuter1", currentRowObj, transientYesNoAndDropdownsObjRow);
    setValueFromDropDown("Breed2", "Breed2", 1, currentRowObj, transientYesNoAndDropdownsObjRow);
    setValueFromDropDown("Sex2", "Sex2", 2, currentRowObj, transientYesNoAndDropdownsObjRow);
    setValueFromYesNo("SpayNeuter2", "SpayNeuter2", currentRowObj, transientYesNoAndDropdownsObjRow);
    setValueFromDropDown("Breed3", "Breed3", 1, currentRowObj, transientYesNoAndDropdownsObjRow);
    setValueFromDropDown("Sex3", "Sex3", 2, currentRowObj, transientYesNoAndDropdownsObjRow);
    setValueFromYesNo("SpayNeuter3", "SpayNeuter3", currentRowObj, transientYesNoAndDropdownsObjRow);
    setValueFromYesNo("VetLocator", "VetLocator", currentRowObj, transientYesNoAndDropdownsObjRow);
    setValueFromYesNo("VetPetsafeProducts", "VetPetsafeProducts", currentRowObj, transientYesNoAndDropdownsObjRow);
    setValueFromYesNo("LpUsed", "LPUsed", currentRowObj, mbTransientYesNoAndDropdownsObjRow);    
    setValueFromDropDown("LpType", "LPType", 3, currentRowObj, mbTransientYesNoAndDropdownsObjRow);    

    transientYesNoAndDropdownsObj.insertRow(transientYesNoAndDropdownsObjRow);
    mbTransientYesNoAndDropdownsObj.insertRow(mbTransientYesNoAndDropdownsObjRow);
  }

  /**
   * Get yes no from integer
   */
   private void setValueFromYesNo(String inputAttribute, String outputAttribute, Row currentRowObj, 
    Row transientYesNoAndDropdownsObjRow)
   {
      String attributeStr = "" + currentRowObj.getAttribute(inputAttribute);      
      if (!attributeStr.equals("null"))
      {
        int attributeValue = new Integer(attributeStr).intValue();
        String yesNoStr;
        if (attributeValue == 0)
        {
          yesNoStr = "No";
        }
         else
        {
          yesNoStr = "Yes";
        }
        transientYesNoAndDropdownsObjRow.setAttribute(outputAttribute, yesNoStr);        
      }    
   }

   /**
    * Get actual value from dro down table
    */
    private void setValueFromDropDown(String inputAttribute, String outputAttribute, int tableId, 
      Row currentRowObj, Row transientYesNoAndDropdownsObjRow)
    {
      String attributeStr = "" + currentRowObj.getAttribute(inputAttribute);      
      if (!attributeStr.equals("null"))
      {
        int attributeValue = new Integer(attributeStr).intValue();
        GetDropDownForTableIdandItemIdVOImpl getDropDownObj = getGetDropDownForTableIdandItemIdVO1();
        getDropDownObj.initQuery("" + attributeValue, "" + tableId);
        Row getDropDownObjRow = getDropDownObj.first();
        getDropDownObjRow.setNewRowState(Row.STATUS_INITIALIZED);
        transientYesNoAndDropdownsObjRow.setAttribute(outputAttribute, (String) getDropDownObjRow.getAttribute("ItemValue"));
      }          
    }

  /**
   * 
   * Sample main for debugging Business Components code using the tester.
   */
  public static void main(String[] args)
  {
    launchTester("oracle.apps.po.rscapps.oss.iftransactions.common.applicationmodules", "BatchSummaryAMLocal");
  }

  /**
   * 
   * Container's getter for DealerViewBatchSummaryVO1
   */
  public DealerViewBatchSummaryVOImpl getDealerViewBatchSummaryVO1()
  {
    return (DealerViewBatchSummaryVOImpl)findViewObject("DealerViewBatchSummaryVO1");
  }

  /**
   * 
   * Container's getter for IsThisUserADealerVO1
   */
  public IsThisUserADealerVOImpl getIsThisUserADealerVO1()
  {
    return (IsThisUserADealerVOImpl)findViewObject("IsThisUserADealerVO1");
  }

  /**
   * 
   * Container's getter for IsThisUserADistributorVO1
   */
  public IsThisUserADistributorVOImpl getIsThisUserADistributorVO1()
  {
    return (IsThisUserADistributorVOImpl)findViewObject("IsThisUserADistributorVO1");
  }

  /**
   * 
   * Container's getter for CurrentBatchVO1
   */
  public CurrentBatchVOImpl getCurrentBatchVO1()
  {
    return (CurrentBatchVOImpl)findViewObject("CurrentBatchVO1");
  }

  /**
   * 
   * Container's getter for RscItemsInVO1
   */
  public RscItemsInVOImpl getRscItemsInVO1()
  {
    return (RscItemsInVOImpl)findViewObject("RscItemsInVO1");
  }

  /**
   * 
   * Container's getter for RscItemsOutVO1
   */
  public RscItemsOutVOImpl getRscItemsOutVO1()
  {
    return (RscItemsOutVOImpl)findViewObject("RscItemsOutVO1");
  }

  /**
   * 
   * Container's getter for NonRscItemsInVO1
   */
  public NonRscItemsInVOImpl getNonRscItemsInVO1()
  {
    return (NonRscItemsInVOImpl)findViewObject("NonRscItemsInVO1");
  }


  /**
   * 
   * Container's getter for TransientYesNoAndDropdownsVO1
   */
  public TransientYesNoAndDropdownsVOImpl getTransientYesNoAndDropdownsVO1()
  {
    return (TransientYesNoAndDropdownsVOImpl)findViewObject("TransientYesNoAndDropdownsVO1");
  }

  /**
   * 
   * Container's getter for GetDropDownForTableIdandItemIdVO1
   */
  public GetDropDownForTableIdandItemIdVOImpl getGetDropDownForTableIdandItemIdVO1()
  {
    return (GetDropDownForTableIdandItemIdVOImpl)findViewObject("GetDropDownForTableIdandItemIdVO1");
  }

  /**
   * 
   * Container's getter for MBTransientYesNoAndDropdownsVO1
   */
  public MBTransientYesNoAndDropdownsVOImpl getMBTransientYesNoAndDropdownsVO1()
  {
    return (MBTransientYesNoAndDropdownsVOImpl)findViewObject("MBTransientYesNoAndDropdownsVO1");
  }
}