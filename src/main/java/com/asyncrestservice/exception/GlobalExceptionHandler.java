package com.asyncrestservice.exception;

import com.asyncrestservice.resp.ResponseToClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import com.asyncrestservice.resp.ErrorStatus;
import com.asyncrestservice.resp.ErrorStatus.ErrorType;
import com.asyncrestservice.resp.Response;

import java.util.concurrent.CompletableFuture;

/**
 * @author Kalidass Mahalingam
 *
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

	private final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

	@ExceptionHandler(value = Exception.class)
	public  Response<Object> handleException(Exception e) {
		logger.info("exception ................"+e.getMessage());
		e.printStackTrace();
		Response<Object> errorResponse = new Response<>();
		CompletableFuture future = new CompletableFuture();
		errorResponse.setStatus(new ErrorStatus(ErrorType.INTERNAL_ERROR));
		future.complete(ResponseToClient.objectToClient(errorResponse));
		return errorResponse;
	}

}