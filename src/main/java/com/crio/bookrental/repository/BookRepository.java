package com.crio.bookrental.repository;
/*
 * @author adityagupta
 * @date 05/04/24
 */

import com.crio.bookrental.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Integer> {
}
