package com.entities;

import java.util.Date;
import java.util.Random;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class NotesTaker {

	@Id
	private int id;
	private String title;
	private String content;
	private Date date;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "NotesTaker [id=" + id + ", title=" + title + ", content=" + content + ", date=" + date + "]";
	}

	public NotesTaker(String title, String content, Date date) {
		super();
		this.id= new Random().nextInt(10000);
		this.title = title;
		this.content = content;
		this.date = date;
	}

	public NotesTaker() {
		super();
		// TODO Auto-generated constructor stub
	}

}
