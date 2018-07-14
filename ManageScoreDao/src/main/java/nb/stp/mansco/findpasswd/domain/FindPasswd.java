package nb.stp.mansco.findpasswd.domain;

import nb.stp.mansco.base.domain.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Table(name="findpasswd")
@Entity
public class FindPasswd extends BaseEntity {
    @Column(name="userName")
    String userName;
    @Column(name="email")
    String email;
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }




    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


}
