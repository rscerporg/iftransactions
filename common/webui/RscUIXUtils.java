package oracle.apps.po.rscapps.oss.iftransactions.common.webui;

import oracle.apps.fnd.framework.webui.OAControllerImpl;
import oracle.apps.fnd.framework.webui.OAPageContext;
import oracle.apps.fnd.framework.webui.OAWebBeanConstants;
import oracle.apps.fnd.framework.webui.beans.OAWebBean;
import oracle.apps.fnd.framework.webui.beans.OAStyledTextBean;
import oracle.apps.fnd.framework.webui.beans.layout.OAFlowLayoutBean;
import oracle.apps.fnd.framework.webui.beans.layout.OAPageLayoutBean;


public class RscUIXUtils  extends OAControllerImpl
{

  public void insertLoggedInAsStampOnPage(OAPageContext pageContext, OAWebBean webBean) 
  {     
      // Create a flow layout region to hold the prompt and data components.
      OAFlowLayoutBean userInfo = (OAFlowLayoutBean)createWebBean(pageContext, OAWebBeanConstants.FLOW_LAYOUT_BEAN, null, "userInfo");
      OAStyledTextBean infoPrompt = (OAStyledTextBean)createWebBean(pageContext, OAWebBeanConstants.STYLED_TEXT_BEAN, null, "infoPrompt");
      OAStyledTextBean infoText = (OAStyledTextBean)createWebBean(pageContext, OAWebBeanConstants.STYLED_TEXT_BEAN, null, "infoText");

      userInfo.addIndexedChild(infoPrompt);
      userInfo.addIndexedChild(infoText);
      

      // Set the content for the prompt and the user name based on the current user. 
      // Note that the prompt should be sourced from Message Dictionary and not hard-coded as shown. 
      // Also note the inclusion of white space after 656 
      // The "User Name" text to ensure that the two Strings don't render right next to each other (the flowLayout region is whitespace sensitive)
      infoPrompt.setText("You are logged in as : ");
      infoText.setText(pageContext.getUserName());

      // Set the following styles to achieve the required look.
      infoPrompt.setCSSClass("OraPageStampText");
      infoText.setCSSClass("OraPageStampLabel");
      
      // Set the user info component on the page layout bean.
      OAPageLayoutBean pageLayout = (OAPageLayoutBean)webBean;
      pageLayout.setUserInfo(userInfo);    
  }

}