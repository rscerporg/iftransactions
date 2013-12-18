/*===========================================================================+
 |   Copyright (c) 2001, 2005 Oracle Corporation, Redwood Shores, CA, USA    |
 |                         All rights reserved.                              |
 +===========================================================================+
 |  HISTORY                                                                  |
 +===========================================================================*/
package oracle.apps.po.rscapps.oss.iftransactions.admin.webui;

import oracle.apps.fnd.common.VersionInfo;
import oracle.apps.fnd.framework.OAApplicationModule;
import oracle.apps.fnd.framework.OAException;
import oracle.apps.fnd.framework.webui.OAControllerImpl;
import oracle.apps.fnd.framework.webui.OAPageContext;
import oracle.apps.fnd.framework.webui.OAWebBeanConstants;
import oracle.apps.fnd.framework.webui.beans.OAWebBean;
import oracle.apps.po.rscapps.oss.iftransactions.common.webui.RscUIXUtils;

/**
 * Controller for ...
 */
public class DealerDistributorMappingsSetupPGCO extends OAControllerImpl
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

    pageContext.writeDiagnostics(this, "Entering DealerDistributorMappingsSetupPGCO.processRequest() ", 2);
    OAApplicationModule oam = pageContext.getRootApplicationModule();
    oam.invokeMethod("initDealerDistributorMappingsSetupPG");    

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

    pageContext.writeDiagnostics(this, "Entering DealerDistributorMappingsSetupPGCO.processFormRequest() ", 2);
    String actionPerformed = pageContext.getParameter("event");

    if(actionPerformed.equalsIgnoreCase("AddRowToDealerDistributorMappingsSetupTable")) 
    {   
      OAApplicationModule oam = pageContext.getRootApplicationModule();
      oam.invokeMethod("addRowToDealerDistributorMappingsSetupTable");
    }    

    if(actionPerformed.equalsIgnoreCase("SaveChanges")) 
    {   
      OAApplicationModule oam = pageContext.getRootApplicationModule();
      oam.invokeMethod("saveChanges");
      throw new OAException("Changes have been saved.", OAException.CONFIRMATION);
    }  

    if(actionPerformed.equalsIgnoreCase("DeleteRowsFromDealerDistributorMappingsSetupTable")) 
    {   
      OAApplicationModule oam = pageContext.getRootApplicationModule();
      oam.invokeMethod("deleteRowsFromDealerDistributorMappingsSetupTable"); 
      throw new OAException("The selected Row(s) have been deleted.", OAException.CONFIRMATION);
    }      

    if(actionPerformed.equalsIgnoreCase("RefreshThisPage")) 
    {   
      pageContext.forwardImmediately("OA.jsp?page=/oracle/apps/po/rscapps/oss/iftransactions/admin/webui/DealerDistributorMappingsSetupPG",
            null,
            OAWebBeanConstants.KEEP_MENU_CONTEXT,
            null,
            null,
            true,
            OAWebBeanConstants.ADD_BREAD_CRUMB_NO);       
    }    
  }

}
