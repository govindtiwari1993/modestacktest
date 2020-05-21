package com.modestack.assignment.apiassignment.article;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.modestack.assignment.apiassignment.user.User;

//This class is being used for article posting as a entity.
@Entity
public class Article {
	
	@Id
	private String title;
	private String body;
	private String author;
	private String accessToken;
	public String getAccessToken() {
		return accessToken;
	}
	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}
	

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	
	public Article() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Article [title=" + title + ", body=" + body + ", author=" + author + "]";
	}
	
	
	

}
