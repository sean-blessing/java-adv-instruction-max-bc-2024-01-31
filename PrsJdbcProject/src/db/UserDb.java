package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.User;

public class UserDb {
	
	public static ArrayList<User> getAll() {
		ArrayList<User> users = new ArrayList<>();
		String sql = "SELECT * FROM User";
		try ( Connection connection = PrsDb.getConnection();
			  PreparedStatement ps = connection.prepareStatement(sql);
			  ResultSet rs = ps.executeQuery()) {
			while (rs.next()) {
				User u = parseUserFromResultSet(rs);
				users.add(u);
			}
		}
		catch (SQLException sqle) {
			System.err.println(sqle);
			users = null;
		}
		return users;
	}
	
	public static User getById(int id) {
		User user = null;
		String sql = "SELECT * FROM User WHERE Id = ?";
		try (Connection connection = PrsDb.getConnection();
			 PreparedStatement ps = connection.prepareStatement(sql)) {
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				user = parseUserFromResultSet(rs);
			}
		}
		catch (SQLException sqle) {
			System.err.println(sqle);
		}
		
		return user;
	}
	
	private static User parseUserFromResultSet(ResultSet rs) throws SQLException {
		int id = rs.getInt(1);
		String un = rs.getString(2);
		String pw = rs.getString(3);
		String fn = rs.getString(4);
		String ln = rs.getString(5);
		String phone = rs.getString(6);
		String email = rs.getString(7);
		boolean rvw = rs.getBoolean(8);
		boolean adm = rs.getBoolean(9);
		User u = new User(id, un, pw, fn, ln, phone, email, rvw, adm);
		return u;
	}
	
	public static boolean add(User user) {
		boolean success = false;
		
		String sql = "INSERT INTO User (Username, Password, FirstName, " 
					 + "LastName, Phone, Email, Reviewer, Admin)"
					 + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
		
		try (Connection connection = PrsDb.getConnection();
			 PreparedStatement ps = connection.prepareStatement(sql)) {
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			ps.setString(3, user.getFirstname());
			ps.setString(4, user.getLastname());
			ps.setString(5, user.getPhone());
			ps.setString(6, user.getEmail());
			ps.setBoolean(7, user.isReviewer());
			ps.setBoolean(8, user.isAdmin());
			ps.executeUpdate();
			success = true;
		}
		catch (SQLException sqle) {
			System.err.println(sqle);
		}
		return success;
	}
	
	// skipping update
	
	public static boolean delete(int id) {
		boolean success = false;
		String sql = "DELETE FROM USER WHERE Id = ?";
		
		try (Connection connection = PrsDb.getConnection();
			 PreparedStatement ps = connection.prepareStatement(sql)) {
			ps.setInt(1, id);
			int rowsAffected = ps.executeUpdate();
			if (rowsAffected != 0) 
				success = true;
		}
		catch (SQLException sqle) {
			System.err.println(sqle);
		}
		return success;
	}

}
