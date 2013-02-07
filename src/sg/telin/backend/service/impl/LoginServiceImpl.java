package sg.telin.backend.service.impl;

import sg.telin.backend.dao.UserDao;
import sg.telin.backend.model.User;
import sg.telin.backend.service.LoginService;

public class LoginServiceImpl implements LoginService {
	private UserDao userDao;
	private User	userLogin;
	@Override
	public int loginAccepted(String login, String pass, String opCode){
		int status =0;
			
			/* getUserDao().find(login, pass, opCode);
		setLoginView(userDao.getLoginView());
		this.userLogin = userDao.getUserLogin();*/
		return status;
	}

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	
	@Override
	public User getUserlogin() {
		return new User(); 
		
		//this.userLogin;
	}

}
