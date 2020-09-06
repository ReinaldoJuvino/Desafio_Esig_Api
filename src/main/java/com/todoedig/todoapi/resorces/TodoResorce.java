package com.todoedig.todoapi.resorces;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.todoedig.todoapi.models.Todo;
import com.todoedig.todoapi.repository.TodoRepository;

@RestController
@RequestMapping(value="/api")
@CrossOrigin(origins = "*")
public class TodoResorce {
	
	@Autowired
	TodoRepository todoRepository;
	
	@GetMapping("/todo")
	public List<Todo> listarTodo(){
		
		return todoRepository.findAll();
		
	}
	//@pathVariable serve para pegar o id vindo da url e atribuilo como parametro para o id 
	@GetMapping("/todo/{id}")
	public Todo listarTodoUnico(@PathVariable(value = "id")   long id){
		
		return todoRepository.findById(id);
		
	}
	
	@PostMapping("/todo")
	public Todo salvarTodo(@RequestBody Todo todo) {
		
		return todoRepository.save(todo);
	
	}
	
	@DeleteMapping("/todo")
	public void deletaTodo(@RequestBody Todo todo) {
		
		todoRepository.delete(todo);
		
	}
	
	@PutMapping("/todo")
	public Todo atualizaTodo(@RequestBody Todo todo) {
		return todoRepository.save(todo);
		
	}
}
