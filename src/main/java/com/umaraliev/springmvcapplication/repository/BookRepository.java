package com.umaraliev.springmvcapplication.repository;

import com.umaraliev.springmvcapplication.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Id;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    void deleteById(Id id);

    Book getById(Id id);
}
