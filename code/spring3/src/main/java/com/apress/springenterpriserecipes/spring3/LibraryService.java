package com.apress.springenterpriserecipes.spring3;

import java.util.Collection;

public interface LibraryService {
	Collection<Book> getBooksByTitle(String title);

	Book getBookById(String catId);

	boolean checkOutBook(Book book);
}
