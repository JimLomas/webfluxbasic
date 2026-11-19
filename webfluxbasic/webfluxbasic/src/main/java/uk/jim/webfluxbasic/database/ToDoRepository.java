package uk.jim.webfluxbasic.database;

import uk.jim.webfluxbasic.domain.ToDo;

import java.util.Arrays;

import org.springframework.stereotype.Repository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository 
public class ToDoRepository {
    private Flux<ToDo> toDoFlux = Flux.fromIterable(Arrays.asList(
            new ToDo("Learn Spring WebFlux", false),
            new ToDo("Build a reactive application", false),
            new ToDo("Test the application", false)
    ));

    public Flux<ToDo> findAll() {
        return toDoFlux;
    }

    public Mono<ToDo> findById(String id) {
        return toDoFlux.filter(toDo -> toDo.getId().equals(id)).next();
    }
}
