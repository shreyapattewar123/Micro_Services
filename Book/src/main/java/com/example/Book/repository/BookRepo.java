package com.example.Book.repository;

import com.example.Book.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface BookRepo extends JpaRepository<Book,Integer> {
   // @Query(nativeQuery = true, value = "select ca.id,ca.lane1,ca.lane2,ca.state,ca.zip from bankdb.address ca join bankdb.customer c on c.id=ca.customer_id where ca.customer_id=:customerId;")
    //Book findBookByBookId(@Param("bookId") int bookId);
}
