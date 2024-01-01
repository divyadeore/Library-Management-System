package com.library.library.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.library.library.Entity.book;

public interface BookRepository extends  JpaRepository<book, Long>  {

    

    
}
