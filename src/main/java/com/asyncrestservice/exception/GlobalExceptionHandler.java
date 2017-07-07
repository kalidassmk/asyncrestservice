package com.asyncrestservice.exception;

import com.asyncrestservice.resp.ResponseToClient;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.async.DeferredResult;

import com.asyncrestservice.util.Json;
import com.fasterxml.jackson.databind.JsonNode;
import com.asyncrestservice.resp.ErrorStatus;
import com.asyncrestservice.resp.ErrorStatus.ErrorType;
import com.asyncrestservice.resp.Response;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

/**
 * @author Kalidass Mahalingam
 *
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(value = Exception.class)
	public  Response<Object> handleException(Exception e) {
		e.printStackTrace();
		Response<Object> errorResponse = new Response<>();
		CompletableFuture future = new CompletableFuture();
		errorResponse.setStatus(new ErrorStatus(ErrorType.INTERNAL_ERROR));
		future.complete(ResponseToClient.objectToClient(errorResponse));
		return errorResponse;
	}

}