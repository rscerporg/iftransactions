/*===========================================================================+
 |   Copyright (c) 2001, 2005 Oracle Corporation, Redwood Shores, CA, USA    |
 |                         All rights reserved.                              |
 +===========================================================================+
 |  HISTORY                                                                  |
 +===========================================================================*/
package oracle.apps.po.rscapps.oss.iftransactions.common.webui;

import oracle.apps.fnd.common.VersionInfo;
import oracle.apps.fnd.framework.OAApplicationModule;
import oracle.apps.fnd.framework.webui.OAControllerImpl;
import oracle.apps.fnd.framework.webui.OAPageContext;
import oracle.apps.fnd.framework.webui.OAWebBeanConstants;
import oracle.apps.fnd.framework.webui.beans.OAWebBean;
import oracle.apps.po.rscapps.oss.iftransactions.common.webui.RscUIXUtils;
import oracle.apps.po.rscapps.oss.iftransactions.common.applicationmodules.UtilityVariablesAndMethods;
import java.io.Serializable;

/**
 * Controller for ...
 */
public class DealerSummaryPGCO extends OAControllerImpl
{
  public static final String RCS_ID="$Header$";
  public static final boolean RCS_ID_RECORDED =
        VersionInfo.recordClassVersion(RCS_ID, "%packagename%");

  /**
   * Layout and page setup logic for a region.
   * @param pageContext the current OA page context
   * @param webBean the web bean corresponding to the region
   */
  public void processRequest(OAPageContext pageContext, OAWebBean webBean)
  {
    super.processRequest(pageContext, webBean);

    pageContext.writeDiagnostics(this, "Entering DealerSummaryPGCO.processRequest() ", 2);
    OAApplicationModule oam = pageContext.getRootApplicationModule();
    oam.invokeMethod("initNonRSCDealerBatchList");

    String creditMemoColumnNameTemp = "CreditMemoAdv";

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

    pageContext.writeDiagnostics(this, "Entering DealerSummaryPGCO.processFormRequest() ", 2);
    String actionPerformed = pageContext.getParameter("event");

    if(actionPerformed.equalsIgnoreCase("RefreshThisPage")) 
    {   
      pageContext.forwardImmediately("OA.jsp?page=/oracle/apps/po/rscapps/oss/iftransactions/common/webui/DealerSummaryPG",
              null,
              OAWebBeanConstants.KEEP_MENU_CONTEXT,
              null,
              null,
              false,
              OAWebBeanConstants.ADD_BREAD_CRUMB_NO ); 
    }

    if (actionPerformed.equalsIgnoreCase("GoToDetailPG") )
    {
      String returnIdPassed = (String) pageContext.getParameter("BatchId");
      pageContext.putSessionValue("BatchId", returnIdPassed);

      // Handler based on batch type
      OAApplicationModule oam = pageContext.getRootApplicationModule(); 
      Serializable paramsToAM[] = { returnIdPassed } ;      
      String batchType = (String) oam.invokeMethod("getThisBatchType", paramsToAM); 
      if (UtilityVariablesAndMethods.UPGRADE_STR.equalsIgnoreCase(batchType))
      {                 
        pageContext.forwardImmediately(UtilityVariablesAndMethods.UPGRADE_SUMMARY_URL,
                  null,
                  OAWebBeanConstants.KEEP_MENU_CONTEXT,
                  null,
                  null,
                  true,
                  OAWebBeanConstants.ADD_BREAD_CRUMB_NO ); 
      }
      else if (UtilityVariablesAndMethods.TRADE_IN_STR.equalsIgnoreCase(batchType))   
      {   
        pageContext.forwardImmediately(UtilityVariablesAndMethods.TRADE_IN_SUMMARY_URL,
                  null,
                  OAWebBeanConstants.KEEP_MENU_CONTEXT,
                  null,
                  null,
                  true,
                  OAWebBeanConstants.ADD_BREAD_CRUMB_NO ); 
      }   
      else if (UtilityVariablesAndMethods.INFLUENCER_STR.equalsIgnoreCase(batchType))
      {
        pageContext.forwardImmediately(UtilityVariablesAndMethods.INFLUENCER_SUMMARY_URL,
                  null,
                  OAWebBeanConstants.KEEP_MENU_CONTEXT,
                  null,
                  null,
                  true,
                  OAWebBeanConstants.ADD_BREAD_CRUMB_NO );
      } 
      else if (UtilityVariablesAndMethods.MONEY_BACK_GUARANTEE_STR.equalsIgnoreCase(batchType))
      {
        pageContext.forwardImmediately(UtilityVariablesAndMethods.MONEY_BACK_GUARANTEE_SUMMARY_URL,
                  null,
                  OAWebBeanConstants.KEEP_MENU_CONTEXT,
                  null,
                  null,
                  true,
                  OAWebBeanConstants.ADD_BREAD_CRUMB_NO );
      }          
    }
    
    if (actionPerformed.equalsIgnoreCase("CreateNewBatch") )
    {
      pageContext.forwardImmediately("OA.jsp?page=/oracle/apps/po/rscapps/oss/iftransactions/common/webui/SelectBatchTypePG",
            null,
            OAWebBeanConstants.KEEP_MENU_CONTEXT,
            null,
            null,
            false,
            OAWebBeanConstants.ADD_BREAD_CRUMB_NO);
    }
  }

}
