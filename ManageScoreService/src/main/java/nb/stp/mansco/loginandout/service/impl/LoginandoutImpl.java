package nb.stp.mansco.loginandout.service.impl;

import nb.stp.mansco.base.service.impl.GenericManagerImpl;
import nb.stp.mansco.loginandout.domain.LoginandLogout;
import nb.stp.mansco.inquire.dao.InquireDao;
import nb.stp.mansco.loginandout.dao.LoginandLogoutDao;
import nb.stp.mansco.loginandout.domain.LoginandLogout;
import nb.stp.mansco.loginandout.service.LoginandOutManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Component
public class LoginandoutImpl extends GenericManagerImpl<LoginandLogout, Long> implements LoginandOutManager {
    @Override
    public Boolean signIn(LoginandLogout temp){
        if(dao.exists(Example.of(temp)))
            return false;
        else {
            dao.save(temp);
            return true;
        }
    }
    @Override
    public Long login(String name,String pass){
        LoginandLogout temp=new LoginandLogout();
        temp.setName(name);
        temp.setPass(pass);
        Optional<LoginandLogout> result=dao.findOne(Example.of(temp));
        return result.get().getId();
    }
    @Override
    public String findPass(LoginandLogout temp) {
        Optional<LoginandLogout> result=dao.findOne(Example.of(temp));
        return result.get().getPass();
    }
    @Autowired
    public void setLoginandoutDao(LoginandLogoutDao dao) {
        this.dao = dao;
    }
}
