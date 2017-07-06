package com.asyncrestservice.controller;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
    @RequestMapping("/getUser")
    public DeferredResult<JsonNode> getUser() throws AsyncException {
        logger.info("getUser..............");
        DeferredResult<JsonNode> result = new DeferredResult<>();

        homeService.getUser().thenApply(user -> {
            logger.info("user.............." + user.toString());
            result.setResult(ResponseToClient.objectToClient(user));
            return result;
        });

        return result;
    }

    @Async
    @RequestMapping("/getUser1")
    public CompletableFuture<JsonNode> get() {
        return homeService.getUser().thenApply(user -> ResponseToClient.objectToClient(user)).toCompletableFuture();
    }

}
