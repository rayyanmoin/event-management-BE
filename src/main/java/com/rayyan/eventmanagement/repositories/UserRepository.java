package com.rayyan.eventmanagement.repositories;

import com.rayyan.eventmanagement.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {

}
