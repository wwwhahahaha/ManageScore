package nb.stp.mansco.loginandout.service.impl;

import nb.stp.mansco.base.service.impl.GenericManagerImpl;
import nb.stp.mansco.loginandout.domain.LoginandLogout;
import nb.stp.mansco.inquire.dao.InquireDao;
import nb.stp.mansco.loginandout.dao.LoginandLogoutDao;
import nb.stp.mansco.loginandout.domain.LoginandLogout;
import nb.stp.mansco.loginandout.service.LoginandOutManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class LoginandoutImpl extends GenericManagerImpl<LoginandLogout, Long> implements LoginandOutManager {
    @Override
    public List<LoginandLogout> findByCode(String postcode) {

        // 创建查询条件数据对象
        LoginandLogout queryObject = new LoginandLogout();
        queryObject.setDateCreated(null);
        queryObject.setDateModified(null);
        queryObject.setUserName(postcode);
        // 创建匹配器，即如何使用查询条件
        // 创建匹配器，即如何使用查询条件
        ExampleMatcher matcher = ExampleMatcher.matching() // 构建对象
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING) // 改变默认字符串匹配方式：模糊查询
                .withIgnoreCase(true) // 改变默认大小写忽略方式：忽略大小写
                .withMatcher("postcode", ExampleMatcher.GenericPropertyMatchers.startsWith()); // 地址采用“开始匹配”的方式查询
        // 创建实例并查询
        Example<LoginandLogout> ex = Example.of(queryObject, matcher);
        List<LoginandLogout> result = dao.findAll(ex);
        return result;
    }
    @Autowired
    public void setLoginandoutDao(LoginandLogoutDao dao) {
        this.dao = dao;
    }
}
