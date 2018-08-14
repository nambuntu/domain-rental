package de.vermietet.domainnam.domain.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.ZonedDateTime;
import java.util.List;

@Entity
@Table(name = "building")
@TableGenerator(name = "generator", initialValue = 1, allocationSize = 50)
public class Building {
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "generator")
	private Long id;

	@Column(nullable = false)
	@NotNull(message = "Building name cannot be null")
	private String name;

	@Column(nullable = false)
	@NotNull(message = "Address cannot be null")
	private String address;

	@Column(nullable = false)
	@NotNull(message = "City cannot be null")
	private String city;

	@Column(nullable = false)
	@NotNull(message = "Zipcode cannot be null")
	private String zipcode;

	@Column(nullable = false)
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
	private ZonedDateTime dateCreated = ZonedDateTime.now();

	@OneToMany(mappedBy = "building")
	private List<Apartment> apartments;

	public Building() {
	}

	public Building(String name, String address, String city, String zipcode) {
		this.name = name;
		this.address = address;
		this.city = city;
		this.zipcode = zipcode;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public ZonedDateTime getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(ZonedDateTime dateCreated) {
		this.dateCreated = dateCreated;
	}

	public List<Apartment> getApartments() {
		return apartments;
	}

	public void setApartments(List<Apartment> apartments) {
		this.apartments = apartments;
	}
}
