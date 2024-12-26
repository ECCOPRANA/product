package com.sathya.springbootmvc.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.sathya.springbootmvc.entity.ProductEntity;
import com.sathya.springbootmvc.model.ProductModel;
import com.sathya.springbootmvc.repository.productrepository;

import lombok.Locked.Read;



@Service
public class ProductService {
	
@Autowired
productrepository productrepository;



public void saveProductDetails(ProductModel productModel) 
{
	double discountprice;
	discountprice=productModel.getPrice()*productModel.getDiscountrate()/100;
	double offerprice;
	offerprice=productModel.getPrice()-discountprice;
	double taxprice;
	taxprice=offerprice*18/100;
	double finalprice;
	finalprice=offerprice+taxprice;
	double stockprice;
	stockprice=finalprice*productModel.getQuantity();
	ProductEntity productEntity=new ProductEntity();
	productEntity.setName(productModel.getName());
	productEntity.setBrand(productModel.getBrand());
	productEntity.setMadein(productModel.getMadein());
	productEntity.setPrice(productModel.getPrice());
	productEntity.setQuantity(productModel.getQuantity());
	productEntity.setDiscountrate(productModel.getDiscountrate());
	productEntity.setDiscountprice(discountprice);
	productEntity.setOfferprice(offerprice);
	productEntity.setTaxprice(taxprice);
	productEntity.setFinalprice(finalprice);
	productEntity.setStockprice(stockprice);
	productrepository.save(productEntity);
	
	
}
public List<ProductEntity> getAllProducts()
{
	List <ProductEntity> products =productrepository.findAll();
	return products;
}
public ProductEntity searchProductEntityById(Long id) {
	Optional<ProductEntity> optionalDate = productrepository.findById(id);
	if(optionalDate.isPresent())
	{
		ProductEntity product = optionalDate.get();
		return product;
	}
	else {
		return null;
	}
	
}



public void deleteProductById(Long  id) {
   productrepository.deleteById(id);
}

public ProductModel editProductById( Long id) {
	Optional<ProductEntity> optionalData=productrepository.findById(id);
	if(optionalData.isPresent()) {
		ProductEntity productEntity=optionalData.get();
		ProductModel productModel=new ProductModel();
		productModel.setName(productEntity.getName());
		productModel.setBrand(productEntity.getBrand());
		productModel.setMadein(productEntity.getMadein());
		productModel.setPrice(productEntity.getPrice());
		productModel.setQuantity(productEntity.getQuantity());
		productModel.setDiscountrate(productEntity.getDiscountrate());
		return productModel;
	}
	else {
		return null;
	}
}
public void updateProductById(Long id,ProductModel productModel) {
	Optional<ProductEntity> optionalData=productrepository.findById(id);
	if(optionalData.isPresent())
	{
		ProductEntity entity=optionalData.get();
		entity.setName(productModel.getName());
		entity.setBrand(productModel.getBrand());
		entity.setMadein(productModel.getMadein());
		entity.setPrice(productModel.getPrice());
		entity.setQuantity(productModel.getQuantity());
		entity.setDiscountrate(productModel.getDiscountrate());
		double discountPrice;
		discountPrice=productModel.getPrice()*productModel.getDiscountrate()/100;
		double offerPrice;
		offerPrice=productModel.getPrice()-discountPrice;
		double taxPrice;
		taxPrice=offerPrice*0.18;
		double finalPrice;
		finalPrice=offerPrice+taxPrice;
		double stockPrice;
		stockPrice=finalPrice*productModel.getQuantity();
		entity.setDiscountprice(discountPrice);
		entity.setOfferprice(offerPrice);
		entity.setTaxprice(taxPrice);
		entity.setFinalprice(finalPrice);
		entity.setStockprice(stockPrice);
		productrepository.save(entity);
	}
	
}
}

