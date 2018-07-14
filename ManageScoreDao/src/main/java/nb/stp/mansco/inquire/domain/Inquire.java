package nb.stp.mansco.inquire.domain;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Table(name="inquire")
@Entity
public class Inquire extends nb.stp.mansco.base.domain.BaseEntity {


    public String getIndexFir() {
        return indexFir;
    }

    public void setIndexFir(String indexFir) {
        this.indexFir = indexFir;
    }



    public String getIndexSec() {
        return indexSec;
    }

    public void setIndexSec(String indexSec) {
        this.indexSec = indexSec;
    }
    @Column(name="indexFir")
    String indexFir;
    @Column(name="indexSec")
    String indexSec;

}
