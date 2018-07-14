package nb.stp.mansco.userback.service;

import nb.stp.mansco.base.service.GenericGenerator;
import nb.stp.mansco.userback.domain.UserBack;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class AdminEntityGenerator extends GenericGenerator {
    @Autowired
    nb.stp.mansco.userback.service.UserBackManager UserBackManager;

    @Test
    public void gen_group() {
        for (int i = 0; i < 10; i++) {
            UserBack g = new UserBack();
            g.setEmail("test_" + i);
            this.UserBackManager.save(g);
        }
    }
}
