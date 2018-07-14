package nb.stp.mansco.loginandout.service;


import nb.stp.mansco.base.service.GenericManagerTestCase;
import nb.stp.mansco.loginandout.domain.LoginandLogout;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;


public class LoginandOutManagerTest extends GenericManagerTestCase<Long, LoginandLogout, LoginandOutManager>  {

    public LoginandOutManagerTest() {
        super(LoginandLogout.class);
    }

    @Autowired
    LoginandOutManager Manager;
    @Before
    public void setUp() throws Exception {
        LoginandLogout entity = new LoginandLogout();
        entity.setUserName("abc");
        this.entity = this.Manager.save(entity);
    }

    @Test
    public void testFindByPostcode() {
        String message = this.entity.getUserName();
        List<LoginandLogout> result = this.Manager.findByCode(message);
        assertEquals(message, result.get(0).getUserName());

    }

}

