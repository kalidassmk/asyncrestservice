package com.asyncrestservice.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.async.DeferredResult;

import com.asyncrestservice.util.Json;
import com.fasterxml.jackson.databind.JsonNode;
import com.asyncrestservice.resp.ErrorStatus;
import com.asyncrestservice.resp.ErrorStatus.ErrorType;
import com.asyncrestservice.resp.Response;

/**
 * @author Kalidass Mahalingam
 *
 */
@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(value = AsyncException.class)
	public DeferredResult<JsonNode> handleBaseException(AsyncException e) {
		DeferredResult<JsonNode> result = new DeferredResult<>();
		Response<Object> errorResponse = new Response<>();
		errorResponse.setStatus(new ErrorStatus(ErrorType.INTERNAL_ERROR));
		result.setResult(Json.toJson(errorResponse));
		return result;
	}

	@ExceptionHandler(value = Exception.class)
	public String handleException(Exception e) {
		return e.getMessage();
	}

}