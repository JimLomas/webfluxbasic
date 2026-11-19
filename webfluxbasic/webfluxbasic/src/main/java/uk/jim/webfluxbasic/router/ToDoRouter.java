package uk.jim.webfluxbasic.router;
//Webflux uses function programming to define routes.
// This is a router class that defines the routes for the ToDo application.
// This replaces the traditional @RestController approach with a functional style of routing.

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RequestPredicates.GET;

@Configuration 
public class ToDoRouter {
    
@Bean
public RouterFunction<ServerResponse> route(ToDoHandler toDoHandler) {
    return RouterFunctions
            .route(GET("/todo/{id}").and(accept(MediaType.APPLICATION_JSON)), toDoHandler::getToDoById)
            .andRoute(GET("/todo").and(accept(MediaType.APPLICATION_JSON)), toDoHandler::getAllToDos);
    }
}
