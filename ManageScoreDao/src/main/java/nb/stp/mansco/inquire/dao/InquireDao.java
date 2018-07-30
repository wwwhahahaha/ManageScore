package nb.stp.mansco.inquire.dao;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import nb.stp.mansco.base.dao.GenericDao;
import nb.stp.mansco.base.web.spring.controller.GenericController;
import nb.stp.mansco.inquire.domain.Inquire;
import nb.stp.mansco.userback.domain.UserBack;
import nb.stp.mansco.userback.service.UserBackManager;

public interface InquireDao extends GenericDao<Inquire, Long> {

}
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
