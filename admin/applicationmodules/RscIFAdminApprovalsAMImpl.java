package oracle.apps.po.rscapps.oss.iftransactions.admin.applicationmodules;
import com.sun.java.util.collections.ArrayList;

import oracle.apps.fnd.common.MessageToken;
import oracle.apps.fnd.framework.OAException;
import oracle.apps.fnd.framework.server.OAApplicationModuleImpl;
import oracle.apps.po.rscapps.oss.iftransactions.admin.viewobjects.BatchesPendingCreditIssueVOImpl;
import oracle.apps.po.rscapps.oss.iftransactions.admin.viewobjects.BatchesPendingIFBApprovalVOImpl;
import oracle.apps.po.rscapps.oss.iftransactions.common.viewobjects.CurrentBatchVOImpl;
import oracle.apps.po.rscapps.oss.iftransactions.common.viewobjects.NonRscItemsInVOImpl;
import oracle.apps.po.rscapps.oss.iftransactions.common.viewobjects.RscItemsInVOImpl;
import oracle.apps.po.rscapps.oss.iftransactions.common.viewobjects.RscItemsOutVOImpl;

import oracle.jbo.Row;
import oracle.jbo.domain.Number;
//  ---------------------------------------------------------------
//  ---    File generated by Oracle Business Components for Java.
//  ---------------------------------------------------------------

public class RscIFAdminApprovalsAMImpl extends OAApplicationModuleImpl 
{
  /**
   * 
   * This is the default constructor (do not remove)
   */
  public RscIFAdminApprovalsAMImpl()
  {
  }

    /**
   * 
   */
  public void initIFTransactionsAdminApprovalSummaryPGCO() 
  {
    BatchesPendingIFBApprovalVOImpl ifAdminPendingApprovalsObj = getBatchesPendingIFBApprovalVO1();
    ifAdminPendingApprovalsObj.initQuery();
  }

  /**
   * 
   */
  public void initIFTransactionsAdminIssueCreditsSummaryPGCO() 
  {
    BatchesPendingCreditIssueVOImpl ifAdminPendingSalesCreditsObj = getBatchesPendingCreditIssueVO1();
    ifAdminPendingSalesCreditsObj.initQuery();
  }

  /**
   * 
   */
  public void initIFTransactionsAdminApproveThisBatchPGCO(String batchIdInput) 
  {
    CurrentBatchVOImpl viewBatchObj = getCurrentBatchVO1();
    RscItemsOutVOImpl viewItemsOutObj = getRscItemsOutVO1();
    RscItemsInVOImpl viewRscItemsInObj = getRscItemsInVO1();
    NonRscItemsInVOImpl viewNonRscItemsInObj = getNonRscItemsInVO1();

    viewBatchObj.initQuery(batchIdInput);
    viewItemsOutObj.initQuery(batchIdInput);
    viewRscItemsInObj.initQuery(batchIdInput);
    viewNonRscItemsInObj.initQuery(batchIdInput);
  }

  /**
   * 
   */
  public String salesCreditApproved() 
  {
    String returnValue  = "NO";  
  
    ArrayList listOfExceptionToDisplay = new ArrayList();    
    BatchesPendingCreditIssueVOImpl batchesPendingCreditApprovalObj = getBatchesPendingCreditIssueVO1();
    Row[] allTableRows = batchesPendingCreditApprovalObj.getAllRowsInRange();
    if(allTableRows.length >0) 
    {
      for(int i=0 ; i<allTableRows.length ; i++) 
      {
        Row currRow = allTableRows[i];
        if(currRow!=null) 
        {
          String isRowSelected = "" + currRow.getAttribute("Transient1");
          String isRMAEntered = "" + currRow.getAttribute("AdditionalInfo15"); // Sales Number
          String batchId = "" + currRow.getAttribute("BatchId"); // Batch Id
          
          if(isRowSelected.equalsIgnoreCase("Y")) 
          {
            if( (isRMAEntered!=null) && (isRMAEntered.length()>0) && !(isRMAEntered.equalsIgnoreCase("null")) ) 
            {
              currRow.setAttribute("ApprovalNeededFrom", new Number(0) );
              currRow.setAttribute("Status", "RSC_CREDIT_APPROVED");
            }
            else 
            {
              MessageToken[] messageTokensArray = { new MessageToken("MISSING_FIELD_INFO", "Sales Credit Number" ) , new MessageToken("BATCH_MISSING_INFO", "Batch Id # " + batchId ) } ;
              listOfExceptionToDisplay.add(new OAException("PO", "RSC_OSS_IFB_ADMIN_MISSING_INFO", messageTokensArray, OAException.ERROR, null) );
            }
          }
          }
        }
      }

    if(listOfExceptionToDisplay.isEmpty()) 
    {
      saveChanges();
      returnValue = "YES";
    }
    else 
    {
      OAException.raiseBundledOAException(listOfExceptionToDisplay);  
    }

    return returnValue;
  }

  /**
   * 
   */
  public void salesCreditRejected() 
  {    
    BatchesPendingCreditIssueVOImpl batchesPendingCreditApprovalObj = getBatchesPendingCreditIssueVO1();
    Row[] allTableRows = batchesPendingCreditApprovalObj.getAllRowsInRange();
    if(allTableRows.length >0) 
    {
      for(int i=0 ; i<allTableRows.length ; i++) 
      {
        Row currRow = allTableRows[i];
        if(currRow!=null) 
        {
          String isRowSelected = "" + currRow.getAttribute("Transient1");
          if(isRowSelected.equalsIgnoreCase("Y")) 
          {
            currRow.setAttribute("ApprovalNeededFrom", new Number(0) );
            currRow.setAttribute("Status", "RSC_CREDIT_REJECTED");                  
          }
          }
        }
      }
   
    saveChanges();
    
  }

  /**
   * 
   */
  public void rejectBatches() 
  {
    BatchesPendingIFBApprovalVOImpl batchesPendingApprovalObj = getBatchesPendingIFBApprovalVO1();    
    Row[] allTableRows = batchesPendingApprovalObj.getAllRowsInRange();
    if(allTableRows.length >0) 
    {
      for(int i=0 ; i<allTableRows.length ; i++) 
      {
        Row currRow = allTableRows[i];
        if(currRow!=null) 
        {
          String isRowSelected = "" + currRow.getAttribute("Transient1");
          if(isRowSelected.equalsIgnoreCase("Y")) 
          {
            currRow.setAttribute("ApprovalNeededFrom", new Number(0) );
            currRow.setAttribute("Status", "RSC_REJECTED");                  
          }
          }
        }
      }
   
    saveChanges();
  }  

  /**
   * 
   */
  public void approveBatches() 
  {
    BatchesPendingIFBApprovalVOImpl batchesPendingApprovalObj = getBatchesPendingIFBApprovalVO1();    
    Row[] allTableRows = batchesPendingApprovalObj.getAllRowsInRange();
    if(allTableRows.length >0) 
    {
      for(int i=0 ; i<allTableRows.length ; i++) 
      {
        Row currRow = allTableRows[i];
        if(currRow!=null) 
        {
          String isRowSelected = "" + currRow.getAttribute("Transient1");
          if(isRowSelected.equalsIgnoreCase("Y")) 
          {
            currRow.setAttribute("ApprovalNeededFrom", new Number(1) );
            currRow.setAttribute("Status", "RSC_APPROVED");                  
          }
          }
        }
      }
   
    saveChanges();
  }

  /**
   * 
   */
  public void rejectThisBatch() 
  {    
    saveChanges(); // To accomodate any changes made by RSC Admin to the batch during review

    CurrentBatchVOImpl thisBatchObj = getCurrentBatchVO1();
    if(thisBatchObj!=null) 
    {
      Row currentRowObj = thisBatchObj.getRowAtRangeIndex(0);
      if(currentRowObj!=null) 
      {
        currentRowObj.setAttribute("Status", "RSC_REJECTED");
      }
    }

    saveChanges();
  }

  /**
   * 
   */
  public void approveThisBatch() 
  {
    saveChanges(); // To accomodate any changes made by RSC Admin to the batch during review

    CurrentBatchVOImpl thisBatchObj = getCurrentBatchVO1();
    if(thisBatchObj!=null) 
    {
      Row currentRowObj = thisBatchObj.getRowAtRangeIndex(0);
      if(currentRowObj!=null) 
      {
          currentRowObj.setAttribute("ApprovalNeededFrom", new Number(0) );
          currentRowObj.setAttribute("Status", "RSC_APPROVED");
      }
    }
    
    saveChanges();
  }

  /**
   * 
   */
  public void saveChanges() 
  {
    getOADBTransaction().commit();
  }  








  /**
   * 
   * Sample main for debugging Business Components code using the tester.
   */
  public static void main(String[] args)
  {
    launchTester("oracle.apps.po.rscapps.oss.iftransactions.admin.applicationmodules", "RscIFAdminApprovalsAMLocal");
  }

  /**
   * 
   * Container's getter for BatchesPendingCreditIssueVO1
   */
  public BatchesPendingCreditIssueVOImpl getBatchesPendingCreditIssueVO1()
  {
    return (BatchesPendingCreditIssueVOImpl)findViewObject("BatchesPendingCreditIssueVO1");
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
   * Container's getter for CurrentBatchVO1
   */
  public CurrentBatchVOImpl getCurrentBatchVO1()
  {
    return (CurrentBatchVOImpl)findViewObject("CurrentBatchVO1");
  }

  /**
   * 
   * Container's getter for BatchesPendingIFBApprovalVO1
   */
  public BatchesPendingIFBApprovalVOImpl getBatchesPendingIFBApprovalVO1()
  {
    return (BatchesPendingIFBApprovalVOImpl)findViewObject("BatchesPendingIFBApprovalVO1");
  }




}