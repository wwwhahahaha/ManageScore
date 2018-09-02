package nb.stp.mansco.loginandout.domain;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Table(name = "LoginandLogout")
@Entity
public class LoginandLogout extends nb.stp.mansco.base.domain.BaseEntity {

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }



    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
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

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    @Column(name = "roles")
    String roles;
    @Column(name = "pass")
    String pass;


}
