package nb.stp.mansco.statistics.domain;

import nb.stp.mansco.base.domain.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Table(name="statistics")
@Entity
public class Statistics extends BaseEntity {
    public String getdata() {
        return data;
    }

    public void setdata(String userName) {
        this.data = userName;
    }
    @Column(name="data")
    String data;

    public String getCatagory() {
        return catagory;
    }

    public void setCatagory(String catagory) {
        this.catagory = catagory;
    }

    @Column(name="catagory")
    String catagory;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Column(name="value")
    int value;
}
