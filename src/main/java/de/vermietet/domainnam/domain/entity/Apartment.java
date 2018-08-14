package de.vermietet.domainnam.domain.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "apartment")
@TableGenerator(name = "generator", initialValue = 1, allocationSize = 50)
public class Apartment {
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "generator")
	private Long id;

	@Column(nullable = false)
	@NotNull(message = "Name cannot be null")
	private String name;

	@Column(nullable = false)
	@NotNull(message = "Floor cannot be null")
	private Integer floor;

	@Column(nullable = false)
	@NotNull(message = "Square meter cannot be null")
	private Double squareMeter;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "building_id", nullable = false)
	@NotNull(message = "Apartment must be long to a building")
	private Building building;

	public Apartment() {
	}

	public Apartment(Building building, String name, Integer floor) {
		this.building = building;
		this.name = name;
		this.floor = floor;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getFloor() {
		return floor;
	}

	public void setFloor(Integer floor) {
		this.floor = floor;
	}

	public Double getSquareMeter() {
		return squareMeter;
	}

	public void setSquareMeter(Double squareMeter) {
		this.squareMeter = squareMeter;
	}

	public Building getBuilding() {
		return building;
	}

	public void setBuilding(Building building) {
		this.building = building;
	}
}
