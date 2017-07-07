package com.asyncrestservice.repo;

import java.util.concurrent.CompletionStage;

import com.asyncrestservice.model.User;

/**
 * @author Kalidass Mahalingam
 *
 */
public interface HomeRepo {
	public CompletionStage<User> getUser();
	public CompletionStage<User> save(User user);
}
