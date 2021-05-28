package com.example.demo.domain;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository
	extends JpaRepository<Usuario, Long>{
		
	//Fetch user by id
	List<Usuario> findById(String id);
	
	//Fetch user by name
	List<Usuario> findByNombre(String nombre);
	
	//Fetch user by last_name
	List<Usuario> findByApellido (String apellido);
}
