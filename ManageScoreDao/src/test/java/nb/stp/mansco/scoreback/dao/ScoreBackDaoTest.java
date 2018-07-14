package nb.stp.mansco.scoreback.dao;

import nb.stp.mansco.base.dao.GenericDaoTestCase;
import nb.stp.mansco.scoreback.domain.ScoreBack;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class ScoreBackDaoTest extends GenericDaoTestCase {

    @Autowired
    nb.stp.mansco.scoreback.dao.ScoreBackDao dao;

    @Test
    public void test() {
        ScoreBack r = new ScoreBack();
        r.setScore("test");
        ScoreBack test = this.dao.save(r);
        Long id = test.getId();
        ScoreBack result = this.dao.getOne(id);
        assertEquals(test, result);
        List<ScoreBack> all = this.dao.findAll();
    }

}
