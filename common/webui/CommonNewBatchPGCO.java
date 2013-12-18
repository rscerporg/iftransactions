package oracle.apps.po.rscapps.oss.iftransactions.common.webui;

import oracle.apps.fnd.framework.OAApplicationModule;
import oracle.apps.fnd.framework.webui.OAPageContext;
import oracle.apps.fnd.framework.webui.beans.OAWebBean;

/**
 * Use this class to do 
 * 1. Create the common new batch for all transaction types
 * 2. Handle the common events here
 */
public class CommonNewBatchPGCO extends CommonController
{
  public CommonNewBatchPGCO()
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

    OAApplicationModule oam = pageContext.getRootApplicationModule();
    oam.invokeMethod("createNewBatch");
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
  }

  public static void main(String[] args)
  {
    CommonNewBatchPGCO commonNewBatchPGCO = new CommonNewBatchPGCO();
  }
}