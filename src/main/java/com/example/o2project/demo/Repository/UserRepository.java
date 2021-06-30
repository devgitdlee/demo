package com.example.o2project.demo.Repository;

import com.example.o2project.demo.model.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

}
