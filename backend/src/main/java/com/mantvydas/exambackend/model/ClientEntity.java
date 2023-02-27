package com.mantvydas.exambackend.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name="Client")
public class ClientEntity {
	
	private static final Logger logger = LoggerFactory.getLogger(ClientEntity.class);

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	private String name;
	
	@NotBlank
	private String surname;
	
	@NotBlank
	private String birthday; 
	
	@NotBlank
	private String phone;
	
	private boolean isLoyal = false;
	
	
//	private InventoryEntity assignedInvetory;

	public ClientEntity() {
		
	}
	
	public ClientEntity(@NotBlank String name, @NotBlank String surname, @NotBlank String birthday,
			@NotBlank String phone, boolean isLoyal) {
		super();
		this.name = name;
		this.surname = surname;
		this.birthday = birthday;
		this.phone = phone;
		this.isLoyal = isLoyal;
		
		logger.info("ClientEntity created with name: " + name + " " + surname);
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

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

//	public InventoryEntity getAssignedInvetory() {
//		return assignedInvetory;
//	}
//
//	public void setAssignedInvetory(InventoryEntity assignedInvetory) {
//		this.assignedInvetory = assignedInvetory;
//	}

	public boolean isLoyal() {
		return isLoyal;
	}

	public void setLoyal(boolean isLoyal) {
		this.isLoyal = isLoyal;
	}

	@Override
	public String toString() {
		return "ClientEntity [id=" + id + ", name=" + name + ", surname=" + surname + ", birthday=" + birthday
				+ ", phone=" + phone + ", typeOfClient=" + isLoyal + "]";
	}
	
}
