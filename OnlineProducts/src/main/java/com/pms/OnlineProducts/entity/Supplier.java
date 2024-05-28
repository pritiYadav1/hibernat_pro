package com.pms.OnlineProducts.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="supplierData")
public class Supplier 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="sid",length = 20)
	private int sId;
	@Column(name="sname",length = 30)
	private String sName;
	@Column(name="scno",length = 20)
	private String sContactNo;
	@Column(name="sadd",length = 50)
	private String sAddress;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="pdata")
	private List<OnlineProduct> onlineProduct;

	public Supplier(String sName, String sContactNo, String sAddress, List<OnlineProduct> onlineProduct) {
		super();
		this.sName = sName;
		this.sContactNo = sContactNo;
		this.sAddress = sAddress;
		this.onlineProduct = onlineProduct;
	}

	public Supplier() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getsId() {
		return sId;
	}

	public void setsId(int sId) {
		this.sId = sId;
	}

	public String getsName() {
		return sName;
	}

	public void setsName(String sName) {
		this.sName = sName;
	}

	public String getsContactNo() {
		return sContactNo;
	}

	public void setsContactNo(String sContactNo) {
		this.sContactNo = sContactNo;
	}

	public String getsAddress() {
		return sAddress;
	}

	public void setsAddress(String sAddress) {
		this.sAddress = sAddress;
	}

	public List<OnlineProduct> getOnlineProduct() {
		return onlineProduct;
	}

	public void setOnlineProduct(List<OnlineProduct> onlineProduct) {
		this.onlineProduct = onlineProduct;
	}

	@Override
	public String toString() {
		return "Supplier [sId=" + sId + ", sName=" + sName + ", sContactNo=" + sContactNo + ", sAddress=" + sAddress
				+ ", onlineProduct=" + onlineProduct + "]";
	}
	
	
	
	
	
}
