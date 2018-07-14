package nb.stp.mansco.userback.dao;

import nb.stp.mansco.base.dao.GenericDaoTestCase;
import nb.stp.mansco.userback.domain.UserBack;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class UserBackDaoTest extends GenericDaoTestCase {

    @Autowired
    UserBackDao dao;

    @Test
    public void test() {
        UserBack r = new UserBack();
        r.setEmail("test");
        UserBack test = this.dao.save(r);
        Long id = test.getId();
        UserBack result = this.dao.getOne(id);
        assertEquals(test, result);
        List<UserBack> all = this.dao.findAll();
    }

}
