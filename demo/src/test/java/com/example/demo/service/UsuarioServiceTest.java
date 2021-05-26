package com.example.demo.service;

import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.domain.Usuario;
import com.example.demo.exception.UsuarioNotFoundException;

@SpringBootTest
@RunWith(SpringRunner.class)
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class UsuarioServiceTest {
	private static final Logger logger=LoggerFactory.getLogger(UsuarioServiceTest.class);
	
	@Autowired
	private UsuarioService usuarioService;
	
//@Test
//public void testFindUsuarioById() {
//	
//	long ID = 1;
//	String NAME="Richard";
//	Usuario usuario=null;
//	try {
//		usuario=usuarioService.findById(ID);
//	}catch(UsuarioNotFoundException e){
//		fail(e.getMessage());
//	}
//	logger.info(""+usuario);
//	assertEquals(NAME, usuario.getNombre());
//	
//}
	
	
}
