package nb.stp.mansco.userback.web.spring.controller;


import nb.stp.mansco.typein.service.TypeInManager;
import nb.stp.mansco.typein.domain.TypeIn;
import nb.stp.mansco.base.web.spring.controller.GenericController;
import nb.stp.mansco.userback.domain.UserBack;
import nb.stp.mansco.userback.service.UserBackManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/achievment")
public class UserBackController extends GenericController<UserBack,Long, UserBackManager> {

	@RequestMapping(method = RequestMethod.POST, value = "/modify")
	@ResponseBody
	public void index(@RequestBody UserBack temp) {
		manager.submit(temp);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/lookfor")
	@ResponseBody
	public Object[] index() {
		return manager.find();
	}
	@Autowired
	public void setUserBackManager(UserBackManager manager) {
		this.manager=manager;
	}

}
