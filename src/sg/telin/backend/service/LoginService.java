package sg.telin.backend.service;

import sg.telin.backend.model.User;

public interface LoginService {
	User	  getUserlogin();
	int loginAccepted(String login, String pass,String opCode);
}
