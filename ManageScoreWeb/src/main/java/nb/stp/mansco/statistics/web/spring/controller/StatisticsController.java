package nb.stp.mansco.statistics.web.spring.controller;


import nb.stp.mansco.statistics.service.StatisticsManager;
import nb.stp.mansco.statistics.domain.Statistics;
import nb.stp.mansco.base.web.spring.controller.GenericController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/statistics")
public class StatisticsController extends GenericController<Statistics,Long, StatisticsManager> {

	@RequestMapping(method = RequestMethod.GET, value = "/index.html")
	public String index() {
		String result = "/statistics/index";
		return result;
	}
	@Autowired
	public void setStatisticsManager(StatisticsManager manager) {
		this.manager=manager;
	}

}
