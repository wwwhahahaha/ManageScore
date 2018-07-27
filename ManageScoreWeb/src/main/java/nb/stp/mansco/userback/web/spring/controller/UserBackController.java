package nb.stp.mansco.userback.web.spring.controller;


import nb.stp.mansco.typein.service.TypeInManager;
import nb.stp.mansco.typein.domain.TypeIn;
import nb.stp.mansco.base.web.spring.controller.GenericController;
import nb.stp.mansco.userback.domain.UserBack;
import nb.stp.mansco.userback.service.UserBackManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/userback")
public class UserBackController extends GenericController<UserBack,Long, UserBackManager> {

	@RequestMapping(method = RequestMethod.GET, value = "/index.html")
	public String index() {
		String result = "/userback/index";
		return result;
	}
	@Autowired
	public void setUserBackManager(UserBackManager manager) {
		this.manager=manager;
	}

}
