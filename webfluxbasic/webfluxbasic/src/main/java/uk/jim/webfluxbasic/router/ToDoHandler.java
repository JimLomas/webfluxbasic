package uk.jim.webfluxbasic.router;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import reactor.core.publisher.Mono;
import uk.jim.webfluxbasic.database.ToDoRepository;

//Remove the todo controller and use the handler instead.
@Component 
public class ToDoHandler {
    private ToDoRepository toDoRepository;

    public ToDoHandler(ToDoRepository toDoRepository) {
        this.toDoRepository = toDoRepository;
    }
    
    //Mono<ServerResponse> is a reactive type that represents a single asynchronous response.
    //BodyBuilder fluent API is used to build the response with status code, headers, and body.
    public Mono<ServerResponse> getToDoById(ServerRequest request) {
        String id = request.pathVariable("id");
        return toDoRepository.findById(id)
                .flatMap(toDo -> ServerResponse.ok().bodyValue(toDo))
                .switchIfEmpty(ServerResponse.notFound().build());
    }

    public Mono<ServerResponse> getAllToDos(ServerRequest request) {
        return ServerResponse.ok().body(toDoRepository.findAll(), uk.jim.webfluxbasic.domain.ToDo.class);
    }
    
}
