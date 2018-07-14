

package nb.stp.mansco.userback.service;


import nb.stp.mansco.base.service.GenericManagerTestCase;
import nb.stp.mansco.userback.domain.UserBack;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;


public class UserBackManagerTest extends GenericManagerTestCase<Long, UserBack, UserBackManager>  {

    public UserBackManagerTest() {
        super(UserBack.class);
    }

    @Autowired
    UserBackManager Manager;
    @Before
    public void setUp() throws Exception {
        UserBack entity = new UserBack();
        entity.setEmail("abc");
        this.entity = this.Manager.save(entity);
    }

    @Test
    public void testFindByPostcode() {
        String message = this.entity.getEmail();
        List<UserBack> result = this.Manager.findByCode(message);
        assertEquals(message, result.get(0).getEmail());

    }

}
