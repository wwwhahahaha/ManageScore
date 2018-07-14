package nb.stp.mansco.typein.dao;

import nb.stp.mansco.base.dao.GenericDaoTestCase;
import nb.stp.mansco.typein.domain.TypeIn;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.assertEquals;


public class TypeInDaoTest extends GenericDaoTestCase {

    @Autowired
    TypeInDao dao;

    @Test
    public void test() {
        TypeIn r = new TypeIn();
        r.setstruct("test");
        TypeIn test = this.dao.save(r);
        Long id = test.getId();
        TypeIn result = this.dao.getOne(id);
        assertEquals(test, result);
        List<TypeIn> all = this.dao.findAll();
    }

}
