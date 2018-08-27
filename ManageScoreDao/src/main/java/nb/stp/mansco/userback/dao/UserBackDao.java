package com.jack.dao;

import java.util.List;

import com.jack.entity.User;
import com.util.dao.BaseDao;
import com.util.entity.Pagination;

public interface UserDao extends BaseDao<String, User>{

	//可依据传递参数不同获取User对象集合
	List<User> findUserList(User user);
	
	List<User> findAll();
	
	void deleteUser(User user);
	
	Pagination findUsers(Pagination pagination,User user);
}
