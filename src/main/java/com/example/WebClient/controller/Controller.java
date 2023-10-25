package com.example.WebClient.controller;

import com.example.WebClient.dto.PostBody;
import com.example.WebClient.service.Service;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.io.IOException;

@RestController
@RequestMapping("/third-party-api")
public class Controller {

    private final Service service;

    public Controller(Service service) {
        this.service = service;
    }
    @PostMapping("")
    public Mono<PostBody> createPost(@RequestBody PostBody postBody) throws IOException {
        return service.createPost(postBody);
    }
    @GetMapping("/{id}")
    public Mono<PostBody> getPostById(@PathVariable int id) throws IOException {
        return service.getPostById(id);
    }
    @GetMapping("")
    public Flux<PostBody> getAllPost() throws IOException {
        return service.getAllPosts();
    }
    @DeleteMapping("/{id}")
    public Mono<Void> deletePost(@PathVariable int id) throws IOException {
        return service.deletePost(id);
    }
    @PutMapping("")
    public Mono<PostBody> updatePost(@RequestBody PostBody postBody) throws IOException {
        return service.updatePost(postBody);
    }

}
