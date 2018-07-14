package nb.stp.mansco.typein.web.spring.controller;


import nb.stp.mansco.typein.service.TypeInManager;
import nb.stp.mansco.typein.domain.TypeIn;
import nb.stp.mansco.base.web.spring.controller.GenericController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/typein")
public class TypeInController extends GenericController<TypeIn,Long, TypeInManager> {

	@RequestMapping(method = RequestMethod.GET, value = "/index.html")
	public String index() {
		String result = "/typein/index";
		return result;
	}
	@Autowired
	public void setTypeInManager(TypeInManager manager) {
		this.manager=manager;
	}

}
