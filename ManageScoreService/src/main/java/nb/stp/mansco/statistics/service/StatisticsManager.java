package nb.stp.mansco.statistics.service;


import nb.stp.mansco.base.service.GenericManager;
import nb.stp.mansco.statistics.domain.Statistics;

import java.util.List;

public interface StatisticsManager extends GenericManager<Statistics, Long> {
    List<Statistics> findByCode(String code);
}
