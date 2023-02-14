package com.javaavancado.ouvidoria.servicies;

import java.util.List;
import java.util.Optional;

//import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.javaavancado.ouvidoria.entities.User;
import com.javaavancado.ouvidoria.repositories.UserRepository;
//import com.javaavancado.ouvidoria.servicies.exceptions.DatabaseException;
import com.javaavancado.ouvidoria.servicies.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	public User insert(User user) {
		return repository.save(user);
	}
	
	public User findById(Long id) {
		Optional<User> user = repository.findById(id);
		return user.orElseThrow(()->new ResourceNotFoundException(id));
	}
	
	public List<User> findAll() {
		return repository.findAll();
	}
	
	public User update(Long id, User user) {
		try {
			// PREPARANDO O OBJ MONITORADO
			User entity = repository.getReferenceById(id);
			updateData(entity, user);
			return repository.save(entity);
		} catch(EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}
	
	public void delete(Long id) {
		try {
			repository.deleteById(id);
		}catch(EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		}
//		catch(ConstraintViolationException e) {
//			throw new DatabaseException(e.getMessage());
//		}
	}
	
	private void updateData(User entity, User user) {
		entity.setLogin(user.getLogin());
		entity.setPassword(user.getPassword());
		entity.setName(user.getName());
		entity.setEmail(user.getEmail());
		entity.setPhone(user.getPhone());
	}
}