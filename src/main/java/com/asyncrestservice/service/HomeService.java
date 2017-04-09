package com.asyncrestservice.service;

import java.util.concurrent.CompletionStage;

import com.asyncrestservice.model.User;

/**
 * @author Kalidass Mahalingam
 *
 */
public interface HomeService {

	public CompletionStage<User> getUser();

}
