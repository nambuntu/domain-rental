package de.vermietet.domainnam.domain.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.ZonedDateTime;
import java.util.List;

@Entity
@Table(name = "contract")
@TableGenerator(name = "generator", initialValue = 1, allocationSize = 50)
public class Contract {
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "generator")
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "landlord_id")
	@NotNull(message = "Landlord cannot be null")
	private Landlord landlord;

	@Column(nullable = false)
	@NotNull(message = "Contract type cannot be null")
	private String contractType;

	@Column(nullable = false)
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
	@NotNull(message = "Date started cannot be null")
	private ZonedDateTime dateStarted;

	@Column(nullable = true)
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
	private ZonedDateTime dateEnded;

	@Column(nullable = false)
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
	private ZonedDateTime dateCreated = ZonedDateTime.now();

	@OneToMany(mappedBy = "contract")
	private List<ContractDetail> contractDetails;

	@ManyToMany(mappedBy = "contracts")
	private List<Tenant> tenants;

	public Contract() {
	}

	public Contract(Landlord landlord, String contractType, ZonedDateTime dateStarted, ZonedDateTime dateEnded, List<ContractDetail> contractDetails, List<Tenant> tenants) {
		this.landlord = landlord;
		this.contractType = contractType;
		this.dateStarted = dateStarted;
		this.dateEnded = dateEnded;
		this.contractDetails = contractDetails;
		this.tenants = tenants;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Landlord getLandlord() {
		return landlord;
	}

	public void setLandlord(Landlord landlord) {
		this.landlord = landlord;
	}

	public String getContractType() {
		return contractType;
	}

	public void setContractType(String contractType) {
		this.contractType = contractType;
	}

	public ZonedDateTime getDateStarted() {
		return dateStarted;
	}

	public void setDateStarted(ZonedDateTime dateStarted) {
		this.dateStarted = dateStarted;
	}

	public ZonedDateTime getDateEnded() {
		return dateEnded;
	}

	public void setDateEnded(ZonedDateTime dateEnded) {
		this.dateEnded = dateEnded;
	}

	public ZonedDateTime getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(ZonedDateTime dateCreated) {
		this.dateCreated = dateCreated;
	}

	public List<ContractDetail> getContractDetails() {
		return contractDetails;
	}

	public void setContractDetails(List<ContractDetail> contractDetails) {
		this.contractDetails = contractDetails;
	}

	public List<Tenant> getTenants() {
		return tenants;
	}

	public void setTenants(List<Tenant> tenants) {
		this.tenants = tenants;
	}
}
