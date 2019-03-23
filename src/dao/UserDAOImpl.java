package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.User;

public class UserDAOImpl implements UserDAO {

	private static Connection con;

	static {
		try {

			con = ConnectorUtility.getCon();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean signIn(User user) {

		try {
			PreparedStatement pst = con.prepareStatement("select * from login where username = ? and password = ?");
			pst.setString(1, user.getUsername());
			pst.setString(2, user.getPassword());
			ResultSet rs = pst.executeQuery();

			if (rs.next()) {
				return true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean signUp(User user) {
		boolean res = false;
		try {
			PreparedStatement pst = con.prepareStatement("insert into login (username,password) values (?,?)");
			pst.setString(1, user.getUsername());
			pst.setString(2, user.getPassword());
			
			res = (pst.executeUpdate() == 1) ? true : false ;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return res;
	}

}
