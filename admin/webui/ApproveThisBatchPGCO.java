/*===========================================================================+
 |   Copyright (c) 2001, 2005 Oracle Corporation, Redwood Shores, CA, USA    |
 |                         All rights reserved.                              |
 +===========================================================================+
 |  HISTORY                                                                  |
 +===========================================================================*/
package oracle.apps.po.rscapps.oss.iftransactions.admin.webui;

import java.io.Serializable;

import oracle.apps.fnd.common.MessageToken;
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
public class ApproveThisBatchPGCO extends OAControllerImpl
{
  public static final String RCS_ID="$Header$";
  public static final boolean RCS_ID_RECORDED =
        VersionInfo.recordClassVersion(RCS_ID, "%packagename%");

  private String batchIdForThisPage = "" ;
  
  public String getBatchIdForThisPage() 
  {
    return this.batchIdForThisPage;
  }

  public void setBatchIdForThisPage(String batchIdForThisPageInput) 
  {
    this.batchIdForThisPage = batchIdForThisPageInput;
  }

  /**
   * Layout and page setup logic for a region.
   * @param pageContext the current OA page context
   * @param webBean the web bean corresponding to the region
   */
  public void processRequest(OAPageContext pageContext, OAWebBean webBean)
  {
    super.processRequest(pageContext, webBean);

    pageContext.writeDiagnostics(this, "Entering ApproveThisBatchPGCO.processRequest() ", 2);
    OAApplicationModule oam = pageContext.getRootApplicationModule();

    String batchIdToInit = "" + pageContext.getSessionValue("BatchId");
    setBatchIdForThisPage(batchIdToInit);    
    pageContext.removeSessionValue("BatchId");

    // Set Page And Window Title's Dynamically
    pageContext.getPageLayoutBean().setTitle("Batch ID: " + getBatchIdForThisPage() );
    pageContext.getPageLayoutBean().setWindowTitle("Batch ID: " + getBatchIdForThisPage() );    

    Serializable paramsToAM[] = { batchIdToInit } ;
    oam.invokeMethod("initApproveThisBatchPG", paramsToAM); 

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

    pageContext.writeDiagnostics(this, "Entering ApproveThisBatchPGCO.processFormRequest() ", 2);
    String actionPerformed = pageContext.getParameter("event");

    if(actionPerformed.equalsIgnoreCase("RejectThisBatch")) 
    {   
      OAApplicationModule oam = pageContext.getRootApplicationModule();
      oam.invokeMethod("rejectThisBatch");

      MessageToken[] messageTokensObj = { new MessageToken("THIS_BATCH_NUMBER", getBatchIdForThisPage()) } ;
      OAException confirmMessage = new OAException("PO", "RSC_OSS_IFB_BATCH_REJECTED", messageTokensObj, OAException.CONFIRMATION, null);
      pageContext.putDialogMessage(confirmMessage);
    }    

    if(actionPerformed.equalsIgnoreCase("ApproveThisBatch")) 
    {   
      OAApplicationModule oam = pageContext.getRootApplicationModule();
      oam.invokeMethod("approveThisBatch");

      MessageToken[] messageTokensObj = { new MessageToken("THIS_BATCH_NUMBER", getBatchIdForThisPage()) } ;
      OAException confirmMessage = new OAException("PO", "RSC_OSS_IFB_BATCH_APPROVED", messageTokensObj, OAException.CONFIRMATION, null);
      pageContext.putDialogMessage(confirmMessage);

      pageContext.forwardImmediately("OA.jsp?page=/oracle/apps/po/rscapps/oss/iftransactions/admin/webui/ApproveBatchSummaryPG",
              null,
              OAWebBeanConstants.KEEP_MENU_CONTEXT,
              null,
              null,
              true,
              OAWebBeanConstants.ADD_BREAD_CRUMB_NO );
    } 

    if(actionPerformed.equalsIgnoreCase("ReturnToSummaryPG")) 
    {   
      pageContext.forwardImmediately("OA.jsp?page=/oracle/apps/po/rscapps/oss/iftransactions/admin/webui/ApproveBatchSummaryPG",
              null,
              OAWebBeanConstants.KEEP_MENU_CONTEXT,
              null,
              null,
              false,
              OAWebBeanConstants.ADD_BREAD_CRUMB_NO );
    }
  }

}
