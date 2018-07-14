package nb.stp.mansco.loginandout;

import nb.stp.mansco.base.dao.GenericDaoTestCase;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import nb.stp.mansco.loginandout.dao.LoginandLogoutDao;
import nb.stp.mansco.loginandout.domain.LoginandLogout;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class loginandoutTest extends GenericDaoTestCase {
    @Autowired
    LoginandLogoutDao dao;

    @Test
    public void test() {
        LoginandLogout r = new LoginandLogout();
        r.setUserName("test");
        LoginandLogout test = this.dao.save(r);
        Long id = test.getId();
        LoginandLogout result = this.dao.getOne(id);
        assertEquals(test, result);
        List<LoginandLogout> all = this.dao.findAll();
    }

}
