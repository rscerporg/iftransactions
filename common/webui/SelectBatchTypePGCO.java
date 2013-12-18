/*===========================================================================+
 |   Copyright (c) 2001, 2005 Oracle Corporation, Redwood Shores, CA, USA    |
 |                         All rights reserved.                              |
 +===========================================================================+
 |  HISTORY                                                                  |
 +===========================================================================*/
package oracle.apps.po.rscapps.oss.iftransactions.common.webui;

import oracle.apps.fnd.common.VersionInfo;
import oracle.apps.fnd.framework.OAApplicationModule;
import oracle.apps.fnd.framework.webui.OAPageContext;
import oracle.apps.fnd.framework.webui.OAWebBeanConstants;
import oracle.apps.fnd.framework.webui.beans.OAWebBean;
import oracle.apps.po.rscapps.oss.iftransactions.common.applicationmodules.UtilityVariablesAndMethods;

/**
 * Controller for ...
 */
public class SelectBatchTypePGCO extends CommonController
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

    pageContext.writeDiagnostics(this, "Entering processRequest method", 2);

    OAApplicationModule oam = pageContext.getRootApplicationModule();
    oam.invokeMethod("createNewRow");
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

    pageContext.writeDiagnostics(this, "Entering processFormRequest method", 2);

    String actionPerformed = pageContext.getParameter("event");
    if (actionPerformed.equalsIgnoreCase("submit"))
    {
      OAApplicationModule oam = pageContext.getRootApplicationModule();
      String batchType = (String) oam.invokeMethod("getBatchType");
      if (UtilityVariablesAndMethods.UPGRADE_STR.equalsIgnoreCase(batchType))
      {
        pageContext.forwardImmediately(UtilityVariablesAndMethods.UPGRADE_BATCH_URL,
                  null,
                  OAWebBeanConstants.KEEP_MENU_CONTEXT,
                  null,
                  null,
                  true,
                  OAWebBeanConstants.ADD_BREAD_CRUMB_NO ); 
      }
      else if (UtilityVariablesAndMethods.TRADE_IN_STR.equalsIgnoreCase(batchType))   
      {   
        pageContext.forwardImmediately(UtilityVariablesAndMethods.TRADE_IN_BATCH_URL,
                  null,
                  OAWebBeanConstants.KEEP_MENU_CONTEXT,
                  null,
                  null,
                  true,
                  OAWebBeanConstants.ADD_BREAD_CRUMB_NO ); 
      }   
      else if (UtilityVariablesAndMethods.INFLUENCER_STR.equalsIgnoreCase(batchType))
      {
        pageContext.forwardImmediately(UtilityVariablesAndMethods.INFLUENCER_BATCH_URL,
                  null,
                  OAWebBeanConstants.KEEP_MENU_CONTEXT,
                  null,
                  null,
                  true,
                  OAWebBeanConstants.ADD_BREAD_CRUMB_NO );
      } 
      else if (UtilityVariablesAndMethods.MONEY_BACK_GUARANTEE_STR.equalsIgnoreCase(batchType))
      {
        pageContext.forwardImmediately(UtilityVariablesAndMethods.MONEY_BACK_GUARANTEE_BATCH_URL,
                  null,
                  OAWebBeanConstants.KEEP_MENU_CONTEXT,
                  null,
                  null,
                  true,
                  OAWebBeanConstants.ADD_BREAD_CRUMB_NO );
      }
    }

    if(actionPerformed.equalsIgnoreCase("ReturnToSummaryPG")) 
    {   
      pageContext.forwardImmediately("OA.jsp?page=/oracle/apps/po/rscapps/oss/iftransactions/common/webui/DealerSummaryPG",
              null,
              OAWebBeanConstants.KEEP_MENU_CONTEXT,
              null,
              null,
              false,
              OAWebBeanConstants.ADD_BREAD_CRUMB_NO ); 
    }    
  }    
}
