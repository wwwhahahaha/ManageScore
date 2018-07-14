package nb.stp.mansco.scoreback.domain;

import nb.stp.mansco.base.domain.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Table(name="scoreback")
@Entity
public class ScoreBack extends BaseEntity {


    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }
    @Column(name="score")
    String score;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Column(name="message")
    String message;
}
