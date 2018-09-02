package nb.stp.mansco.scoreback.web.spring.controller;


import nb.stp.mansco.scoreback.service.ScoreBackManager;
import nb.stp.mansco.scoreback.domain.ScoreBack;
import nb.stp.mansco.base.web.spring.controller.GenericController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


public class ScoreBackController extends GenericController<ScoreBack,Long, ScoreBackManager> {

	public String index() {
		String result = "/scoreback/index";
		return result;
	}
	@Autowired
	public void setScoreBackManager(ScoreBackManager manager) {
		this.manager=manager;
	}

}
