package com.restful.domain;

import java.sql.Timestamp;

public class BoardVO {
	private int id;
	private String name;
	private String title;
	private String content;
	private Timestamp date;
	
	public BoardVO(){
		
	}

	public BoardVO(int id, String name, String title, String content, Timestamp date) {
		super();
		this.id = id;
		this.name = name;
		this.title = title;
		this.content = content;
		this.date = date;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public Timestamp getDate() {
		return date;
	}

	public void setDate(Timestamp date) {
		this.date = date;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return id + name + title + content + date;
	}
}
