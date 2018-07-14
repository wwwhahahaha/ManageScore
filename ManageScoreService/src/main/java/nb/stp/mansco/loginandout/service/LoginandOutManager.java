package nb.stp.mansco.loginandout.service;


import nb.stp.mansco.base.service.GenericManager;
import nb.stp.mansco.loginandout.domain.LoginandLogout;

import java.util.List;


public interface LoginandOutManager extends GenericManager<LoginandLogout, Long> {
    List<LoginandLogout> findByCode(String code);
}
