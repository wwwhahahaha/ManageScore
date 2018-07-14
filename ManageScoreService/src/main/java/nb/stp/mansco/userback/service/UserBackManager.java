package nb.stp.mansco.userback.service;



import nb.stp.mansco.base.service.GenericManager;
import nb.stp.mansco.userback.domain.UserBack;

import java.util.List;


public interface UserBackManager extends GenericManager<UserBack, Long> {
    List<UserBack> findByCode(String code);
}
