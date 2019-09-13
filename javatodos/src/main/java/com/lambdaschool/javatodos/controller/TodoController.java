package com.lambdaschool.javatodos.controller;


import com.lambdaschool.javatodos.model.Todo;
import com.lambdaschool.javatodos.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/todos")
public class TodoController {
    @Autowired
    private TodoService todoService;

    //Put
    // localhost:2019/todos/todoid/{todoid}
    @PutMapping(value="/todoid/{todoid}", consumes = {"application/json"}, produces = {"application/json"})
    public ResponseEntity<?> editTodo(@Valid @RequestBody Todo todo, @PathVariable long todoid){
        todo=todoService.update(todo,todoid);
        return new ResponseEntity<>(todo, HttpStatus.OK);
    }
}