package com.example.demo.domain;

import java.util.ArrayList;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import antlr.collections.List;

@Entity
@Table(name="usuario")
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (name="id")
	private long id;
	@Column (name="correo")
	private String correo;
	@Column (name="nombre")
	private String nombre;
	@Column (name="apellido")
	private String apellido;
	@Column(name ="contrasena")
	private String password;
	@Column(name ="nro_telefono")
	private String telefono;
	@Column(name ="nro_celular")
	private String celular;
	@Column(name ="token")
	private String token;
	
	
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn( name = "usuario_id", referencedColumnName = "id" )
	List<Solicitudes> solicitudes = new ArrayList<>();
	
	public Usuario() {
		super();
	}

	

	public Usuario(long id, String correo, String nombre, String apellido, String password, String telefono,
			String celular, String token) {
		super();
		this.id = id;
		this.correo = correo;
		this.nombre = nombre;
		this.apellido = apellido;
		this.password = password;
		this.telefono = telefono;
		this.celular = celular;
		this.token = token;
	}
	
	

	public Usuario(String correo, String nombre, String apellido, String password, String telefono, String celular,
			String token) {
		super();
		this.correo = correo;
		this.nombre = nombre;
		this.apellido = apellido;
		this.password = password;
		this.telefono = telefono;
		this.celular = celular;
		this.token = token;
	}
	
	



	public Usuario(String correo, String nombre, String apellido, String password, String telefono, String celular) {
		super();
		this.correo = correo;
		this.nombre = nombre;
		this.apellido = apellido;
		this.password = password;
		this.telefono = telefono;
		this.celular = celular;
	}



	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}


	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", correo=" + correo + ", nombre=" + nombre + ", apellido=" + apellido
				+ ", password=" + password + ", telefono=" + telefono + ", celular=" + celular + ", token=" + token
				+ "]";
	}

}
