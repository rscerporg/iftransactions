/*===========================================================================+
 |   Copyright (c) 2001, 2005 Oracle Corporation, Redwood Shores, CA, USA    |
 |                         All rights reserved.                              |
 +===========================================================================+
 |  HISTORY                                                                  |
 +===========================================================================*/
package oracle.apps.po.rscapps.oss.iftransactions.moneyback.webui;

import java.io.Serializable;

import oracle.apps.fnd.common.VersionInfo;
import oracle.apps.fnd.framework.OAApplicationModule;
import oracle.apps.fnd.framework.webui.OAPageContext;
import oracle.apps.fnd.framework.webui.beans.OAWebBean;
import oracle.apps.po.rscapps.oss.iftransactions.common.applicationmodules.UtilityVariablesAndMethods;
import oracle.apps.po.rscapps.oss.iftransactions.common.webui.CommonNewBatchPGCO;

/**
 * Controller for ...
 */
public class CreateMoneyBackBatchPGCO extends CommonNewBatchPGCO
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
    Serializable paramsToAM[] = { UtilityVariablesAndMethods.MONEY_BACK_GUARANTEE_STR } ;      
    oam.invokeMethod("setBatchType", paramsToAM);     
    oam.invokeMethod("createPetinfoBatch");    
    oam.invokeMethod("createLPInfoBatch");    
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
  }

}
