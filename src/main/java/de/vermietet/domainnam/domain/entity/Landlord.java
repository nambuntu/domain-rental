package de.vermietet.domainnam.domain.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.ZonedDateTime;

@Entity
@Table(name = "landlord")
@TableGenerator(name = "generator", initialValue = 1, allocationSize = 50)
public class Landlord {
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "generator")
	private Long id;

	@OneToOne(fetch = FetchType.LAZY, optional = false, cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id", nullable = false)
	@NotNull(message = "Landlord must be associated with an already existed user")
	private User user;

	@Column(nullable = false)
	private Boolean individual;

	@Column(nullable = false)
	private String name;

	@Column(nullable = true)
	private String licenseId;

	@Column(nullable = false)
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
	@NotNull(message = "Must provide landlord signed up date")
	private ZonedDateTime signupDate;

	@Column(nullable = false)
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
	private ZonedDateTime dateCreated = ZonedDateTime.now();

	public Landlord() {
	}

	/**
	 * Constructor for individual landlord.
	 *
	 * @param user
	 * @param signupDate
	 */
	public Landlord(User user, ZonedDateTime signupDate) {
		this.user = user;
		this.signupDate = signupDate;
		this.individual = true;
		this.name = user.getFullName();
	}

	/**
	 * Constructor for organization/company landlord (must provide license ID and company name)
	 *
	 * @param user
	 * @param signupDate
	 * @param name
	 * @param licenseId
	 */
	public Landlord(User user, ZonedDateTime signupDate, String name, String licenseId) {
		this.user = user;
		this.signupDate = signupDate;
		this.individual = false;
		this.licenseId = licenseId;
		this.name = name; //Organization name;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Boolean getIndividual() {
		return individual;
	}

	public void setIndividual(Boolean individual) {
		this.individual = individual;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLicenseId() {
		return licenseId;
	}

	public void setLicenseId(String licenseId) {
		this.licenseId = licenseId;
	}

	public ZonedDateTime getSignupDate() {
		return signupDate;
	}

	public void setSignupDate(ZonedDateTime signupDate) {
		this.signupDate = signupDate;
	}

	public ZonedDateTime getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(ZonedDateTime dateCreated) {
		this.dateCreated = dateCreated;
	}
}
