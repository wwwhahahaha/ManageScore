package nb.stp.mansco.typein.service.impl;


import nb.stp.mansco.base.service.impl.GenericManagerImpl;
import nb.stp.mansco.inquire.dao.InquireDao;
import nb.stp.mansco.typein.dao.TypeInDao;
import nb.stp.mansco.typein.domain.TypeIn;
import nb.stp.mansco.typein.service.TypeInManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class TypeInManagerImpl extends GenericManagerImpl<TypeIn, Long> implements TypeInManager {
    @Override
    public Object[] getDetails(){
        return dao.findAll().toArray();
    }
    @Override
    public void updataDetails(TypeIn temp){
        dao.save(temp);

    }
    @Override
    public void createDetails(TypeIn temp){
        dao.save(temp);
    }
    @Override
    public void deleteDetails(Long id){
        dao.deleteById(id);
    }
    @Autowired
    public void setTypeInDao(TypeInDao dao) {
        this.dao = dao;
    }
}
