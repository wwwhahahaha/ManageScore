package nb.stp.mansco.typein.service;

import nb.stp.mansco.base.service.GenericManagerTestCase;
import nb.stp.mansco.typein.domain.TypeIn;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;


public class TypeInManagerTest extends GenericManagerTestCase<Long, TypeIn, TypeInManager>  {

    public TypeInManagerTest() {
        super(TypeIn.class);
    }

    @Autowired
    TypeInManager Manager;
    @Before
    public void setUp() throws Exception {
        TypeIn entity = new TypeIn();
        entity.setstruct("abc");
        this.entity = this.Manager.save(entity);
    }

    @Test
    public void testFindByPostcode() {
        String message = this.entity.getstruct();
        List<TypeIn> result = this.Manager.findByCode(message);
        assertEquals(message, result.get(0).getstruct());

    }

}

