package oracle.apps.po.rscapps.oss.iftransactions.common.webui;

import oracle.apps.fnd.framework.OAApplicationModule;
import oracle.apps.fnd.framework.webui.OAPageContext;
import oracle.apps.fnd.framework.webui.OAWebBeanConstants;
import oracle.apps.fnd.framework.webui.beans.OAWebBean;
import java.io.Serializable;

public class CommonSummaryBatchPGCO extends CommonController
{
  // Batch id for this page
  private String batchIdForThisPage = "" ;

  public CommonSummaryBatchPGCO()
  {
  }

  // Get the batch id
  public String getBatchIdForThisPage() 
  {
    return this.batchIdForThisPage;
  }

  // Set the batch id
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

    pageContext.writeDiagnostics(this, "Entering processRequest method", 2);        

    String batchIdToInit = "" + pageContext.getSessionValue("BatchId");
    setBatchIdForThisPage(batchIdToInit);    
//    pageContext.removeSessionValue("BatchId");

    OAApplicationModule oam = pageContext.getRootApplicationModule();
    Serializable paramsToAM[] = { batchIdToInit } ;
    oam.invokeMethod("initCurrentBatch", paramsToAM);
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

  public static void main(String[] args)
  {
    CommonSummaryBatchPGCO commonSummaryBatchPGCO = new CommonSummaryBatchPGCO();
  }
}