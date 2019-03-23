package dao;

import model.User;

public interface UserDAO {
	
	boolean signIn(User user);
	boolean signUp(User user);

}
