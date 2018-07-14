package nb.stp.mansco.findpasswd.web.spring.controller;

import nb.stp.mansco.base.service.GenericManager;
import nb.stp.mansco.findpasswd.service.FindPasswdManager;
import nb.stp.mansco.findpasswd.domain.FindPasswd;
import nb.stp.mansco.base.web.spring.controller.GenericController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/findpasswd")
public class FindPasswdController extends GenericController<FindPasswd, Long, FindPasswdManager> {
	@RequestMapping(method = RequestMethod.GET, value = "/index.html")
	public String index() {
		String result = "/findpasswd/index";
		return result;
	}
	@Autowired
	public void setFindPasswdManager(FindPasswdManager manager) {
		this.manager=manager;
	}
}
