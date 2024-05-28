package com.pms.OnlineProducts.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="productdetails")
public class ProductDetails 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pid",length = 20)
	private int ProductDetailsId;
	@Column(name="pdesc",length = 50)
	private String ProductDescription;
	public ProductDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ProductDetails(String productDescription) {
		super();
		ProductDescription = productDescription;
	}
	public String getProductDescription() {
		return ProductDescription;
	}
	public void setProductDescription(String productDescription) {
		ProductDescription = productDescription;
	}
	@Override
	public String toString() {
		return "ProductDetails [ProductDetailsId=" + ProductDetailsId + ", ProductDescription=" + ProductDescription
				+ "]";
	}
	
	
	
	
}
