package nb.stp.mansco.typein.web.spring.controller;


import nb.stp.mansco.typein.service.TypeInManager;
import nb.stp.mansco.typein.domain.TypeIn;
import nb.stp.mansco.base.web.spring.controller.GenericController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/details")
public class TypeInController extends GenericController<TypeIn,Long, TypeInManager> {

	@RequestMapping(method = RequestMethod.POST, value = "/updetails")
	@ResponseBody
	public void upscore(@RequestBody TypeIn temp) {
		manager.updataDetails(temp);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/crdetails")
	@ResponseBody
	public void crdetails(@RequestBody TypeIn temp) {
		manager.createDetails(temp);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/dedetails")
	@ResponseBody
	public void dedetails(@RequestParam Long id) {
		manager.deleteDetails(id);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/getlistdetails")
	@ResponseBody
	public Object[] getlistdetails() {
		return manager.getDetails();
	}
	@Autowired
	public void setTypeInManager(TypeInManager manager) {
		this.manager=manager;
	}

}
