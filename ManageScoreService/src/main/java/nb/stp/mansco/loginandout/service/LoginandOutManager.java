package nb.stp.mansco.loginandout.service;


import nb.stp.mansco.base.service.GenericManager;
import nb.stp.mansco.loginandout.domain.LoginandLogout;
import nb.stp.mansco.typein.domain.TypeIn;

import java.util.List;


public interface LoginandOutManager extends GenericManager<LoginandLogout, Long> {
    public Boolean signIn(LoginandLogout temp);
    public Long login(String name,String pass);
    public String findPass(LoginandLogout temp);
}
