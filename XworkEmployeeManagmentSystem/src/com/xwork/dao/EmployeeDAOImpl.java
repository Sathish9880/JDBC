package com.xwork.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.xwork.model.Employee;
import com.xwork.util.DBConnection;

public class EmployeeDAOImpl implements EmployeeDAO {

	Connection con = DBConnection.getConnection();
	PreparedStatement ps = null;

	@Override
	public void create(Employee employee) {
		// TODO Auto-generated method stub
		String insertQuery = "INSERT INTO employee_table(employee_name,email,address,contact,skill)VALUES(?,?,?,?,?)";

		try {
			ps = con.prepareStatement(insertQuery);

			ps.setString(1, employee.getName());
			ps.setString(2, employee.getEmail());
			ps.setString(3, employee.getAddress());
			ps.setString(4, employee.getTelephone());
			ps.setString(5, employee.getSkill());

			int i = ps.executeUpdate();
			System.out.println(i + " record inserted");
			System.out.println(ps);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}
	}

	@Override
	public Employee getEmployeeById(int employeeId) {
		// TODO Auto-generated method stub
		String getByIdQuery = " select * from employee_table where  employee_id=?";

		try {
			ps = con.prepareStatement(getByIdQuery);
			ps.setInt(1, employeeId);

			ResultSet rs = ps.executeQuery();
			Employee emp = new Employee();
			boolean isCheck = false;
			while (rs.next()) {
				isCheck = true;
				emp.setName(rs.getString("employee_name"));
				emp.setEmail(rs.getString("email"));
				emp.setAddress(rs.getString("address"));
				emp.setTelephone(rs.getString("contact"));
				emp.setSkill(rs.getString("skill"));

			}
			if (isCheck)
				return emp;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public void updateEmployeeById(String newEmail, int employeeId) {
		// TODO Auto-generated method stub
		String updateQuery = "update employee_table set email =? where employee_id =?";
		try {
			ps = con.prepareStatement(updateQuery);
			ps.setString(1, newEmail);
			ps.setInt(2, employeeId);
			int i = ps.executeUpdate();
			System.out.println(i + " records updated");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void delete(int employeeId) {
		// TODO Auto-generated method stub
		String delQuery = "delete from employee_table where employee_id=?";
		try {
			ps = con.prepareStatement(delQuery);
			ps.setInt(1, employeeId);
			int i = ps.executeUpdate();
			System.out.println(i + " records deleted");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<Employee> getAll() {
		// TODO Auto-generated method stub
		String query = "select * from employee_table";
		ResultSet rs = null;
		List<Employee> emplist = new ArrayList<>();
		try {
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();

			while (rs.next()) {
				Employee emp = new Employee();
				emp.setName(rs.getString("employee_name"));
				emp.setEmail(rs.getString("email"));
				emp.setAddress(rs.getString("address"));
				emp.setTelephone(rs.getString("contact"));
				emp.setSkill(rs.getString("skill"));
				emplist.add(emp);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return emplist;
	}

}
