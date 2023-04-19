package com.example.SpringBootTest;

import com.example.SpringBootTest.DAO.MessageDAO;
import com.example.SpringBootTest.model.Message;
import com.example.SpringBootTest.model.User;
import com.example.SpringBootTest.DAO.UserDAO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;



@SpringBootTest
class SpringBootTestApplicationTests {
	@Autowired
	UserDAO userDao;

	@Autowired
	MessageDAO messageDAO;
//	void addUser() {
//		User user = new User("Johnny");
//		User user1 = new User("Leon");
//
//		userDao.saveUser(user);
//		userDao.saveUser(user1);
//	}



}
