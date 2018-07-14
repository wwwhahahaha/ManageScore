package nb.stp.mansco.typein.service;

import nb.stp.mansco.base.service.GenericGenerator;
import nb.stp.mansco.typein.domain.TypeIn;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class AdminEntityGenerator extends GenericGenerator {
    @Autowired
    nb.stp.mansco.typein.service.TypeInManager TypeInManager;

    @Test
    public void gen_group() {
        for (int i = 0; i < 10; i++) {
            TypeIn g = new TypeIn();
            g.setstruct("test_" + i);
            this.TypeInManager.save(g);
        }
    }
}
