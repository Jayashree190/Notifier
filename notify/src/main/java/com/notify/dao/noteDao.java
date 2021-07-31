package com.notify.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import com.notify.model.Note;
import com.notify.utils.JDBCUtils;

public class noteDao
{
	
	private static String insertNote = "insert into note(endDate, noteDescription, noteName, remainderDate,status,startDate,noteBook_id) values (?, ?, ?,?,?,?,?);";
	
	
	
	
	private static String updateNote = "update note set endDate=?, noteDescription=?, noteName=?, remainderDate=?,status=?,startDate=? where noteBook_id=?  ;";
	
	private static String noteName = "select * from note where noteBook_id=?;";
	
	
	public static void validateNote(Note note) throws SQLException
	{
		System.out.println("Inside insert note");
		try(Connection con = JDBCUtils.getConnection(); 
		PreparedStatement statement = con.prepareStatement(insertNote)){
			statement.setDate(1, JDBCUtils.getSQLDate(note.getEndDate()));
			statement.setString(2, note.getDesc());
		
statement.setString(3, note.getNoteName());
			statement.setDate(4, JDBCUtils.getSQLDate(note.getRemDate()));
			statement.setBoolean(5,note.isStatus());
			statement.setDate(6, JDBCUtils.getSQLDate(note.getStartDate()));
			statement.setInt(7, note.getId());
			
			boolean stat = statement.executeUpdate() > 0;
			System.out.println("Insertion status : "+ stat);
			
		}
		
	
	}
	
	
	public static void uNote(Note note) throws SQLException
	{
		System.out.println("Inside insert note");
		try(Connection con = JDBCUtils.getConnection(); 
		PreparedStatement statement = con.prepareStatement(updateNote)){
			statement.setDate(1, JDBCUtils.getSQLDate(note.getEndDate()));
			statement.setString(2, note.getDesc());
		
                statement.setString(3, note.getNoteName());
			statement.setDate(4, JDBCUtils.getSQLDate(note.getRemDate()));
			statement.setBoolean(5,note.isStatus());
			statement.setDate(6, JDBCUtils.getSQLDate(note.getStartDate()));
			statement.setInt(7, note.getId());
			
			boolean stat = statement.executeUpdate() > 0;
			System.out.println("Insertion status : "+ stat);
			
		}
		
	
	}
	
	
	
	
	public static String startDate(int NoteBookId_) throws SQLException
	{
		System.out.println("sdate");
		String sd ="";
		
		//List <User> books = new ArrayList<>();
		try(Connection con = JDBCUtils.getConnection(); 
				PreparedStatement statement = con.prepareStatement(noteName))
		{
			statement.setInt(1, NoteBookId_);
			//System.out.println(userm.getUser_id());
			ResultSet rs = statement.executeQuery();
			//System.out.println(rs);
        //    while 
			if (rs.next())
            {
 				 //books =  rs.getString(2);
				sd =  rs.getString(7);
 			}	
		}
		//System.out.println(sd);
		return sd;
	
	}
	
	
	
	
	public static String endDate(int NoteBookId_) throws SQLException
	{
		System.out.println("edate");
		String ed ="";
		
		//List <User> books = new ArrayList<>();
		try(Connection con = JDBCUtils.getConnection(); 
				PreparedStatement statement = con.prepareStatement(noteName))
		{
			statement.setInt(1, NoteBookId_);
			//System.out.println(userm.getUser_id());
			ResultSet rs = statement.executeQuery();
			//System.out.println(rs);
        //    while 
			if (rs.next())
            {
 				 //books =  rs.getString(2);
				ed =  rs.getString(2);
 			}	
		}
		//System.out.println(ed);
		return ed;
	
	}
	
	
	
	public static String remDate(int NoteBookId_) throws SQLException
	{
		System.out.println("edate");
		String ed ="";
		
		//List <User> books = new ArrayList<>();
		try(Connection con = JDBCUtils.getConnection(); 
				PreparedStatement statement = con.prepareStatement(noteName))
		{
			statement.setInt(1, NoteBookId_);
			//System.out.println(userm.getUser_id());
			ResultSet rs = statement.executeQuery();
			//System.out.println(rs);
        //    while 
			if (rs.next())
            {
 				 //books =  rs.getString(2);
				ed =  rs.getString(5);
 			}	
		}
		System.out.println(ed);
		return ed;
	
	}
	
	
	
	public static String des(int NoteBookId_) throws SQLException
	{
		System.out.println("des");
		String ed ="";
		
		//List <User> books = new ArrayList<>();
		try(Connection con = JDBCUtils.getConnection(); 
				PreparedStatement statement = con.prepareStatement(noteName))
		{
			statement.setInt(1, NoteBookId_);
			//System.out.println(userm.getUser_id());
			ResultSet rs = statement.executeQuery();
			//System.out.println(rs);
        //    while 
			if (rs.next())
            {
 				 //books =  rs.getString(2);
				ed =  rs.getString(3);
 			}	
		}
		System.out.println(ed);
		return ed;
	
	}
	
	
	public static String status(int NoteBookId_) throws SQLException
	{
		System.out.println("des");
		String ed ="";
		
		//List <User> books = new ArrayList<>();
		try(Connection con = JDBCUtils.getConnection(); 
				PreparedStatement statement = con.prepareStatement(noteName))
		{
			statement.setInt(1, NoteBookId_);
			//System.out.println(userm.getUser_id());
			ResultSet rs = statement.executeQuery();
			//System.out.println(rs);
        //    while 
			if (rs.next())
            {
 				 //books =  rs.getString(2);
				ed =  rs.getString(6);
 			}	
		}
		System.out.println(ed);
		return ed;
	
	}
	
	
	
	public static String name(int NoteBookId_) throws SQLException
	{
		System.out.println("des");
		String ed ="";
		
		//List <User> books = new ArrayList<>();
		try(Connection con = JDBCUtils.getConnection(); 
				PreparedStatement statement = con.prepareStatement(noteName))
		{
			statement.setInt(1, NoteBookId_);
			//System.out.println(userm.getUser_id());
			ResultSet rs = statement.executeQuery();
			//System.out.println(rs);
        //    while 
			if (rs.next())
            {
 				 //books =  rs.getString(2);
				ed =  rs.getString(4);
 			}	
		}
		System.out.println(ed);
		return ed;
	
	}
	
	
	
	
	public static String getnoteName(int NoteBookId_) throws SQLException
	{
		System.out.println("noteBook");
		String noteName_ ="";
		
		//List <User> books = new ArrayList<>();
		try(Connection con = JDBCUtils.getConnection(); 
				PreparedStatement statement = con.prepareStatement(noteName))
		{
			statement.setInt(1, NoteBookId_);
			//System.out.println(userm.getUser_id());
			ResultSet rs = statement.executeQuery();
			//System.out.println(rs);
        //    while 
			if (rs.next())
            {
 				 //books =  rs.getString(2);
				noteName_ =  rs.getString(4);
 			}	
		}
		//System.out.println(nbName);
		return noteName_;
	
	}


	


	
	
	
	
	
}

