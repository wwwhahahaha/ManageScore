package nb.stp.mansco.inquire;

import nb.stp.mansco.base.dao.GenericDaoTestCase;
import nb.stp.mansco.inquire.dao.InquireDao;
import nb.stp.mansco.inquire.domain.Inquire;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class InquireDaoTest extends GenericDaoTestCase {
    @Autowired
    InquireDao dao;

    @Test
    public void test() {
        Inquire r = new Inquire();
        r.setIndexFir("test");
        Inquire test = this.dao.save(r);
        Long id = test.getId();
        Inquire result = this.dao.getOne(id);
        assertEquals(test, result);
        List<Inquire> all = this.dao.findAll();
    }

}
