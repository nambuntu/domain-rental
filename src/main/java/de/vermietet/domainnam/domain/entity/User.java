package de.vermietet.domainnam.domain.entity;

import de.vermietet.domainnam.domain.value.ActiveStatus;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.ZonedDateTime;

@Entity
@Table(name = "user")
@TableGenerator(name = "generator", initialValue = 1, allocationSize = 50)
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "generator")
	private Long id;

	@Column(nullable = false, unique = true)
	@NotNull(message = "Email cannot be null")
	private String email;

	@Column(nullable = false, unique = true)
	@NotNull(message = "Phone cannot be null")
	private String phone;

	@Column(nullable = false)
	@NotNull(message = "First Name cannot be null")
	private String firstName;

	@Column(nullable = false)
	@NotNull(message = "Last Name cannot be null")
	private String lastName;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	@NotNull(message = "Active status cannot be null")
	private ActiveStatus activeStatus;

	@Column(nullable = false)
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
	private ZonedDateTime dateCreated = ZonedDateTime.now();

	public User() {
	}

	public User(String email, String phone, String firstName, String lastName) {
		this.email = email;
		this.phone = phone;
		this.firstName = firstName;
		this.lastName = lastName;
		this.activeStatus = ActiveStatus.ACTIVE;
	}

	/**
	 * Generate full name for a user.
	 *
	 * @return user full name
	 */
	public String getFullName() {
		return String.format("%s %s", getFirstName(), getLastName());
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public ActiveStatus getActiveStatus() {
		return activeStatus;
	}

	public void setActiveStatus(ActiveStatus activeStatus) {
		this.activeStatus = activeStatus;
	}

	public ZonedDateTime getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(ZonedDateTime dateCreated) {
		this.dateCreated = dateCreated;
	}
}
