package com.examen.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_user")
public class Usuario implements Serializable {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_user")
	private int id;
	@Column(name = "tx_uid", length = 128, nullable = false)
	private String id_usuario;
	@Column(name = "tx_user", length = 32, nullable = false)
	private String usuario;
	@Column(name = "tx_email", length = 32, nullable = false, unique = true)
	private String email;
	@Column(name = "tx_pass", length = 128, nullable = false)
	private String password;
	@Column(name = "tx_rol", length = 32, nullable = false)
	private String rol;
	@Column(name = "tx_fullName", length = 64)
	private String fullName;
	@Column(name = "tx_avatar", length = 128)
	private String avatar;

	public Usuario() {}

	public Usuario(int id, String id_usuario, String usuario, String email, String password, String rol,
			String fullName, String avatar) {
		super();
		this.id = id;
		this.id_usuario = id_usuario;
		this.usuario = usuario;
		this.email = email;
		this.password = password;
		this.rol = rol;
		this.fullName = fullName;
		this.avatar = avatar;
	}



	public int getId() {return id;}

	public void setId(int id) {this.id = id;}

	public String getId_usuario() {return id_usuario;}

	public void setId_usuario(String id_usuario) {this.id_usuario = id_usuario;}

	public String getUsuario() {return usuario;}

	public void setUsuario(String usuario) {this.usuario = usuario;}

	public String getEmail() {return email;}

	public void setEmail(String email) {	this.email = email;}

	public String getPassword() {return password;}

	public void setPassword(String password) {this.password = password;}

	public String getRol() {return rol;}

	public void setRol(String rol) {this.rol = rol;}

	public String getFullName() {return fullName;}

	public void setFullName(String fullName) {this.fullName = fullName;}

	public String getAvatar() {return avatar;}

	public void setAvatar(String avatar) {this.avatar = avatar;}
	
	

	private static final long serialVersionUID = 1L;
}
