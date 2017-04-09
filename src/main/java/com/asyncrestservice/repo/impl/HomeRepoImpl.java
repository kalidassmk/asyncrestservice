package com.asyncrestservice.repo.impl;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

import org.springframework.stereotype.Repository;

import com.asyncrestservice.model.User;
import com.asyncrestservice.repo.HomeRepo;

/**
 * @author Kalidass Mahalingam
 *
 */
@Repository("HomeRepo")
public class HomeRepoImpl implements HomeRepo {

	@Override
	public CompletionStage<User> getUser() {
		return	CompletableFuture.supplyAsync(() -> {
			User user = new User("Kalidass","Mahalingam","Singapore","01234567");
			return user;
		});
		
	}

}
