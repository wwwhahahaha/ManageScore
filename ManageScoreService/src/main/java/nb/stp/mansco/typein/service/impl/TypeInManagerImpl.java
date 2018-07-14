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
    public List<TypeIn> findByCode(String postcode) {

        // 创建查询条件数据对象
        TypeIn queryObject = new TypeIn();
        queryObject.setDateCreated(null);
        queryObject.setDateModified(null);
        queryObject.setstruct(postcode);
        // 创建匹配器，即如何使用查询条件
        // 创建匹配器，即如何使用查询条件
        ExampleMatcher matcher = ExampleMatcher.matching() // 构建对象
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING) // 改变默认字符串匹配方式：模糊查询
                .withIgnoreCase(true) // 改变默认大小写忽略方式：忽略大小写
                .withMatcher("postcode", ExampleMatcher.GenericPropertyMatchers.startsWith()); // 地址采用“开始匹配”的方式查询
        // 创建实例并查询
        Example<TypeIn> ex = Example.of(queryObject, matcher);
        List<TypeIn> result = dao.findAll(ex);
        return result;
    }
    @Autowired
    public void setTypeInDao(TypeInDao dao) {
        this.dao = dao;
    }
}
