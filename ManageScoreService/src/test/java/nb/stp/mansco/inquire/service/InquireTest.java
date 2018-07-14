package nb.stp.mansco.inquire.service;


import nb.stp.mansco.base.service.GenericManagerTestCase;
import nb.stp.mansco.inquire.domain.Inquire;
import nb.stp.mansco.inquire.service.InquireManager;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.assertEquals;


public class InquireTest extends GenericManagerTestCase<Long, Inquire, InquireManager>  {

    public InquireTest() {
        super(Inquire.class);
    }

    @Autowired
    InquireManager Manager;
    @Before
    public void setUp() throws Exception {
        Inquire entity = new Inquire();
        entity.setIndexFir("abc");
        this.entity = this.Manager.save(entity);
    }

    @Test
    public void testFindByPostcode() {
        String message = this.entity.getIndexFir();
        List<Inquire> result = this.Manager.findByCode(message);
        assertEquals(message, result.get(0).getIndexFir());

    }

}

