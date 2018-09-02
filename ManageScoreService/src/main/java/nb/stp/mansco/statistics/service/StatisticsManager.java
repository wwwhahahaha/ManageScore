package nb.stp.mansco.statistics.service;


import nb.stp.mansco.base.service.GenericManager;
import nb.stp.mansco.statistics.domain.Statistics;
import nb.stp.mansco.typein.domain.TypeIn;

import java.util.List;

public interface StatisticsManager extends GenericManager<Statistics, Long> {
   public Object[] getScore();
    public void updataScore(Statistics a);
    public void createScore(Statistics a);
    public void deleteScore(Long id);
}
