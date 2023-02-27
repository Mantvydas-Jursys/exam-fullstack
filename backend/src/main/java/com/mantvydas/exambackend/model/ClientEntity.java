package com.mantvydas.exambackend.model;

import java.time.LocalDateTime;

import com.mantvydas.exambackend.utility.ClientEnum;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;

@Entity
public class ClientEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotBlank
	private String name;
	
	@NotBlank
	private String surname;
	
	@NotBlank
	private LocalDateTime birthday; 
	
	@NotBlank
	private String phone;
	
	private ClientEnum typeOfClient = ClientEnum.REGULAR;

	
	public ClientEntity(long id, @NotBlank String name, @NotBlank String surname, @NotBlank LocalDateTime birthday,
			@NotBlank String phone, ClientEnum typeOfClient) {
		super();
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.birthday = birthday;
		this.phone = phone;
		this.typeOfClient = typeOfClient;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public LocalDateTime getBirthday() {
		return birthday;
	}

	public void setBirthday(LocalDateTime birthday) {
		this.birthday = birthday;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public ClientEnum getTypeOfClient() {
		return typeOfClient;
	}

	public void setTypeOfClient(ClientEnum typeOfClient) {
		this.typeOfClient = typeOfClient;
	}

	@Override
	public String toString() {
		return "ClientEntity [id=" + id + ", name=" + name + ", surname=" + surname + ", birthday=" + birthday
				+ ", phone=" + phone + ", typeOfClient=" + typeOfClient + "]";
	}

	
	
	
	
	
}
