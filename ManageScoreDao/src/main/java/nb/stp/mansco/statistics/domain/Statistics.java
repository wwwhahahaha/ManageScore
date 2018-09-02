package nb.stp.mansco.statistics.domain;

import nb.stp.mansco.base.domain.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="statistics")
@Entity
public class Statistics extends BaseEntity {

    public int getChinese() {
        return chinese;
    }

    public void setChinese(int chinese) {
        this.chinese = chinese;
    }

    public int getMath() {
        return math;
    }

    public void setMath(int math) {
        this.math = math;
    }

    public int getEnglish() {
        return english;
    }

    public void setEnglish(int english) {
        this.english = english;
    }

    @Column(name="chinese")
    int chinese;
    @Column(name="math")
    int math;
    @Column(name="english")
    int english;
}
