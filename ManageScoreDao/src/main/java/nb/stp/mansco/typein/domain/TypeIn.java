package nb.stp.mansco.typein.domain;

import nb.stp.mansco.base.domain.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Table(name="typein")
@Entity
public class TypeIn extends BaseEntity {
    public String getstruct() {
        return struct;
    }

    public void setstruct(String userName) {
        this.struct = userName;
    }
    @Column(name="struct")
    String struct;

    public String getStruct2() {
        return struct2;
    }

    public void setStruct2(String struct2) {
        this.struct2 = struct2;
    }

    @Column(name="struct2")
    String struct2;


}
