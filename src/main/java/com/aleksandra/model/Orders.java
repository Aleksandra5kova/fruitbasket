package com.aleksandra.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "orders")
public class Orders {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "order_id")
	private Long id;

	@Column(name = "order_order_no")
	private String orderNo;

	@Temporal(TemporalType.DATE)
	@Column(name = "order_issue_date")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date issueDate;

	@Temporal(TemporalType.DATE)
	@Column(name = "order_payment_date")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date paymentDate;

	@Column(name = "order_has_delivey")
	private Integer hasDelivey;

	@Column(name = "order_delivery_date")
	@Temporal(TemporalType.DATE)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date deliveryDate;
	
	@Column(name = "order_delivery_time")
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm")
	private Date deliveryTime;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	
	@ManyToOne
	@JoinColumn(name = "supplier_id")
	private Supplier supplier;
	
	public Orders() {

	}

	public Orders(String orderNo, Date issueDate, Date paymentDate, Integer hasDelivey, Date deliveryDate,
			Date deliveryTime) {
		super();
		this.orderNo = orderNo;
		this.issueDate = issueDate;
		this.paymentDate = paymentDate;
		this.hasDelivey = hasDelivey;
		this.deliveryDate = deliveryDate;
		this.deliveryTime = deliveryTime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public Date getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(Date issueDate) {
		this.issueDate = issueDate;
	}

	public Date getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}

	public Integer getHasDelivey() {
		return hasDelivey;
	}
	
	public void setHasDelivey(Integer hasDelivey) {
		this.hasDelivey = hasDelivey;
	}

	public Date getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}
	
	public Date getDeliveryTime() {
		return deliveryTime;
	}
	
	public void setDeliveryTime(Date deliveryTime) {
		this.deliveryTime = deliveryTime;
	}

	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}

	public Supplier getSupplier() {
		return supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}

	@Override
	public String toString() {
		return "Orders [id=" + id + ", orderNo=" + orderNo + ", issueDate=" + issueDate + ", paymentDate=" + paymentDate
				+ ", hasDelivey=" + hasDelivey + ", deliveryDate=" + deliveryDate + ", deliveryTime=" + deliveryTime
				+ "]";
	}

}
