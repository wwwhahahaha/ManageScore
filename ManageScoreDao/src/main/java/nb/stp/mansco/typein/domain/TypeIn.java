package nb.stp.mansco.typein.domain;

import nb.stp.mansco.base.domain.BaseEntity;
import org.springframework.data.annotation.Id;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Table(name="typein")
@Entity
public class TypeIn extends BaseEntity {

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    @Column(name = "sex")
    String sex;

    @Column(name = "age")
    int age;


}
