package com.sathya.springbootmvc.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductModel {

	
	private String name;
	private String brand;
	private String madein;
	private double price;
	private int quantity;
	private int discountrate;
	


}
 