package com.hand.entity;

public class Film  extends IdEntiry{
	private String title;
	private String description;
	private String language;
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "film [title=" + title + ", description=" + description + ", language=" + language + ", id=" + id + "]";
	}
	
	
	
}