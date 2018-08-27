package com.jack.dao;

import java.util.List;

import com.jack.entity.User;
import com.util.dao.BaseDao;
import com.util.entity.Pagination;

public interface UserDao extends BaseDao<String, User>{

	//�����ݴ��ݲ�����ͬ��ȡUser���󼯺�
	List<User> findUserList(User user);
	
	List<User> findAll();
	
	void deleteUser(User user);
	
	Pagination findUsers(Pagination pagination,User user);
}
