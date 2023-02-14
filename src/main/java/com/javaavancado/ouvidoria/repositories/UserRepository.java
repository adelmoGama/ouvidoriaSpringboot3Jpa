package com.javaavancado.ouvidoria.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javaavancado.ouvidoria.entities.User;

public interface UserRepository extends JpaRepository<User, Long>  {

}