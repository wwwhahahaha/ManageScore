package nb.stp.mansco.scoreback.service;


import nb.stp.mansco.base.service.GenericManager;
import nb.stp.mansco.scoreback.domain.ScoreBack;

import java.util.List;


public interface ScoreBackManager extends GenericManager<ScoreBack, Long> {
    List<ScoreBack> findByCode(String code);
}
