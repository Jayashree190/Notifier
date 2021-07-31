package com.notify.model;

import java.time.LocalDate;

public class Note 
{
	private int note_id;
	private int id;
    private String noteName;
    private LocalDate startDate;
    private LocalDate endDate;
    private LocalDate remDate;
    private boolean status;
    private String desc;

    protected Note() {

    }

	public Note(String noteName, LocalDate startDate, LocalDate endDate, LocalDate remDate, boolean status,
			String desc) {
		super();
		this.noteName = noteName;
		this.startDate = startDate;
		this.endDate = endDate;
		this.remDate = remDate;
		this.status = status;
		this.desc = desc;
	}

	public Note(int id, String noteName, LocalDate startDate, LocalDate endDate, LocalDate remDate, boolean status,
			String desc) {
		super();
		this.id = id;
		this.noteName = noteName;
		this.startDate = startDate;
		this.endDate = endDate;
		this.remDate = remDate;
		this.status = status;
		this.desc = desc;
	}

	public int getId() {
		System.out.println(id);
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNoteName() {
		return noteName;
	}

	public void setNoteName(String noteName) {
		this.noteName = noteName;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public LocalDate getRemDate() {
		return remDate;
	}

	public void setRemDate(LocalDate remDate) {
		this.remDate = remDate;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public int getNote_id() {
		return note_id;
	}

	public void setNote_id(int note_id) {
		this.note_id = note_id;
	}
}
