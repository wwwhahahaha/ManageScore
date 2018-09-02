package nb.stp.mansco.userback.domain;

import nb.stp.mansco.base.domain.BaseEntity;
import org.springframework.data.annotation.Id;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Table(name="userback")
@Entity
public class UserBack extends BaseEntity {

    @Column(name="subject")
    String subject;
    @Column(name="oldScore")
    int oldScore;
    @Column(name="newScore")
    int newScore;


    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public int getOldScore() {
        return oldScore;
    }

    public void setOldScore(int oldScore) {
        this.oldScore = oldScore;
    }

    public int getNewScore() {
        return newScore;
    }

    public void setNewScore(int newScore) {
        this.newScore = newScore;
    }
}
