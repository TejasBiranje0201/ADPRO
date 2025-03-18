package com.adpro.serviceIMPL;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adpro.entity.User;
import com.adpro.repository.UserRepository;
import com.adpro.service.UserService;
@Service
public class UserServiceIMPL implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public List<User> list() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

	@Override
	public User getById(int id) {
		// TODO Auto-generated method stub
		return userRepository.findById(id).orElse(null);
	}

	@Override
	public User save(User user) {
		// TODO Auto-generated method stub
		return userRepository.save(user);
	}

	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		userRepository.deleteById(id);
	}

}
