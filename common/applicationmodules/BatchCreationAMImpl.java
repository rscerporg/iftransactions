package oracle.apps.po.rscapps.oss.iftransactions.common.applicationmodules;
import com.sun.java.util.collections.ArrayList;

import oracle.apps.fnd.common.MessageToken;
import oracle.apps.fnd.framework.OAException;
import oracle.apps.fnd.framework.server.OAApplicationModuleImpl;
import oracle.apps.po.rscapps.oss.iftransactions.common.viewobjects.CheckForDuplicateSerialNumberVOImpl;
import oracle.apps.po.rscapps.oss.iftransactions.common.viewobjects.CurrentBatchVOImpl;
import oracle.apps.po.rscapps.oss.iftransactions.common.viewobjects.GetCreditForThisUserVOImpl;
import oracle.apps.po.rscapps.oss.iftransactions.common.viewobjects.GetProductNameFromProductIdVOImpl;
import oracle.apps.po.rscapps.oss.iftransactions.common.viewobjects.NewBatchVOImpl;
import oracle.apps.po.rscapps.oss.iftransactions.common.viewobjects.NewNonRscItemsInVOImpl;
import oracle.apps.po.rscapps.oss.iftransactions.common.viewobjects.NewRscItemsInVOImpl;
import oracle.apps.po.rscapps.oss.iftransactions.common.viewobjects.NewRscItemsOutVOImpl;
import oracle.apps.po.rscapps.oss.iftransactions.common.viewobjects.PetinfoBreedDropdownVOImpl;
import oracle.apps.po.rscapps.oss.iftransactions.common.viewobjects.PetinfoSexDropdownVOImpl;
import oracle.apps.po.rscapps.oss.iftransactions.common.viewobjects.nonentityobjects.BatteryPlanVOImpl;
import oracle.apps.po.rscapps.oss.iftransactions.common.viewobjects.nonentityobjects.CreateBatchTypeVOImpl;
import oracle.apps.po.rscapps.oss.iftransactions.common.viewobjects.nonentityobjects.PetinfoSpayNeuterVOImpl;

import oracle.jbo.Row;
import oracle.jbo.domain.Number;
import oracle.apps.po.rscapps.oss.iftransactions.common.viewobjects.LPTypeDropDownVOImpl;
import oracle.apps.po.rscapps.oss.iftransactions.common.viewobjects.nonentityobjects.LPUsedVOImpl;
//  ---------------------------------------------------------------
//  ---    File generated by Oracle Business Components for Java.
//  ---------------------------------------------------------------

public class BatchCreationAMImpl extends OAApplicationModuleImpl 
{
  /**
   * 
   * This is the default constructor (do not remove)
   */
  public BatchCreationAMImpl()
  {
    super();
  }

  /**
   * Create a new batch
   */
  public void createNewBatch() 
  {
    NewBatchVOImpl newBatch = getNewBatchVO1();
    newBatch.setMaxFetchSize(0);
    Row newBatchRow = newBatch.getCurrentRow();
    if (newBatchRow == null)
    {
      newBatchRow = newBatch.createRow();
      newBatchRow.setNewRowState(Row.STATUS_INITIALIZED);
      newBatch.insertRow(newBatchRow);
    }
  }

  /**
   * Set the batch type
   */
   public void setBatchType(String batchType)
   {
    NewBatchVOImpl newBatch = getNewBatchVO1();
    Row newBatchRow = newBatch.getCurrentRow();
    if (newBatchRow != null)
    {
      newBatchRow.setAttribute("AdditionalInfo1", batchType);
    }
   }

  /**
   * Get the batch Id associated with this new row being created
   */
  public Number getThisBatchId() 
  {
    Number returnValue = null;
    NewBatchVOImpl currBatchObj = getNewBatchVO1();
    if(currBatchObj!=null) 
    {
      Row currRowObj = currBatchObj.getCurrentRow();
      if(currRowObj!=null) 
      {
        String thisBatchId = "" + currRowObj.getAttribute("BatchId");
        
        if(thisBatchId!=null && thisBatchId.length() > 0 && !thisBatchId.equalsIgnoreCase("null")) 
        {
          try
          {
            returnValue = new Number (thisBatchId);
          } catch(Exception err) {
              err.printStackTrace();
          }
        }
      }
    }
    return returnValue;
  }

  /**
   * 
   */
  public void addRowToIFBEquipmentTable() 
  {
      NewRscItemsInVOImpl newRscItemsInObj = getNewRscItemsInVO1();
      newRscItemsInObj.setMaxFetchSize(0);
      Row newRowObj = newRscItemsInObj.createRow();
      newRowObj.setNewRowState(Row.STATUS_INITIALIZED);
      newRowObj.setAttribute("IsRscItem", "YES");
      newRowObj.setAttribute("BatchId", getThisBatchId());
      newRscItemsInObj.insertRow(newRowObj);
  }

  /**
   * 
   */
  public void addRowToOtherBrandEquipmentTable() 
  {
      NewNonRscItemsInVOImpl newNonRscItemsInObj = getNewNonRscItemsInVO1();
      newNonRscItemsInObj.setMaxFetchSize(0);
      Row newRowObj = newNonRscItemsInObj.createRow();
      newRowObj.setNewRowState(Row.STATUS_INITIALIZED);
      newRowObj.setAttribute("IsRscItem", "NO");
      newRowObj.setAttribute("BatchId", getThisBatchId());      
      newNonRscItemsInObj.insertRow(newRowObj);
  }

  /**
   * 
   */
  public void addRowToNewItemsInfoTable() 
  {
      NewRscItemsOutVOImpl newItemsOutObj = getNewRscItemsOutVO1(); 
      newItemsOutObj.setMaxFetchSize(0);
      Row newRowObj = newItemsOutObj.createRow();
      newRowObj.setNewRowState(Row.STATUS_INITIALIZED);
      newRowObj.setAttribute("BatchId", getThisBatchId());      
      newItemsOutObj.insertRow(newRowObj);
  }

  /**
   * 
   */
  public void deleteRowFromIFBEquipmentTable() 
  {
    NewRscItemsInVOImpl vo = getNewRscItemsInVO1();

    if (vo.isPreparedForExecution())   
    {       
      Row [] rows = vo.getFilteredRows("Transient1", "Y");
      if(rows!=null) 
      {
        for(int i=0;i<rows.length;i++) 
        {
          if(rows[i]!=null) 
          {
            rows[i].remove();
          }
        }
      }
    }
  }

  /**
   * 
   */
  public void deleteRowFromOtherBrandEquipmentTable() 
  {
    NewNonRscItemsInVOImpl vo = getNewNonRscItemsInVO1();

    if (vo.isPreparedForExecution())   
    {       
      Row [] rows = vo.getFilteredRows("Transient1", "Y");
      if(rows!=null) 
      {
        for(int i=0;i<rows.length;i++) 
        {
          if(rows[i]!=null) 
          {
            rows[i].remove();
          }
        }
      }
    }
  }

  /**
   * 
   */
  public void deleteRowFromNewItemsInfoTable() 
  {
    NewRscItemsOutVOImpl vo =  getNewRscItemsOutVO1();

    if (vo.isPreparedForExecution())   
    {       
      Row [] rows = vo.getFilteredRows("Transient1", "Y");
      if(rows!=null) 
      {
        for(int i=0;i<rows.length;i++) 
        {
          if(rows[i]!=null) 
          {
            rows[i].remove();
          }
        }
      }
    }
  }  

  /**
   * Checks whether all the mandatory fields have been entered.
   * Doing this programmatically instead of using the UIX "IsRequired" flag - as the UIX route 
   * will prevent any PPR from happening on the page (Eg: add rows to table) unless data exists in the mandatory fields.
   * What can I say ... Life is @#$@#$@ good !!!
   */
  public String isBatchEligibleForBatchSaveOperation() 
  {
    String returnValue = "NO";
    /* *******************************************************
       Mandatory Fields For Batch Has Been Defined As Follows:
                Name
                Phone
                Email

                PurchaseDate // Added on 09/20 ... 
                BatchType    // Added on 09/26 ... This field is mapped to AdditionalInfo1

                Old Equipment
                  Serial #

                Other Brand Traded-In
                  Manufacturer
	
                New Equipment
                  Serial

                Dealer Signature
                  
    ********************************************************* */
    NewBatchVOImpl batchObj = getNewBatchVO1();

    ArrayList listOfExceptionToDisplay = new ArrayList();
    
    if(batchObj!=null) 
    {
      Row currentRowObj = batchObj.getCurrentRow();
      if(currentRowObj!=null) 
      {        
        String nameFieldValue = "" + currentRowObj.getAttribute("CustInfoName");
        String phoneFieldValue = "" + currentRowObj.getAttribute("CustInfoPhone");
        String emailFieldValue = "" + currentRowObj.getAttribute("CustInfoEmail");
        String dealerSignatureFieldValue = "" + currentRowObj.getAttribute("DealerSignature");
        String purchaseDateValue = "" + currentRowObj.getAttribute("PurchaseDate");

        if( nameFieldValue==null || nameFieldValue.equalsIgnoreCase("null") || nameFieldValue.length()==0 ) 
        {
          MessageToken[] messageTokensArray = { new MessageToken("MISSING_FIELD_INFO", "\"Name\"") } ;
          listOfExceptionToDisplay.add(new OAException("PO", "RSC_OSS_IFB_BATCH_MISSING_INFO", messageTokensArray, OAException.ERROR, null) );
        }

        if( phoneFieldValue==null || phoneFieldValue.equalsIgnoreCase("null") || phoneFieldValue.length()==0 ) 
        {
          MessageToken[] messageTokensArray = { new MessageToken("MISSING_FIELD_INFO", "\"Phone\"") } ;
          listOfExceptionToDisplay.add(new OAException("PO", "RSC_OSS_IFB_BATCH_MISSING_INFO", messageTokensArray, OAException.ERROR, null) );
        }

        if( emailFieldValue==null || emailFieldValue.equalsIgnoreCase("null") || emailFieldValue.length()==0 ) 
        {
          MessageToken[] messageTokensArray = { new MessageToken("MISSING_FIELD_INFO", "\"Email\"") } ;
          listOfExceptionToDisplay.add(new OAException("PO", "RSC_OSS_IFB_BATCH_MISSING_INFO", messageTokensArray, OAException.ERROR, null) );
        }      

        if( dealerSignatureFieldValue==null || dealerSignatureFieldValue.equalsIgnoreCase("null") || dealerSignatureFieldValue.length()==0 ) 
        {
          MessageToken[] messageTokensArray = { new MessageToken("MISSING_FIELD_INFO", "\"Dealer Signature\"") } ;
          listOfExceptionToDisplay.add(new OAException("PO", "RSC_OSS_IFB_BATCH_MISSING_INFO", messageTokensArray, OAException.ERROR, null) );          
        }
        if( purchaseDateValue==null || purchaseDateValue.equalsIgnoreCase("null") || purchaseDateValue.length()==0 ) 
        {
          MessageToken[] messageTokensArray = { new MessageToken("MISSING_FIELD_INFO", "\"Date Of Installation\"") } ;
          listOfExceptionToDisplay.add(new OAException("PO", "RSC_OSS_IFB_BATCH_MISSING_INFO", messageTokensArray, OAException.ERROR, null) );          
        }
      }
    }

    if(listOfExceptionToDisplay.isEmpty()) 
    {
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
  public void performCalcsForTradeInItemEnteredEvent(String rowReferenceInput) 
  {
    Row rowToUpdate = findRowByRef(rowReferenceInput);
    if(rowToUpdate!=null) 
    {
      String serialNumEntered = "" + rowToUpdate.getAttribute("TradeInItemSerialNum");
      if(serialNumEntered!=null && !serialNumEntered.equalsIgnoreCase("null") && serialNumEntered.length()>0) 
      {
        String itemIdentifier = serialNumEntered.substring(0,2);
        String itemNameDerivedFromItemIdentifier = initProductNameFromProductId(itemIdentifier) ;
        if(itemNameDerivedFromItemIdentifier!=null) 
        {
          rowToUpdate.setAttribute("TradeInItemModelName", itemNameDerivedFromItemIdentifier);
        }
      }
    }
  }

  /**
   * 
   */
  public String initProductNameFromProductId(String productIdInput) 
  {
    String returnValue = "N/A";
    
    GetProductNameFromProductIdVOImpl tempObj = getGetProductNameFromProductIdVO1();
    tempObj.initQuery(productIdInput);
    Row currRowObj = tempObj.getRowAtRangeIndex(0);

    if(currRowObj!=null) 
    {
      String itemModelTemp = "" + currRowObj.getAttribute("ModuleNumber");
      if(itemModelTemp!=null && itemModelTemp.length()>0 && !itemModelTemp.equalsIgnoreCase("null")) 
      {
        returnValue = itemModelTemp;
      }
    }

    return returnValue;
  }

  /**
   * Updated on 09/20 to ignore serial numbers in batches that have been rejected - 
   * based on request from Angela Shreve and Jen Davis
   * Changes were only required in the VO SQL to accomodate this requirement.
   * I'm adding this comment in here - just so that I won't forget when/why this happened.
   */
  public String isThisDuplicateSerialNumber(String rowReferenceInput)  
  {
    String returnValue = "NO";
      
    Row rowToUpdate = findRowByRef(rowReferenceInput);
    
    if(rowToUpdate!=null) 
    {
      String serialNumEntered = "" + rowToUpdate.getAttribute("ReplacementItemSerialNum");
      if(serialNumEntered!=null && !serialNumEntered.equalsIgnoreCase("null") && serialNumEntered.length()>0)  
      {
        CheckForDuplicateSerialNumberVOImpl checkForDuplicatesObj = getCheckForDuplicateSerialNumberVO1();
        checkForDuplicatesObj.initQuery(serialNumEntered);

        int rowCountInRange = checkForDuplicatesObj.getRowCountInRange();
        
        if(rowCountInRange>0) 
        {
          Row currRow = checkForDuplicatesObj.getRowAtRangeIndex(0) ;
          if(currRow!=null) 
          {
            String batchIdTemp = "" + currRow.getAttribute("BatchId");
            String modelNameTemp = "" + currRow.getAttribute("ReplacementItemModelName");
            String serialNumberTemp = "" + currRow.getAttribute("ReplacementItemSerialNum");         

            returnValue = "This serial number is a duplicate. It has already been accounted for in Batch Id # " + batchIdTemp + ". Please contact the System Administrator if you feel this is incorrect.";
          }
        }
      }      
    }   

    return returnValue;
  }

  /**
   * 
   */
  public void performCalcsForReplacementItemSerialEnteredEvent(String rowReferenceInput) 
  {
    Row rowToUpdate = findRowByRef(rowReferenceInput);
    
    if(rowToUpdate!=null) 
    {
      String serialNumEntered = "" + rowToUpdate.getAttribute("ReplacementItemSerialNum");
      
      if(serialNumEntered!=null && !serialNumEntered.equalsIgnoreCase("null") && serialNumEntered.length()>0) 
      {
        String itemIdentifier = serialNumEntered.substring(0,2);
        String itemNameDerivedFromItemIdentifier = initProductNameFromProductId(itemIdentifier) ;
        String loggedInUser = getOADBTransaction().getUserName();
        String upgradeCreditEligible = initGetCreditForThisUser(loggedInUser, itemNameDerivedFromItemIdentifier);
        
        if(itemNameDerivedFromItemIdentifier!=null) 
        {
          rowToUpdate.setAttribute("ReplacementItemModelName", itemNameDerivedFromItemIdentifier);
        }

        if(upgradeCreditEligible!=null &&!upgradeCreditEligible.equalsIgnoreCase("null") && upgradeCreditEligible.length()>0) 
        {
          rowToUpdate.setAttribute("UpgradeCreditValue", upgradeCreditEligible);
        } 
        else 
        {
          try {
            rowToUpdate.setAttribute("UpgradeCreditValue", "0");
          } catch(Exception err) {
            err.printStackTrace();
          }
          
          // Why? Cause I needed a laugh today!
          // Pretty clever eh? :)
          OAException up = new OAException("PO", "RSC_OSS_IFB_NO_CREDIT", null, OAException.WARNING, null);
          throw up;
        }
      }
    }
  }

  /**
   * 
   */
  public String initGetCreditForThisUser(String userNameInput, String itemNameInput) 
  {
    String returnValue = null;

    GetCreditForThisUserVOImpl tempObj = getGetCreditForThisUserVO1();
    tempObj.initQuery(userNameInput, itemNameInput);

    Row currRowObj = tempObj.getRowAtRangeIndex(0);

    if(currRowObj!=null) 
    {
      try {
          returnValue = "" + currRowObj.getAttribute("Credit");
      } catch (Exception err) {
          err.printStackTrace();
          returnValue = null;
      }
    }

    return returnValue;
  }

  /**
   * Get the initial value for the battery plan boolean
   */
   public String getInitialBatteryPlanValue()
   {
      BatteryPlanVOImpl batteryPlanObj = getBatteryPlanVO1();
      batteryPlanObj.initQuery();      
      return (String) batteryPlanObj.first().getAttribute(0);
   }

  /**
   * Init PetInfo 
   */
   public void createPetinfoBatch()
   {
      PetinfoBreedDropdownVOImpl petinfoBreedDropdownObj = getPetinfoBreedDropdownVO1();
      petinfoBreedDropdownObj.initQuery();
      Row petinfoBreedDropdownRowObj = petinfoBreedDropdownObj.first();
      petinfoBreedDropdownRowObj.setNewRowState(Row.STATUS_INITIALIZED);

      PetinfoSexDropdownVOImpl petinfoSexDropdownObj = getPetinfoSexDropdownVO1();
      petinfoSexDropdownObj.initQuery();
      Row petinfoSexDropdownRowObj = petinfoSexDropdownObj.first();
      petinfoSexDropdownRowObj.setNewRowState(Row.STATUS_INITIALIZED);
      
      PetinfoSpayNeuterVOImpl petinfoSpayNeuterObj = getPetinfoSpayNeuterVO1();
      petinfoSpayNeuterObj.initQuery();
      Row petinfoSpayNeuterRowObj = petinfoSpayNeuterObj.first();
      petinfoSpayNeuterRowObj.setNewRowState(Row.STATUS_INITIALIZED);
   }

  /**
   * Init LPInfo 
   */
   public void createLPInfoBatch()
   {
      LPTypeDropDownVOImpl lpTypeDropdownObj = getLPTypeDropDownVO1();
      lpTypeDropdownObj.initQuery();
      Row lpTypeDropdownRowObj = lpTypeDropdownObj.first();
      lpTypeDropdownRowObj.setNewRowState(Row.STATUS_INITIALIZED);
   }

  /**
   * 
   */
  public void saveBatch() 
  {
    getOADBTransaction().commit();
  }
  
  /**
   * 
   * Sample main for debugging Business Components code using the tester.
   */
  public static void main(String[] args)
  {
    launchTester("oracle.apps.po.rscapps.oss.iftransactions.upgrades.applicationmodules", "UpgradesBatchSummaryAMLocal");
  }










  /**
   * 
   * Container's getter for GetProductNameFromProductIdVO1
   */
  public GetProductNameFromProductIdVOImpl getGetProductNameFromProductIdVO1()
  {
    return (GetProductNameFromProductIdVOImpl)findViewObject("GetProductNameFromProductIdVO1");
  }

  /**
   * 
   * Container's getter for CheckForDuplicateSerialNumberVO1
   */
  public CheckForDuplicateSerialNumberVOImpl getCheckForDuplicateSerialNumberVO1()
  {
    return (CheckForDuplicateSerialNumberVOImpl)findViewObject("CheckForDuplicateSerialNumberVO1");
  }

  /**
   * 
   * Container's getter for GetCreditForThisUserVO1
   */
  public GetCreditForThisUserVOImpl getGetCreditForThisUserVO1()
  {
    return (GetCreditForThisUserVOImpl)findViewObject("GetCreditForThisUserVO1");
  }

  /**
   * 
   * Container's getter for NewBatchVO1
   */
  public NewBatchVOImpl getNewBatchVO1()
  {
    return (NewBatchVOImpl)findViewObject("NewBatchVO1");
  }



  /**
   * 
   * Container's getter for NewNonRscItemsInVO1
   */
  public NewNonRscItemsInVOImpl getNewNonRscItemsInVO1()
  {
    return (NewNonRscItemsInVOImpl)findViewObject("NewNonRscItemsInVO1");
  }


  /**
   * 
   * Container's getter for NewRscItemsInVO1
   */
  public NewRscItemsInVOImpl getNewRscItemsInVO1()
  {
    return (NewRscItemsInVOImpl)findViewObject("NewRscItemsInVO1");
  }

  /**
   * 
   * Container's getter for NewRscItemsOutVO1
   */
  public NewRscItemsOutVOImpl getNewRscItemsOutVO1()
  {
    return (NewRscItemsOutVOImpl)findViewObject("NewRscItemsOutVO1");
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
   * Container's getter for PetinfoBreedDropdownVO1
   */
  public PetinfoBreedDropdownVOImpl getPetinfoBreedDropdownVO1()
  {
    return (PetinfoBreedDropdownVOImpl)findViewObject("PetinfoBreedDropdownVO1");
  }

  /**
   * 
   * Container's getter for PetinfoSexDropdownVO1
   */
  public PetinfoSexDropdownVOImpl getPetinfoSexDropdownVO1()
  {
    return (PetinfoSexDropdownVOImpl)findViewObject("PetinfoSexDropdownVO1");
  }

  /**
   * 
   * Container's getter for BatteryPlanVO1
   */
  public BatteryPlanVOImpl getBatteryPlanVO1()
  {
    return (BatteryPlanVOImpl)findViewObject("BatteryPlanVO1");
  }


  /**
   * 
   * Container's getter for CreateBatchTypeVO1
   */
  public CreateBatchTypeVOImpl getCreateBatchTypeVO1()
  {
    return (CreateBatchTypeVOImpl)findViewObject("CreateBatchTypeVO1");
  }

  /**
   * 
   * Container's getter for PetinfoSpayNeuterVO1
   */
  public PetinfoSpayNeuterVOImpl getPetinfoSpayNeuterVO1()
  {
    return (PetinfoSpayNeuterVOImpl)findViewObject("PetinfoSpayNeuterVO1");
  }

  /**
   * 
   * Container's getter for LPTypeDropDownVO1
   */
  public LPTypeDropDownVOImpl getLPTypeDropDownVO1()
  {
    return (LPTypeDropDownVOImpl)findViewObject("LPTypeDropDownVO1");
  }

  /**
   * 
   * Container's getter for LPUsedVO1
   */
  public LPUsedVOImpl getLPUsedVO1()
  {
    return (LPUsedVOImpl)findViewObject("LPUsedVO1");
  }







}