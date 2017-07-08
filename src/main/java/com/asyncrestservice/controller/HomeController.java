package com.asyncrestservice.controller;

import javax.annotation.PostConstruct;

import com.asyncrestservice.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.async.DeferredResult;

import com.asyncrestservice.resp.ResponseToClient;
import com.asyncrestservice.service.HomeService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.asyncrestservice.exception.AsyncException;

import java.util.concurrent.CompletableFuture;

/**
 * @author Kalidass Mahalingam
 */
@RestController
public class HomeController {

    private final Logger logger = LoggerFactory.getLogger(HomeController.class);

    @Autowired
    HomeService homeService;

    ObjectMapper objectMapper = new ObjectMapper();

    @PostConstruct
    public void logSomething() {
        logger.info("Sample Debug Message");
    }

    @Async
    @RequestMapping(value = "/saveUser", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public CompletableFuture<JsonNode> save(@RequestBody User user) {
        logger.info("save................");
        return homeService.save(user).thenApply(userResp -> ResponseToClient.objectToClient(userResp)).toCompletableFuture();
    }

    @Async
    @RequestMapping(value = "/getAllUser", method = RequestMethod.GET)
    public CompletableFuture<JsonNode> get(@RequestParam(required = false, value = "id") String id) {
        logger.info("getAllUser................");
        return homeService.getUser().thenApply(user -> ResponseToClient.objectToClient(user)).toCompletableFuture();
    }

    @Async
    @RequestMapping(value = "/getUserById/{id}", method = RequestMethod.GET)
    public CompletableFuture<JsonNode> get(@PathVariable("id") int id) {
        logger.info("getUserById................");
        return homeService.getUser().thenApply(user -> ResponseToClient.objectToClient(user)).toCompletableFuture();
    }

    @Async
    @RequestMapping(value = "/testException", method = RequestMethod.GET)
    public CompletableFuture<String> get() throws AsyncException {
        logger.info("testException................");

        if(true)
            throw new AsyncException("custome message");
        return CompletableFuture.supplyAsync(() -> {
            return "";
        });
    }

}
