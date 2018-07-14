package nb.stp.mansco.scoreback.service;


import nb.stp.mansco.base.service.GenericGenerator;
import nb.stp.mansco.scoreback.domain.ScoreBack;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class AdminEntityGenerator extends GenericGenerator {
    @Autowired
    nb.stp.mansco.scoreback.service.ScoreBackManager ScoreBackManager;

    @Test
    public void gen_group() {
        for (int i = 0; i < 10; i++) {
            ScoreBack g = new ScoreBack();
            g.setScore("test_" + i);
            this.ScoreBackManager.save(g);
        }
    }
}
