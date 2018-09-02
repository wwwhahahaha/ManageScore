package nb.stp.mansco.statistics.service.impl;


import nb.stp.mansco.base.service.impl.GenericManagerImpl;
import nb.stp.mansco.inquire.dao.InquireDao;
import nb.stp.mansco.statistics.dao.StatisticsDao;
import nb.stp.mansco.statistics.domain.Statistics;
import nb.stp.mansco.statistics.service.StatisticsManager;
import nb.stp.mansco.typein.domain.TypeIn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class StatisticsManagerImpl extends GenericManagerImpl<Statistics, Long> implements StatisticsManager {
    @Override
    public Object[] getScore(){
        return dao.findAll().toArray();
    }
    @Override
    public void updataScore(Statistics temp){
        dao.save(temp);

    }
    @Override
    public void createScore(Statistics temp){
        dao.save(temp);
    }
    @Override
    public void deleteScore(Long id){
        dao.deleteById(id);
    }
    @Autowired
    public void setStatisticsDao(StatisticsDao dao) {
        this.dao = dao;
    }
}
