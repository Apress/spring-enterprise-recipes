package com.apress.springenterpriserecipes.spring3;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class EventMain {
	public static void main(String[] args) throws Throwable {

		ClassPathXmlApplicationContext xmlContext = new ClassPathXmlApplicationContext("context1.xml");
		LibraryService libraryService = xmlContext.getBean("libraryService", LibraryService.class);
		Book aGreatBook = libraryService.getBooksByTitle("Spring Enterprise Recipes").iterator().next();
		while (libraryService.checkOutBook(aGreatBook))
			System.out.printf("Checked out %s.\n", aGreatBook.getTitle());

		System.out.printf("Couldn't check out %s anymore.\n", aGreatBook.getTitle());
	}
}
