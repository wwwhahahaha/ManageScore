package nb.stp.mansco.userback.service.impl;


import nb.stp.mansco.base.service.impl.GenericManagerImpl;
import nb.stp.mansco.inquire.dao.InquireDao;
import nb.stp.mansco.userback.dao.UserBackDao;
import nb.stp.mansco.userback.domain.UserBack;
import nb.stp.mansco.userback.service.UserBackManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class UserBackManagerImpl extends GenericManagerImpl<UserBack, Long> implements UserBackManager {
   @Override
    public void submit(UserBack temp) {
        dao.save(temp);
    }
    @Override
    public Object[] find() {
        return dao.findAll().toArray();
    }

    @Autowired
    public void setUserBackDao(UserBackDao dao) {
        this.dao = dao;
    }
}
