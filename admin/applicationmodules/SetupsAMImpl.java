package oracle.apps.po.rscapps.oss.iftransactions.admin.applicationmodules;
import oracle.apps.fnd.framework.OAException;
import oracle.apps.fnd.framework.server.OAApplicationModuleImpl;
import oracle.apps.po.rscapps.oss.iftransactions.admin.viewobjects.NewRscIfbTransactionsApprvDefnVOImpl;
import oracle.apps.po.rscapps.oss.iftransactions.admin.viewobjects.NewRscIfbTransactionsDealrDistDefnVOImpl;
import oracle.apps.po.rscapps.oss.iftransactions.common.viewobjects.CustomerPricingLevelsVOImpl;
import oracle.apps.po.rscapps.oss.iftransactions.common.viewobjects.NewSerialNumberFormatVOImpl;
import oracle.apps.po.rscapps.oss.iftransactions.common.viewobjects.TransactionsPricingInfoVOImpl;

import oracle.jbo.Row;
//  ---------------------------------------------------------------
//  ---    File generated by Oracle Business Components for Java.
//  ---------------------------------------------------------------

public class SetupsAMImpl extends OAApplicationModuleImpl 
{
  /**
   * 
   * This is the default constructor (do not remove)
   */
  public SetupsAMImpl()
  {
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
   */
  public void initApprovalHierarchySetupPG() 
  {
    NewRscIfbTransactionsApprvDefnVOImpl approvalHierarchyObj = getNewRscIfbTransactionsApprvDefnVO1();
    approvalHierarchyObj.initQuery();
  }

  /**
   * 
   */
  public void addRowToApprovalsTable() 
  {
      NewRscIfbTransactionsApprvDefnVOImpl newApprovalMappingObj = getNewRscIfbTransactionsApprvDefnVO1();      
      if (!newApprovalMappingObj.isPreparedForExecution()) 
      { 
        newApprovalMappingObj.executeQuery(); 
      } 
      
      Row row = newApprovalMappingObj.createRow();
      newApprovalMappingObj.insertRow(row);
      row.setNewRowState(Row.STATUS_INITIALIZED);    
  }  

  /**
   * 
   */
  public void deleteRowsFromApprovalsTable() 
  {
    NewRscIfbTransactionsApprvDefnVOImpl newApprovalMappingObj = getNewRscIfbTransactionsApprvDefnVO1();      
    Row[] allTableRows = newApprovalMappingObj.getAllRowsInRange();
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
            currRow.remove();
          }
        }
      }
    }

    saveChanges();
  }

  /**
   * 
   */
  public void initDefineTransactionPricingLevelsPG() 
  {
    TransactionsPricingInfoVOImpl upgradesPricingInfoObj = getTransactionsPricingInfoVO1();
    upgradesPricingInfoObj.initQuery(); 
  }

  /**
   * 
   */
  public void addRowToTransactionPricingLevelsTable() 
  {
      TransactionsPricingInfoVOImpl upgradesPricingInfoObj = getTransactionsPricingInfoVO1();
      
      if (!upgradesPricingInfoObj.isPreparedForExecution()) 
      { 
        upgradesPricingInfoObj.executeQuery(); 
      } 
      
      Row row = upgradesPricingInfoObj.createRow();
      upgradesPricingInfoObj.insertRowAtRangeIndex(0, row);
      row.setNewRowState(Row.STATUS_INITIALIZED);    
  }  

  /**
   * 
   */
  public void deleteRowsFromTransactionPricingLevelsTable() 
  {
    TransactionsPricingInfoVOImpl upgradesPricingInfoObj = getTransactionsPricingInfoVO1();
    
    Row[] allTableRows = upgradesPricingInfoObj.getAllRowsInRange();
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
            currRow.remove();
          }
        }
      }
    }
  }

  /**
   * 
   */
  public void initDefineCustomerPricingLevelPG() 
  {
    CustomerPricingLevelsVOImpl customerPricingLevelObj = getCustomerPricingLevelsVO1() ;
    customerPricingLevelObj.initQuery(); 
  }

  /**
   * 
   */
  public void addRowToDefineCustomerPricingLevelTable() 
  {
      CustomerPricingLevelsVOImpl customerPricingLevelObj = getCustomerPricingLevelsVO1() ;
      
      if (!customerPricingLevelObj.isPreparedForExecution()) 
      { 
        customerPricingLevelObj.executeQuery(); 
      } 
      
      Row row = customerPricingLevelObj.createRow();
      customerPricingLevelObj.insertRowAtRangeIndex(0, row);
      row.setNewRowState(Row.STATUS_INITIALIZED);    
  } 

  /**
   * 
   */
  public void deleteRowsFromDefineCustomerPricingLevelTable() 
  {
    CustomerPricingLevelsVOImpl customerPricingLevelObj = getCustomerPricingLevelsVO1() ;    
    
    Row[] allTableRows = customerPricingLevelObj.getAllRowsInRange();
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
            currRow.remove();
          }
        }
      }
    }
  }
  
  /**
   * 
   */
  public void initDefineSerialFormatsPG() 
  {
    NewSerialNumberFormatVOImpl serialFormatsObj = getNewSerialNumberFormatVO1();
    serialFormatsObj.initQuery(); 
  }

  /**
   * 
   */
  public void addRowsToDefineSerialFormatsTable() 
  {
      NewSerialNumberFormatVOImpl serialFormatsObj = getNewSerialNumberFormatVO1();      
      
      if (!serialFormatsObj.isPreparedForExecution()) 
      { 
        serialFormatsObj.executeQuery(); 
      } 
      
      Row row = serialFormatsObj.createRow();
      serialFormatsObj.insertRowAtRangeIndex(0, row);
      row.setNewRowState(Row.STATUS_INITIALIZED);    
  }   

  /**
   * 
   */
  public void deleteRowsFromDefineSerialFormatsTable() 
  {
    NewSerialNumberFormatVOImpl serialFormatsObj = getNewSerialNumberFormatVO1();      
    
    Row[] allTableRows = serialFormatsObj.getAllRowsInRange();
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
            currRow.remove();
          }
        }
      }
    }
  }

  /**
   * 
   */
  public void initDealerDistributorMappingsSetupPG() 
  {
  	NewRscIfbTransactionsDealrDistDefnVOImpl dealerDistDefnsObj = getNewRscIfbTransactionsDealrDistDefnVO1();
    dealerDistDefnsObj.initQuery(); 
  }

  /**
   * 
   */
  public void addRowToDealerDistributorMappingsSetupTable() 
  {
	  NewRscIfbTransactionsDealrDistDefnVOImpl dealerDistDefnsObj = getNewRscIfbTransactionsDealrDistDefnVO1();	  
      
      if (!dealerDistDefnsObj.isPreparedForExecution()) 
      { 
        dealerDistDefnsObj.executeQuery();
      } 
      
      Row row = dealerDistDefnsObj.createRow();
      dealerDistDefnsObj.insertRowAtRangeIndex(0, row);
      row.setNewRowState(Row.STATUS_INITIALIZED);  
  } 

  /**
   * 
   */
  public void deleteRowsFromDealerDistributorMappingsSetupTable() 
  {
  	NewRscIfbTransactionsDealrDistDefnVOImpl dealerDistDefnsObj = getNewRscIfbTransactionsDealrDistDefnVO1();
    
    Row [] rows = dealerDistDefnsObj.getFilteredRows("Transient1", "Y");	
	
    if(rows !=null && rows.length >0) 
    {
      for(int i=0 ; i<rows.length ; i++) 
      {
        Row currRow = rows[i];
        if(currRow!=null) 
        {
            currRow.remove();
        }
      }
    }
    else 
    {
      throw new OAException("No row(s) were selected. Please select row(s) and try again.", OAException.WARNING);
    }
  }

  /**
   * 
   * Sample main for debugging Business Components code using the tester.
   */
  public static void main(String[] args)
  {
    launchTester("oracle.apps.po.rscapps.oss.ifupgrades.server", "SetupsAMLocal");
  }

  /**
   * 
   * Container's getter for NewRscIfbTransactionsApprvDefnVO1
   */
  public NewRscIfbTransactionsApprvDefnVOImpl getNewRscIfbTransactionsApprvDefnVO1()
  {
    return (NewRscIfbTransactionsApprvDefnVOImpl)findViewObject("NewRscIfbTransactionsApprvDefnVO1");
  }

  /**
   * 
   * Container's getter for TransactionsPricingInfoVO1
   */
  public TransactionsPricingInfoVOImpl getTransactionsPricingInfoVO1()
  {
    return (TransactionsPricingInfoVOImpl)findViewObject("TransactionsPricingInfoVO1");
  }

  /**
   * 
   * Container's getter for AvailablePricingLevelsVO1
   */
  public oracle.apps.po.rscapps.oss.iftransactions.common.viewobjects.nonentityobjects.AvailablePricingLevelsVOImpl getAvailablePricingLevelsVO1()
  {
    return (oracle.apps.po.rscapps.oss.iftransactions.common.viewobjects.nonentityobjects.AvailablePricingLevelsVOImpl)findViewObject("AvailablePricingLevelsVO1");
  }

  /**
   * 
   * Container's getter for CustomerPricingLevelsVO1
   */
  public CustomerPricingLevelsVOImpl getCustomerPricingLevelsVO1()
  {
    return (CustomerPricingLevelsVOImpl)findViewObject("CustomerPricingLevelsVO1");
  }

  /**
   * 
   * Container's getter for NewSerialNumberFormatVO1
   */
  public NewSerialNumberFormatVOImpl getNewSerialNumberFormatVO1()
  {
    return (NewSerialNumberFormatVOImpl)findViewObject("NewSerialNumberFormatVO1");
  }

  /**
   * 
   * Container's getter for NewRscIfbTransactionsDealrDistDefnVO1
   */
  public NewRscIfbTransactionsDealrDistDefnVOImpl getNewRscIfbTransactionsDealrDistDefnVO1()
  {
    return (NewRscIfbTransactionsDealrDistDefnVOImpl)findViewObject("NewRscIfbTransactionsDealrDistDefnVO1");
  }


}