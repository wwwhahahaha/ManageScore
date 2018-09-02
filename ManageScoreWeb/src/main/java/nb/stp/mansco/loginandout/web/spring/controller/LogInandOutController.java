package nb.stp.mansco.loginandout.web.spring.controller;


import nb.stp.mansco.loginandout.service.LoginandOutManager;
import nb.stp.mansco.loginandout.domain.LoginandLogout;
import nb.stp.mansco.base.web.spring.controller.GenericController;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/login")
public class LogInandOutController extends GenericController<LoginandLogout,Long, LoginandOutManager> {
	@RequestMapping(value = "/abc", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
	@ResponseBody
	public String create(@RequestBody String a) {

		return "abc";
	}

	@RequestMapping(method = RequestMethod.GET, value = "/login",produces = "application/json", consumes = "application/json")
	@ResponseBody
	public Long login(@RequestParam(name="name") String name,@RequestParam(name="pass") String pass) {

		return manager.login(name,pass);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/signin")
	@ResponseBody
	public Boolean signin(@RequestBody LoginandLogout temp) {

			return manager.signIn(temp);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/findpass")
	@ResponseBody
	public String findpass(@RequestBody LoginandLogout temp) {

		return manager.findPass(temp);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/logout")
	@ResponseBody
	public void logout() {

		return ;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/info")
	@ResponseBody
	public LoginandLogout getinfo(@RequestParam Long id) {
		return manager.findById(id);
	}
	@Autowired
	public void setLoginandManager(LoginandOutManager manager) {
		this.manager=manager;
	}

}
