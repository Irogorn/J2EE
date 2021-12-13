package fr.doranco.ecommerce.entities.pojo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="orders")
public class Orders implements Serializable {

	private static final long serialVersionUID = -8888617755731491334L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotEmpty
	@Column(name="order_number")
	private String orderNumber;
	
	@NotNull
	@Column(name="order_date")
	@Temporal(TemporalType.DATE)
	private Date orderDate;
	
	@NotNull
	@Column(name="order_time")
	@Temporal(TemporalType.TIME)
	private Date orderTime;
	
	
	@Column(name="discount_price")
	private Float discountPrice;
	
	@NotNull
	@Column(name="shipping_charges")
	private Float shippingCharges;
	
	@NotNull
	@Column(name="total_price")
	private Float totalPrice;
	
	@NotNull
	@Column(name="shipment_date")
	@Temporal(TemporalType.DATE)
	private Date shipmentDate;
	
	@NotNull
	@Column(name="shipment_time")
	@Temporal(TemporalType.TIME)
	private Date shipmentTime;
	
	@NotNull
	@Column(name="credit_card_default")
	private Integer creditCardDefault;
	
	@OneToOne
	@JoinColumn(name="shipment_address_id", nullable = false)
	private Address shipmentAddress;
	
	@OneToOne
	@JoinColumn(name="billing_address_id", nullable = false)
	private Address billingAddress;
	
	@OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
	private List<OrdersLine> orderLines;
	
	@ManyToOne
	@JoinColumn(name="user_id", nullable = false)
	private User user;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List<OrdersLine> getOrderlines() {
		return orderLines;
	}

	public void setOrderlines(List<OrdersLine> orderlines) {
		this.orderLines = orderlines;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public Date getOrderTime() {
		return orderTime;
	}

	public void setOrderTime(Date orderTime) {
		this.orderTime = orderTime;
	}

	public Date getShipmentDate() {
		return shipmentDate;
	}

	public void setShipmentDate(Date shipmentDate) {
		this.shipmentDate = shipmentDate;
	}

	public Date getShipmentTime() {
		return shipmentTime;
	}

	public void setShipmentTime(Date shipmentTime) {
		this.shipmentTime = shipmentTime;
	}

	public Address getShipmentAddress() {
		return shipmentAddress;
	}

	public void setShipmentAddress(Address shipmentAddress) {
		this.shipmentAddress = shipmentAddress;
	}

	public Address getBillingAddress() {
		return billingAddress;
	}

	public void setBillingAddress(Address billingAddress) {
		this.billingAddress = billingAddress;
	}

	public Float getDiscountPrice() {
		return discountPrice;
	}

	public void setDiscountPrice(Float discountPrice) {
		this.discountPrice = discountPrice;
	}

	public Float getShippingCharges() {
		return shippingCharges;
	}

	public void setShippingCharges(Float shippingCharges) {
		this.shippingCharges = shippingCharges;
	}

	public Float getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Float totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Integer getCreditCardDefault() {
		return creditCardDefault;
	}

	public void setCreditCardDefault(Integer creditCardDefault) {
		this.creditCardDefault = creditCardDefault;
	}

	public List<OrdersLine> getOrderLines() {
		return orderLines;
	}
}
