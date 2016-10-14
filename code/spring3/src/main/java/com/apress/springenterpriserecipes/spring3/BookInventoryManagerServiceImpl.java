package com.apress.springenterpriserecipes.spring3;

import org.springframework.context.ApplicationListener;

import com.apress.springenterpriserecipes.spring3.events.CopiesExhaustedApplicationEvent;

public class BookInventoryManagerServiceImpl implements
      BookInventoryManagerService,
      ApplicationListener<CopiesExhaustedApplicationEvent> {

   public void purchaseMoreCopiesOfABook(Book book) {
      // ...
   }

   public void onApplicationEvent(CopiesExhaustedApplicationEvent event) {
      System.out.printf("Received a CopiesExhaustedApplicationEvent for book %s\n",
            event.getBook().getTitle());
      this.purchaseMoreCopiesOfABook(event.getBook());
   }

}
