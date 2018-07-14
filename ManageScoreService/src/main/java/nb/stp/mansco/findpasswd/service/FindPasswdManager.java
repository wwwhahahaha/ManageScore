package nb.stp.mansco.findpasswd.service;



import nb.stp.mansco.base.service.GenericManager;
import nb.stp.mansco.findpasswd.domain.FindPasswd;

import java.util.List;


public interface FindPasswdManager extends GenericManager<FindPasswd, Long> {
    public List<FindPasswd> findByCode(String postcode);
}
