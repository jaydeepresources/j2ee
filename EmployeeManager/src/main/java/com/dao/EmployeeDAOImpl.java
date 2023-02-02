package com.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.model.Employee;
import static com.dao.DBUtil.getCon;

public class EmployeeDAOImpl implements EmployeeDAO {

	public EmployeeDAOImpl() {
		new DBUtil();
	}

	@Override
	public int add(Employee employee) {

		String sql = "insert into test_employees values (?,?,?)";
		int res = -1;
		try {
			PreparedStatement pst = getCon().prepareStatement(sql);
			pst.setInt(1, employee.getId());
			pst.setString(2, employee.getName());
			pst.setFloat(3, employee.getSalary());
			res = pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public int update(Employee employee) {
		String sql = "update test_employees set name=?, salary=? where id=?";
		int res = -1;
		try {
			PreparedStatement pst = getCon().prepareStatement(sql);
			pst.setString(1, employee.getName());
			pst.setFloat(2, employee.getSalary());
			pst.setInt(3, employee.getId());
			res = pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public int delete(int id) {
		String sql = "delete from test_employees where id=?";
		int res = -1;
		try {
			PreparedStatement pst = getCon().prepareStatement(sql);
			pst.setInt(1, id);
			res = pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public List<Employee> view() {
		String sql = "select * from test_employees";
		List<Employee> list = new ArrayList<>();
		try {
			Statement st = getCon().createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				list.add(new Employee(rs.getInt(1), rs.getString(2), rs.getFloat(3)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
	}

	@Override
	public Employee view(int id) {
		String sql = "select * from test_employees where id = ?";
		Employee employee = null;
		try {
			PreparedStatement pst = getCon().prepareStatement(sql);
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				employee = new Employee(rs.getInt(1), rs.getString(2), rs.getFloat(3));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return employee;
	}

}