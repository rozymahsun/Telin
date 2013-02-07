package sg.telin.backend.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sg.telin.backend.dao.UserDao;
import sg.telin.backend.model.User;
import sg.telin.backend.service.BaseService;
import sg.telin.backend.service.UserService;


@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao;
	
	
	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public void delete(User o) {
		
		userDao.delete(o);
	}

	@Override
	public int insert(User o) {
		return userDao.save(o);
	}

	@Override
	public void update(User o) {
		
		userDao.update(o);
	}

	@Override
	public List<User> findAll() {
		return userDao.findAll();
	}


}
