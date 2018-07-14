package nb.stp.mansco.loginandout.service;

import nb.stp.mansco.base.service.GenericGenerator;
import nb.stp.mansco.loginandout.domain.LoginandLogout;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class AdminEntityGenerator extends GenericGenerator {
    @Autowired
    nb.stp.mansco.loginandout.service.LoginandOutManager LogInandOutManager;

    @Test
    public void gen_group() {
        for (int i = 0; i < 10; i++) {
            LoginandLogout g = new  LoginandLogout();
            g.setUserName("test_" + i);
            this.LogInandOutManager.save(g);
        }
    }
}
