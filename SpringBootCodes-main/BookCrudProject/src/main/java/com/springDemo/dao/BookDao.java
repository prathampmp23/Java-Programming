package com.springDemo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.springDemo.model.BookView;
import com.springDemo.model.Books;

//@Repository -> no need to write from spring 6
public interface BookDao extends JpaRepository<Books, Integer>{
//	we need to write conventional method explicitly here only on autowiring its implementation done by spring
	public List<Books> findAllByTitle(String title);
	
//	@Query - JPQL Query
//	@Query("SELECT MAX(u.age) FROM user u")
//  public Integer maxAge();
	
//	Native way
//	Interface based projection way (Recommended)
	@Query("SELECT b.title AS title, b.description AS desc FROM book b")
	List<BookView> findPartialdata();
	
//	@Modifying -> only for update 
//	@Query("UPDATE book b SET b.title =:title WHERE b.bookid = :id")
	
	
//	@Transactional -> make method follows ACID property (update ,add , delete) 
//	to implement the Transaction management
	
	
}
