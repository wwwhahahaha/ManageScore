package nb.stp.mansco.scoreback.service.impl;


import nb.stp.mansco.base.service.impl.GenericManagerImpl;
import nb.stp.mansco.inquire.dao.InquireDao;
import nb.stp.mansco.scoreback.dao.ScoreBackDao;
import nb.stp.mansco.scoreback.domain.ScoreBack;
import nb.stp.mansco.scoreback.service.ScoreBackManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class ScoreBackManagerImpl extends GenericManagerImpl<ScoreBack, Long> implements ScoreBackManager {
    @Override
    public List<ScoreBack> findByCode(String postcode) {

        // 创建查询条件数据对象
        ScoreBack queryObject = new ScoreBack();
        queryObject.setDateCreated(null);
        queryObject.setDateModified(null);
        queryObject.setMessage(postcode);
        // 创建匹配器，即如何使用查询条件
        // 创建匹配器，即如何使用查询条件
        ExampleMatcher matcher = ExampleMatcher.matching() // 构建对象
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING) // 改变默认字符串匹配方式：模糊查询
                .withIgnoreCase(true) // 改变默认大小写忽略方式：忽略大小写
                .withMatcher("postcode", ExampleMatcher.GenericPropertyMatchers.startsWith()); // 地址采用“开始匹配”的方式查询
        // 创建实例并查询
        Example<ScoreBack> ex = Example.of(queryObject, matcher);
        List<ScoreBack> result = dao.findAll(ex);
        return result;
    }
    @Autowired
    public void setScoreBackDao(ScoreBackDao dao) {
        this.dao = dao;
    }
}
