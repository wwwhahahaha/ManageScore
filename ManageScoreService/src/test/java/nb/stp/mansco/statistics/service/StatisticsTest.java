package nb.stp.mansco.statistics.service;


import nb.stp.mansco.base.service.GenericManagerTestCase;
import nb.stp.mansco.statistics.domain.Statistics;
import nb.stp.mansco.statistics.service.StatisticsManager;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.assertEquals;


public class StatisticsTest extends GenericManagerTestCase<Long, Statistics, StatisticsManager>  {

    public StatisticsTest() {
        super(Statistics.class);
    }

    @Autowired
    StatisticsManager Manager;
    @Before
    public void setUp() throws Exception {
        Statistics entity = new Statistics();
        entity.setdata("abc");
        this.entity = this.Manager.save(entity);
    }

    @Test
    public void testFindByPostcode() {
        String message = this.entity.getCatagory();
        List<Statistics> result = this.Manager.findByCode(message);
        assertEquals(message, result.get(0).getCatagory());

    }

}

