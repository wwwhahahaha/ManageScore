package com.test;

import java.util.List;
import java.util.UUID;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;
import com.jack.entity.User;
import com.jack.service.UserService;
import com.util.entity.Common;

@RunWith(SpringJUnit4ClassRunner.class)  
@ContextConfiguration(locations = { "classpath:spring.xml", "classpath:spring-hibernate.xml" })  
public class TestUserService {

	private static final Logger LOGGER = Logger.getLogger(TestUserService.class);  
	
	@Autowired
	private UserService userService;
	
	@Test
	public void sava(){
	    User user=new User();
		user.setId(UUID.randomUUID().toString().replace("-", ""));
		user.setUserName("jack");
		user.setUserPhone("1389897234");
		user.setUserOrderAddress("吴川市");
		user.setUserPassword("123456");
		user.setUserEmail("100@qq.com");
		user.setCreateDate(Common.createDate());
		String id=userService.save(user);
		System.out.println(id);
		LOGGER.info(JSON.toJSONString(id));  
	}
	
	@Test
	public void findAllById(){
		//hql是对类名的查询并不是表名
		//String hql="from User";
		List<User> userList=userService.findAll();
		System.out.println(userList.size());
	}
	
	
	public void getUserById(){
		String id="718bc202c714463bbeca42134bceaf80";
		User user=userService.get(id);
		System.out.println(user.getId());
	}
}
