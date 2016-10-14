package com.apress.springenterpriserecipes.spring3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationEvent;

import com.apress.springenterpriserecipes.spring3.events.CopiesExhaustedApplicationEvent;

public class LibraryServiceImpl implements LibraryService, ApplicationContextAware,
      InitializingBean {

   private List<Book> books;
   private ApplicationContext context;

   public Book getBookById(String id) {
      for (Book book : books)
         if (book.getId().equalsIgnoreCase(id))
            return book;
      return null;
   }

   public Collection<Book> getBooksByTitle(String title) {
      Collection<Book> matches = new ArrayList<Book>();
      for (Book book : books)
         if (book.getTitle().equalsIgnoreCase(title))
            matches.add(book);
      return matches;
   }

   public void afterPropertiesSet() throws Exception {
      this.books = Arrays.asList(new Book("Spring Enterprise Recipes"), new Book(
            "Spring Recipes"), new Book("Thinking In Java"));
      for (Book b : this.books) {
         b.setCopiesCheckedOut(0);
         b.setTotalCopiesAvailable(2);
      }
   }

   public void setApplicationContext(ApplicationContext applicationContext)
         throws BeansException {
      this.context = applicationContext;
   }

   public boolean checkOutBook(Book book) {
      if (this.books.contains(book)) {
         if (book.getTotalCopiesAvailable() > 0) {
            book.setTotalCopiesAvailable(book.getTotalCopiesAvailable() - 1);
            return true;
         } else {
            ApplicationEvent evt = new CopiesExhaustedApplicationEvent(this, book);
            context.publishEvent(evt);
            return false;
         }
      }
      return false;
   }

}
