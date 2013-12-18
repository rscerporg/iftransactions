package oracle.apps.po.rscapps.oss.iftransactions.common.webui;

import oracle.apps.fnd.common.MessageToken;
import oracle.apps.fnd.framework.OAApplicationModule;
import oracle.apps.fnd.framework.OAException;
import oracle.apps.fnd.framework.webui.OAControllerImpl;
import oracle.apps.fnd.framework.webui.OAPageContext;
import oracle.apps.fnd.framework.webui.OAWebBeanConstants;
import oracle.apps.fnd.framework.webui.beans.OAWebBean;
import oracle.apps.po.rscapps.oss.iftransactions.common.webui.RscUIXUtils;
import java.io.Serializable;

/**
 * Common controller tasks like RscUIXUtils
 */
public class CommonController extends OAControllerImpl 
{
  public CommonController()
  {
  }

  /**
   * Layout and page setup logic for a region.
   * @param pageContext the current OA page context
   * @param webBean the web bean corresponding to the region
   */
  public void processRequest(OAPageContext pageContext, OAWebBean webBean)
  {
    super.processRequest(pageContext, webBean);

    RscUIXUtils uiUtilsObj = new RscUIXUtils();
    uiUtilsObj.insertLoggedInAsStampOnPage(pageContext, webBean);
  }

  /**
   * Procedure to handle form submissions for form elements in
   * a region.
   * @param pageContext the current OA page context
   * @param webBean the web bean corresponding to the region
   */
  public void processFormRequest(OAPageContext pageContext, OAWebBean webBean)
  {
    super.processFormRequest(pageContext, webBean);

    String actionPerformed = pageContext.getParameter("event");

    if(actionPerformed.equalsIgnoreCase("AddRowToIFBEquipmentTable")) 
    {   
      OAApplicationModule oam = pageContext.getRootApplicationModule();
      oam.invokeMethod("addRowToIFBEquipmentTable");
    }

    if(actionPerformed.equalsIgnoreCase("AddRowToOtherBrandEquipmentTable")) 
    {   
      OAApplicationModule oam = pageContext.getRootApplicationModule();
      oam.invokeMethod("addRowToOtherBrandEquipmentTable");      
    }

    if(actionPerformed.equalsIgnoreCase("AddRowToNewItemsInfoTable")) 
    {   
      OAApplicationModule oam = pageContext.getRootApplicationModule();
      oam.invokeMethod("addRowToNewItemsInfoTable");      
    }

    if(actionPerformed.equalsIgnoreCase("DeleteRowFromNewItemsInfoTable"))  
    {
      OAApplicationModule oam = pageContext.getRootApplicationModule();
      oam.invokeMethod("deleteRowFromNewItemsInfoTable"); 
    }

    if(actionPerformed.equalsIgnoreCase("DeleteRowFromOtherBrandEquipmentTable"))  
    {
      OAApplicationModule oam = pageContext.getRootApplicationModule();
      oam.invokeMethod("deleteRowFromOtherBrandEquipmentTable"); 
    }

    if(actionPerformed.equalsIgnoreCase("DeleteRowFromIFBEquipmentTable")) 
    {
      OAApplicationModule oam = pageContext.getRootApplicationModule();
      oam.invokeMethod("deleteRowFromIFBEquipmentTable"); 
    }    

    if(actionPerformed.equalsIgnoreCase("SubmitBatch")) 
    {    
      OAApplicationModule oam = pageContext.getRootApplicationModule();

      String isEligibleForSave = "" + oam.invokeMethod("isBatchEligibleForBatchSaveOperation");

      if(isEligibleForSave.equalsIgnoreCase("YES")) 
      {
        oam.invokeMethod("saveBatch");

        String thisBatchId = "" + oam.invokeMethod("getThisBatchId");
        MessageToken[] messageTokensObj = { new MessageToken("BATCH_NUMBER", thisBatchId) } ;
        OAException confirmMessage = new OAException("PO", "RSC_OSS_IFB_SUBMIT_SUCCESS", messageTokensObj, OAException.CONFIRMATION, null);
        pageContext.putDialogMessage(confirmMessage);

        pageContext.forwardImmediately("OA.jsp?page=/oracle/apps/po/rscapps/oss/iftransactions/common/webui/DealerSummaryPG",
                null,
                OAWebBeanConstants.KEEP_MENU_CONTEXT,
                null,
                null,
                true,
                OAWebBeanConstants.ADD_BREAD_CRUMB_NO );               
      }
    }
    
    if(actionPerformed.equalsIgnoreCase("CancelAndReturn")) 
    {
      pageContext.forwardImmediately("OA.jsp?page=/oracle/apps/po/rscapps/oss/iftransactions/common/webui/DealerSummaryPG",
              null,
              OAWebBeanConstants.KEEP_MENU_CONTEXT,
              null,
              null,
              false,
              OAWebBeanConstants.ADD_BREAD_CRUMB_NO );      
    }

    if(actionPerformed.equalsIgnoreCase("TradeInItemEntered")) 
    {   
      OAApplicationModule oam = pageContext.getRootApplicationModule();
      String rowReference = pageContext.getParameter(OAWebBeanConstants.EVENT_SOURCE_ROW_REFERENCE);      
      Serializable paramsToAM [] = { rowReference } ;
      oam.invokeMethod("performCalcsForTradeInItemEnteredEvent", paramsToAM);      
    }  

    if(actionPerformed.equalsIgnoreCase("ReplacementItemSerialEntered")) 
    {   
      OAApplicationModule oam = pageContext.getRootApplicationModule();
      String rowReference = pageContext.getParameter(OAWebBeanConstants.EVENT_SOURCE_ROW_REFERENCE);      
      Serializable paramsToAM [] = { rowReference } ;

      String isThisADuplicateSerial = "" + oam.invokeMethod("isThisDuplicateSerialNumber", paramsToAM);

      if(isThisADuplicateSerial.equals("NO")) 
      {
        oam.invokeMethod("performCalcsForReplacementItemSerialEnteredEvent", paramsToAM);        
      } 
      else 
      {
        throw new OAException(isThisADuplicateSerial, OAException.WARNING);
      }
    }   
  }

  public static void main(String[] args)
  {
    CommonController commonController = new CommonController();
  }
}