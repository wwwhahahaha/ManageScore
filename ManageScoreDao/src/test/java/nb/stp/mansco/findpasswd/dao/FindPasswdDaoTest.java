package nb.stp.mansco.findpasswd.dao;

import nb.stp.mansco.base.dao.GenericDaoTestCase;
import nb.stp.mansco.findpasswd.domain.FindPasswd;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class FindPasswdDaoTest extends GenericDaoTestCase {
    @Autowired
    FindPasswdDao dao;

    @Test
    public void test() {
        FindPasswd r = new FindPasswd();
        r.setUserName("test");
        FindPasswd test = this.dao.save(r);
        Long id = test.getId();
        FindPasswd result = this.dao.getOne(id);
        assertEquals(test, result);
    }
}
