package com.todoedig.todoapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.todoedig.todoapi.models.Todo;

public interface TodoRepository extends JpaRepository<Todo,  Long> {
	
	Todo findById(long id);
	
}

