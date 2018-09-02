package nb.stp.mansco.findpasswd.web.spring.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/manage")
public class FindPasswdController {

	@RequestMapping("/index")
	public String index() {
		return "managescore/index";
	}

}
