package com.notify.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.notify.model.User;
import com.notify.model.noteBook;
import com.notify.utils.JDBCUtils;

public class notifyDao {
	private String insertUser = "insert into user (userName, mobileNumber, email, password)"
			+ "values (?, ?, ?,?);";
	private String newUser = "UPDATE user SET userName = ? , mobileNumber = ?, email=? , password=? where id = ?;";
	
	private String noteBook ="insert into  notebook  (noteBookName,user_id)"
	+ "values (?, ?);";
	
	private String noteBookupdate ="update  notebook set noteBookName =? where  user_id=?;";
	//DELETE FROM table_name WHERE condition;
	private String noteBookdelete ="delete from noteBook where  user_id=?;";
			
	private String Book ="select * from noteBook where user_id = ?;";
			

	public void inserUser(User userm) throws SQLException
	{
		System.out.println(insertUser);
		try(Connection con = JDBCUtils.getConnection(); 
				PreparedStatement statement = con.prepareStatement(insertUser)){
			statement.setString(1, userm.getUserName());
			statement.setString(2, userm.getMobileNumber());
			statement.setString(3, userm.getEmail());
			statement.setString(4, userm.getPassword());
			
			boolean status = statement.executeUpdate() > 0;
			System.out.println("Insertion status : "+ status);
		}
	}
	public void newUser(User userm) throws SQLException
	{
		System.out.println("Inside insert user");
		System.out.print(newUser);
		try(Connection con = JDBCUtils.getConnection(); 
				PreparedStatement statement = con.prepareStatement(newUser)){
			statement.setString(1, userm.getUserName());
			statement.setString(2, userm.getMobileNumber());
			statement.setString(3, userm.getEmail());
			statement.setString(4, userm.getPassword());
			statement.setInt(5, userm.getUser_id());
			
			boolean status = statement.executeUpdate() > 0;
			System.out.println("Insertion status : "+ status);
		}
	}
	
	public void note(noteBook userm) throws SQLException
	{
		
		
		try(Connection con = JDBCUtils.getConnection(); 
				PreparedStatement statement = con.prepareStatement(noteBook)){
			statement.setInt(2, userm.getId_());
			statement.setString(1, userm.getNoteBookName());
			
			System.out.println("addnotebook");
			boolean status = statement.executeUpdate() > 0;
			System.out.println("Insertion status : "+ status);
		}
	}
	
	public void updatenote(noteBook useru) throws SQLException
	{
		
		
		try(Connection con = JDBCUtils.getConnection(); 
				PreparedStatement statement = con.prepareStatement(noteBookupdate)){
			statement.setInt(2, useru.getId_());
			statement.setString(1, useru.getNoteBookName());
			
			System.out.println("updatenotebook");
			boolean status = statement.executeUpdate() > 0;
			System.out.println("Insertion status : "+ status);
		}
	}
	public void deletenote(int id_) throws SQLException
	{
		
		
		try(Connection con = JDBCUtils.getConnection(); 
				PreparedStatement statement = con.prepareStatement(noteBookdelete)){
			statement.setInt(1, id_);
			
			System.out.println("deletenotebook");
			boolean status = statement.executeUpdate() > 0;
			System.out.println("Insertion status : "+ status);
		}
	}
	
	public String books(User userm) throws SQLException
	{
		
		String nbName ="";
		//List <User> books = new ArrayList<>();
		try(Connection con = JDBCUtils.getConnection(); 
				PreparedStatement statement = con.prepareStatement(Book))
		{
			statement.setInt(1, userm.getUser_id());
			//System.out.println(userm.getUser_id());
			ResultSet rs = statement.executeQuery();
			//System.out.println(rs);
        //    while 
			if (rs.next())
            {
 				 //books =  rs.getString(2);
				nbName =  rs.getString(2);
 			}	
		}
		//System.out.println(nbName);
		return nbName;
	}
	
	}
