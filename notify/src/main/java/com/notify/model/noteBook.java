package com.notify.model;

public class noteBook 
{
	public noteBook() {
		super();
		// TODO Auto-generated constructor stub
	}
	int id_;
	String noteBookName;
	public int getId_() {
		return id_;
	}
	public void setId_(int id_) {
		this.id_ = id_;
	}
	public String getNoteBookName() {
		return noteBookName;
	}
	public void setNoteBookName(String noteBookName) {
		this.noteBookName = noteBookName;
	}
	public noteBook(int id_, String noteBookName) {
		super();
		this.id_ = id_;
		this.noteBookName = noteBookName;
	}
	
	public noteBook(int id_) {
		super();
		this.id_ = id_;
	}
}
