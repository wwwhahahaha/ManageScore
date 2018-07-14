package nb.stp.mansco.statistics.dao;

import nb.stp.mansco.base.dao.GenericDaoTestCase;
import nb.stp.mansco.statistics.domain.Statistics;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class StatisticsDaoTest extends GenericDaoTestCase {

    @Autowired
    nb.stp.mansco.statistics.dao.StatisticsDao dao;

    @Test
    public void test() {
        Statistics r = new Statistics();
        r.setdata("test");
        Statistics test = this.dao.save(r);
        Long id = test.getId();
        Statistics result = this.dao.getOne(id);
        assertEquals(test, result);
        List<Statistics> all = this.dao.findAll();
    }

}
