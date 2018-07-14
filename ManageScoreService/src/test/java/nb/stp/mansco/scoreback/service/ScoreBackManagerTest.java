package nb.stp.mansco.scoreback.service;


import nb.stp.mansco.base.service.GenericManagerTestCase;

import nb.stp.mansco.scoreback.domain.ScoreBack;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;


public class ScoreBackManagerTest extends GenericManagerTestCase<Long, ScoreBack, ScoreBackManager>  {

    public ScoreBackManagerTest() {
        super(ScoreBack.class);
    }

    @Autowired
    ScoreBackManager Manager;
    @Before
    public void setUp() throws Exception {
        ScoreBack entity = new ScoreBack();
        entity.setMessage("abc");
        this.entity = this.Manager.save(entity);
    }

    @Test
    public void testFindByPostcode() {
        String message = this.entity.getMessage();
        List<ScoreBack> result = this.Manager.findByCode(message);
        assertEquals(message, result.get(0).getMessage());

    }

}

