package struts;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import javax.servlet.http.*;

public class InsertAction extends Action {
	public ActionForward execute( 
		ActionMapping mapping, ActionForm form,
		HttpServletRequest request, HttpServletResponse response) {

		return mapping.findForward("success");
	}
}
