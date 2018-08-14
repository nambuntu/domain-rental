package de.vermietet.domainnam.domain.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.ZonedDateTime;
import java.util.List;

@Entity
@Table(name = "tenant")
@TableGenerator(name = "generator", initialValue = 1, allocationSize = 50)
public class Tenant {
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "generator")
	private Long id;

	@OneToOne(fetch = FetchType.LAZY, optional = false, cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id", nullable = false)
	@NotNull(message = "Tenant must be associated with an already existed user")
	private User user;

	@Column(nullable = false)
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
	@NotNull(message = "Must provide tenant signed up date")
	private ZonedDateTime signupDate;

	@Column(nullable = false)
	@NotNull(message = "Tenant must specify monthly income in EUR")
	private Double income;

	@Column(nullable = false)
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
	private ZonedDateTime dateCreated = ZonedDateTime.now();

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "tenant_contract",
			joinColumns = @JoinColumn(name = "tenant_id", referencedColumnName = "id"),
			inverseJoinColumns = @JoinColumn(name = "contract_id", referencedColumnName = "id"))
	private List<Contract> contracts;

	public Tenant() {
	}

	public Tenant(User user, ZonedDateTime signupDate) {
		this.user = user;
		this.signupDate = signupDate;
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

	public ZonedDateTime getSignupDate() {
		return signupDate;
	}

	public void setSignupDate(ZonedDateTime signupDate) {
		this.signupDate = signupDate;
	}

	public Double getIncome() {
		return income;
	}

	public void setIncome(Double income) {
		this.income = income;
	}

	public ZonedDateTime getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(ZonedDateTime dateCreated) {
		this.dateCreated = dateCreated;
	}

	public List<Contract> getContracts() {
		return contracts;
	}

	public void setContracts(List<Contract> contracts) {
		this.contracts = contracts;
	}
}
