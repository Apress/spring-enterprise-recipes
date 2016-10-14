package com.apress.springenterpriserecipes.spring3.events;

import org.springframework.context.ApplicationEvent;

import com.apress.springenterpriserecipes.spring3.Book;

public class CopiesExhaustedApplicationEvent extends ApplicationEvent {
	private static final long serialVersionUID = 1L;

	private Book book;

	public CopiesExhaustedApplicationEvent(Object source, Book book) {
		super(source);
		this.book = book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public Book getBook() {
		return book;
	}

}
