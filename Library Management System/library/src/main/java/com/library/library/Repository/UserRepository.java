package com.library.library.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.library.library.Entity.user;

public interface UserRepository extends JpaRepository<user, Long>  {

    

    
}
