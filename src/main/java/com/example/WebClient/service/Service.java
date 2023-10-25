package com.example.WebClient.service;

import com.example.WebClient.dto.PostBody;
import com.example.WebClient.util.ReadFileInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import java.io.IOException;

@org.springframework.stereotype.Service
public class Service {
    private final WebClient webClient;
    private final ReadFileInfo readFileInfo;


    @Autowired
    public Service(WebClient.Builder webClientBuilder, ReadFileInfo readFileInfo) throws IOException {
        this.webClient = webClientBuilder.baseUrl(readFileInfo.returnContent()).build();
        this.readFileInfo = readFileInfo;
    }

    public Mono<PostBody> createPost(PostBody postBody) throws IOException {

        return webClient.post()
                .uri(readFileInfo.returnContent())
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE)
                .body(BodyInserters.fromValue(postBody))
                .retrieve()
                .bodyToMono(PostBody.class);
    }

    public Mono<PostBody> getPostById(int id) throws IOException {
        return webClient.get()
                .uri(readFileInfo.returnContent() + "/" + id)
                .retrieve()
                .bodyToMono(PostBody.class);
    }

    public Mono<PostBody> updatePost(PostBody postBody) throws IOException {
        return webClient.put()
                .uri(readFileInfo.returnContent())
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE)
                .body(BodyInserters.fromValue(postBody))
                .retrieve()
                .bodyToMono(PostBody.class);
    }

    public Mono<Void> deletePost(int id) throws IOException {
        return webClient.delete()
                .uri(readFileInfo.returnContent())
                .retrieve()
                .bodyToMono(Void.class);
    }

    public Flux<PostBody> getAllPosts() throws IOException {
        return webClient.get()
                .uri(readFileInfo.returnContent())
                .retrieve()
                .bodyToFlux(PostBody.class);
    }
}
