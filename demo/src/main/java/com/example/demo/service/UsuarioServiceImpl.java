package com.example.demo.service;

import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.Usuario;
import com.example.demo.domain.UsuarioRepository;
import com.example.demo.exception.UsuarioNotFoundException;

@RestController
@RequestMapping (value="/usuarios")
public class UsuarioServiceImpl implements UsuarioService {
	
	private static final Logger logger= LoggerFactory.getLogger(UsuarioService.class);
	
	@Autowired
	UsuarioRepository usuarioRepository;
	
	
	
	public UsuarioServiceImpl(UsuarioRepository usuarioRepository) {
		super();
		this.usuarioRepository = usuarioRepository;
	}

	//localhost:8050/usuarios
	//POST --> INSERTAR
	@PostMapping
	public ResponseEntity create(@RequestBody Usuario usuario) throws URISyntaxException {
		Usuario usuario_new=usuarioRepository.save(usuario);
		return ResponseEntity.ok(usuario_new);
	}
	
	//localhost:8050/usuarios/{id}
	//PUT --> ACTUALIZAR
	@PutMapping(value = "/{id}")
	public ResponseEntity<Usuario> update(@PathVariable("id") Long id, @RequestBody Usuario usuario) {
		
		return usuarioRepository.findById(id)
				.map(record->{
					record.setNombre(usuario.getNombre());
					record.setApellido(usuario.getApellido());
					record.setCorreo(usuario.getCorreo());
					record.setCelular(usuario.getCelular());
					record.setPassword(usuario.getPassword());
					record.setTelefono(usuario.getTelefono());
					Usuario actualizado=usuarioRepository.save(record);
					return ResponseEntity.ok().body(actualizado);
				}).orElse(ResponseEntity.notFound().build());
	}
	
	
	
	
	//localhost:8050/usuarios/{id}
	//DELETE --> ELIMINAR
	@DeleteMapping("/{id}")
	public ResponseEntity delete(@PathVariable Long id) {
		usuarioRepository.deleteById(id);
		return ResponseEntity.ok().build();
	}
	
	
	//READ --> LEER
	//localhost:8050/usuarios/{id}
	@GetMapping("/{id}")
	public Usuario getClient(@PathVariable long id) throws UsuarioNotFoundException {
		return usuarioRepository.findById(id).orElseThrow(RuntimeException:: new);
	}
	
	
	//READ --> LEER
	//localhost:8050/usuarios/users
	@GetMapping("/users")
	public Iterable<Usuario> findAll() {
		return usuarioRepository.findAll();
	}
	
}
