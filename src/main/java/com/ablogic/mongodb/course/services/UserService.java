package com.ablogic.mongodb.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ablogic.mongodb.course.domain.User;
import com.ablogic.mongodb.course.dto.UserDTO;
import com.ablogic.mongodb.course.repository.UserRepository;
import com.ablogic.mongodb.course.services.exception.ObjectNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public List<User> findAll() {
		return userRepository.findAll();
	}
	
	public User findById(String id) {
	
		Optional<User> user = userRepository.findById(id);
		
		return user.orElseThrow(() -> new ObjectNotFoundException("Object not found"));
	}
	
	public User insertUser(User user) {
		return userRepository.insert(user);
	}
	
	public void delete(String id) {
		findById(id);
		userRepository.deleteById(id);
	}
	
	public User update(User obj) {
		User newObj = findById(obj.getId());
		updateData(newObj, obj);
		return userRepository.save(newObj);
	}
	
	private void updateData(User newObj, User obj) {
		newObj.setName(obj.getName());
		newObj.setEmail(obj.getEmail());		
	}

	public User fromDTO(UserDTO userDTO) {
		return new User(userDTO.getId(), userDTO.getName(), userDTO.getEmail()); 
	}
	
}
