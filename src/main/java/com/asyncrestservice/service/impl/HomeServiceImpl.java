package com.asyncrestservice.service.impl;

import java.util.concurrent.CompletionStage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asyncrestservice.model.User;
import com.asyncrestservice.repo.HomeRepo;
import com.asyncrestservice.service.HomeService;


/**
 * @author Kalidass Mahalingam
 *
 */
@Service("HomeService")
public class HomeServiceImpl implements HomeService {

	@Autowired
	HomeRepo homeRepo;
	
	@Override
	public CompletionStage<User> getUser() {
		return homeRepo.getUser();
	}

	@Override
	public CompletionStage<User> save(User user) {
		return homeRepo.save(user);
	}

}
