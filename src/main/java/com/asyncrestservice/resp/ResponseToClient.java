package com.asyncrestservice.resp;

import java.util.List;
import java.util.concurrent.CompletionException;

import com.asyncrestservice.resp.Info.InfoType;
import com.asyncrestservice.util.Json;
import com.fasterxml.jackson.databind.JsonNode;

/**
 * @author Kalidass Mahalingam
 *
 */
public class ResponseToClient {

	public ResponseToClient() {
    }

	public static JsonNode objectToClient(Object obj) {
		Response<Object> response = new Response<>();
		response.setStatus(new Info(InfoType.INFO_OK));
		response.setPayLoad(obj);
		return Json.toJson(response);
	}
	
	public static JsonNode listToClient(List<? extends Object> list) {
		try {
			Response<Object> response = new Response<>();
			response.setStatus(new Info(InfoType.INFO_OK));
			response.setPayLoad(list);
			return Json.toJson(response);
		} catch (Exception e) {
			e.printStackTrace();
			throw new CompletionException(e);
		}
	}

	public static JsonNode objectToClient(Object obj, Status status) {
		try {
			Response<Object> response = new Response<>();
			response.setStatus(status);
			response.setPayLoad(obj);
			return Json.toJson(response);
		} catch (Exception e) {
			e.printStackTrace();
			throw new CompletionException(e);
		}
	}



}
