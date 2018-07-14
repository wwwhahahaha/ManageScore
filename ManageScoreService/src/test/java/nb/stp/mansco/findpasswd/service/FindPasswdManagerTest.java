package nb.stp.mansco.findpasswd.service;

import nb.stp.mansco.base.service.GenericManagerTestCase;
import nb.stp.mansco.findpasswd.domain.FindPasswd;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;


public class FindPasswdManagerTest extends GenericManagerTestCase<Long, FindPasswd, FindPasswdManager> {

    public FindPasswdManagerTest() {
        super(FindPasswd.class);
    }

    @Autowired
    FindPasswdManager Manager;
    @Before
    public void setUp() throws Exception {
        FindPasswd entity = new FindPasswd();
       entity.setEmail("abc");
        this.entity = this.Manager.save(entity);
    }

    @Test
    public void testFindByPostcode() {
        String message = this.entity.getEmail();
        List<FindPasswd> result = this.Manager.findByCode(message);
        assertEquals(message, result.get(0).getEmail());

    }

}
