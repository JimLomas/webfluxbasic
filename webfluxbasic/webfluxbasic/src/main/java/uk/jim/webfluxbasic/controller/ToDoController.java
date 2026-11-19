package uk.jim.webfluxbasic.controller;

import uk.jim.webfluxbasic.domain.ToDo;

import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController 
public class ToDoController {
    private final uk.jim.webfluxbasic.database.ToDoRepository toDoRepository;

    // Pass the repository into the controller via constructor injection
    // This is a common pattern in Spring applications, allowing for better testability
    // and separation of concerns or separation of logic into different layers.
    public ToDoController(uk.jim.webfluxbasic.database.ToDoRepository toDoRepository) {
        this.toDoRepository = toDoRepository;
    }

    @GetMapping("/todo/{id}")
    public Mono<ToDo> getToDoById(@RequestParam String id) {
        return toDoRepository.findById(id);
    }
    
    @GetMapping("/todo")
    public Flux<ToDo> getAllToDos() {
        return toDoRepository.findAll();
    }
    
}   