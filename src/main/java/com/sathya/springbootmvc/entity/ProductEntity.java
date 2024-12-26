package com.sathya.springbootmvc.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ProductEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) 
	private Long id;
	private String name;
	private String brand;
	private String madein;
	private double price;
	private int quantity;
	private int discountrate;
	private double discountprice;
	private double offerprice;
	private double taxprice;
	private double finalprice;
	private double stockprice;


}
