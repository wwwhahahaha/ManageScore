package nb.stp.mansco.loginandout.web.spring.controller;


import nb.stp.mansco.loginandout.service.LoginandOutManager;
import nb.stp.mansco.loginandout.domain.LoginandLogout;
import nb.stp.mansco.base.web.spring.controller.GenericController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/loginandout")
public class LogInandOutController extends GenericController<LoginandLogout,Long, LoginandOutManager> {

	@RequestMapping(method = RequestMethod.GET, value = "/index.html")
	public String index() {
		String result = "/loginandlogout/index";
		return result;
	}
	@Autowired
	public void setLoginandManager(LoginandOutManager manager) {
		this.manager=manager;
	}

}
