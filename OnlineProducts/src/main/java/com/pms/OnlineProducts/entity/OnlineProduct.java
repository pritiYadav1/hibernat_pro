package com.pms.OnlineProducts.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="myProduct")
public class OnlineProduct 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "pid",length = 20)
	private int productId;
	@Column(name = "pname",length = 30)
	private String productName;
	@Column(name = "pbrand",length = 30)
	private String productBrand;
	@Column(name = "pcatagory",length = 30)
	private String productCatagory;
	@Column(name = "pprice",length = 30)
	private int productPrice;
	@Column(name = "pquantity",length = 30)
	private int productQuantity;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="pdetails")
	private ProductDetails details;
	
	public OnlineProduct() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OnlineProduct(String productName, String productBrand, String productCatagory, int productPrice,
			int productQuantity, ProductDetails details) {
		super();
		this.productName = productName;
		this.productBrand = productBrand;
		this.productCatagory = productCatagory;
		this.productPrice = productPrice;
		this.productQuantity = productQuantity;
		this.details = details;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductBrand() {
		return productBrand;
	}

	public void setProductBrand(String productBrand) {
		this.productBrand = productBrand;
	}

	public String getProductCatagory() {
		return productCatagory;
	}

	public void setProductCatagory(String productCatagory) {
		this.productCatagory = productCatagory;
	}

	public int getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}

	public int getProductQuantity() {
		return productQuantity;
	}

	public void setProductQuantity(int productQuantity) {
		this.productQuantity = productQuantity;
	}

	public ProductDetails getDetails() {
		return details;
	}

	public void setDetails(ProductDetails details) {
		this.details = details;
	}

	@Override
	public String toString() {
		return "OnlineProduct [productId=" + productId + ", productName=" + productName + ", productBrand="
				+ productBrand + ", productCatagory=" + productCatagory + ", productPrice=" + productPrice
				+ ", productQuantity=" + productQuantity + ", details=" + details + "]";
	}
	
	
	
	
}
