package nb.stp.mansco.statistics.web.spring.controller;


import nb.stp.mansco.statistics.service.StatisticsManager;
import nb.stp.mansco.statistics.domain.Statistics;
import nb.stp.mansco.base.web.spring.controller.GenericController;
import nb.stp.mansco.typein.domain.TypeIn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/score")
public class StatisticsController extends GenericController<Statistics,Long, StatisticsManager> {

	@RequestMapping(method = RequestMethod.POST, value = "/upscore")
	@ResponseBody
	public void upscore(@RequestBody Statistics temp) {
		manager.updataScore(temp);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/crscore")
	@ResponseBody
	public void crscore(@RequestBody Statistics temp) {
		manager.createScore(temp);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/descore")
	@ResponseBody
	public void descore(@RequestParam Long id) {
		manager.deleteScore(id);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/getlistscore")
	@ResponseBody
	public Object[] getlistscore() {
		return manager.getScore();
	}
	@Autowired
	public void setStatisticsManager(StatisticsManager manager) {
		this.manager=manager;
	}

}
