package nb.stp.mansco.inquire.web.spring.controller;

import nb.stp.mansco.inquire.service.InquireManager;
import nb.stp.mansco.inquire.domain.Inquire;
import nb.stp.mansco.base.web.spring.controller.GenericController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("/inquire")
public class InquireController extends GenericController<Inquire, Long, InquireManager> {

	@RequestMapping(method = RequestMethod.GET, value = "/index.html")
	public String index() {
		String result = "/inquire/index";
		return result;
	}
	@Autowired
	public void setInquireManager(InquireManager manager) {
		this.manager=manager;
	}

}
