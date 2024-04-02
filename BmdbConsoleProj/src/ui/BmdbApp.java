package ui;

import java.util.ArrayList;

import db.MovieDb;
import model.Movie;

public class BmdbApp {

	public static void main(String[] args) {
		System.out.println("Welcome to the BMDB App!");
		
		ArrayList<Movie> movies = MovieDb.getAll();
		
		System.out.println("List of Movies:");
		for (Movie m: movies) {
			System.out.println(m);
		}
		
		
		System.out.println("Bye");

	}

}
