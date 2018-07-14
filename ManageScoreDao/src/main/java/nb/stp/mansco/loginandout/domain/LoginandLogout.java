package nb.stp.mansco.loginandout.domain;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Table(name = "LoginandLogout")
@Entity
public class LoginandLogout extends nb.stp.mansco.base.domain.BaseEntity {
    @Column(name = "userName")
    String userName;
    @Column(name = "userPasswd")
    String userPasswd;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPasswd() {
        return userPasswd;
    }

    public void setUserPasswd(String userPasswd) {
        this.userPasswd = userPasswd;
    }
}
