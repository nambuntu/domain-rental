package de.vermietet.domainnam.domain.entity;

import de.vermietet.domainnam.domain.value.PaymentType;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "contract_detail")
@TableGenerator(name = "generator", initialValue = 1, allocationSize = 50)
public class ContractDetail {
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "generator")
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "contract_id")
	@NotNull(message = "Contract cannot be null")
	private Contract contract;

	@Column(nullable = false)
	@NotNull(message = "Property name cannot be null")
	private String propertyName;

	@Column(nullable = false)
	@NotNull(message = "Property type cannot be null")
	private String propertyType;

	@Column(nullable = false)
	@NotNull(message = "Property Id cannot be null")
	private Long propertyId;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	@NotNull(message = "Payment type cannot be null")
	private PaymentType paymentType = PaymentType.MONTHLY;

	@Column(nullable = false)
	@NotNull(message = "Payment amount cannot be null")
	private Double amount;

	@Column(nullable = false)
	@NotNull(message = "Currency cannot be null")
	private String currency;

	public ContractDetail() {
	}

	public ContractDetail(Contract contract, String propertyType, String propertyName, Long propertyId, PaymentType paymentType,
	                      Double amount, String currency) {
		this.contract = contract;
		this.propertyId = propertyId;
		this.propertyName = propertyName;
		this.propertyType = propertyType;
		this.paymentType = paymentType;
		this.amount = amount;
		this.currency = currency;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Contract getContract() {
		return contract;
	}

	public void setContract(Contract contract) {
		this.contract = contract;
	}

	public String getPropertyName() {
		return propertyName;
	}

	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}

	public String getPropertyType() {
		return propertyType;
	}

	public void setPropertyType(String propertyType) {
		this.propertyType = propertyType;
	}

	public Long getPropertyId() {
		return propertyId;
	}

	public void setPropertyId(Long propertyId) {
		this.propertyId = propertyId;
	}

	public PaymentType getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(PaymentType paymentType) {
		this.paymentType = paymentType;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}
}
