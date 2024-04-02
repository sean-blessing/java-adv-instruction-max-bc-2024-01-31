package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Movie;

public class MovieDb {
	
	public static ArrayList<Movie> getAll() {
		ArrayList<Movie> movies = new ArrayList<>();
		String sql = "SELECT * FROM Movie";
		try ( Connection connection = BmdbDb.getConnection();
			  PreparedStatement ps = connection.prepareStatement(sql);
			  ResultSet rs = ps.executeQuery()) {
			while (rs.next()) {
				Movie m = parseMovieFromResultSet(rs);
				movies.add(m);
			}
		}
		catch (SQLException sqle) {
			System.err.println(sqle);
			movies = null;
		}
		return movies;
	}

	private static Movie parseMovieFromResultSet(ResultSet rs) throws SQLException {
		int id = rs.getInt("Id");
		String title = rs.getString("Title");
		int year = rs.getInt("Year");
		String rating = rs.getString("Rating");
		String director = rs.getString("Director");
		Movie m = new Movie(id, title, year, rating, director);
		return m;
		
	}

}
