package com.example.library.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Subscription {

	@Id
	private Integer subscriptionId;
	private String subscriberName;
	private String dateScbscribed;
	private String dateReturned;
	@ManyToOne
	private Book book;
	
	public Integer getSubscriptionId() {
		return subscriptionId;
	}
	public void setSubscriptionId(Integer subscriptionId) {
		this.subscriptionId = subscriptionId;
	}
	public String getSubscriberName() {
		return subscriberName;
	}
	public void setSubscriberName(String subscriberName) {
		this.subscriberName = subscriberName;
	}
	public String getDateScbscribed() {
		return dateScbscribed;
	}
	public void setDateScbscribed(String dateScbscribed) {
		this.dateScbscribed = dateScbscribed;
	}
	public String getDateReturned() {
		return dateReturned;
	}
	public void setDateReturned(String dateReturned) {
		this.dateReturned = dateReturned;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	
	
	
	
}
