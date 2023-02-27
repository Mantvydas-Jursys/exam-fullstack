package com.mantvydas.exambackend.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.CreatedDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name="Inventory")
public class InventoryEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@NotBlank
	private String name;

	@NotBlank
	private Double mass;

	@Min(value = 1)
	@Max(value = 40)
	private Integer sector;

	@CreatedDate
	private LocalDateTime createdDate;

	@OneToMany
	@JoinColumn(name = "Client_id")
	private List<ClientEntity> comment = new ArrayList<>();
	
	public InventoryEntity() {
		
	}
	

	public InventoryEntity(long id, @NotBlank String name, @NotBlank Double mass, @Min(1) @Max(40) Integer sector,
			LocalDateTime createdDate, List<ClientEntity> comment) {
		super();
		this.id = id;
		this.name = name;
		this.mass = mass;
		this.sector = sector;
		this.createdDate = createdDate;
		this.comment = comment;
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

	public Double getMass() {
		return mass;
	}

	public void setMass(Double mass) {
		this.mass = mass;
	}

	public Integer getSector() {
		return sector;
	}

	public void setSector(Integer sector) {
		this.sector = sector;
	}

	public LocalDateTime getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}

	public List<ClientEntity> getComment() {
		return comment;
	}

	public void setComment(List<ClientEntity> comment) {
		this.comment = comment;
	}

	@Override
	public String toString() {
		return "InventoryEntity [id=" + id + ", name=" + name + ", mass=" + mass + ", sector=" + sector
				+ ", createdDate=" + createdDate + ", comment=" + comment + "]";
	}
	
	

}
