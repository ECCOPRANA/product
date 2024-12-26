package com.sathya.springbootmvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.http.client.ClientHttpRequestFactorySettings.Redirects;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sathya.springbootmvc.entity.ProductEntity;
import com.sathya.springbootmvc.model.ProductModel;
import com.sathya.springbootmvc.service.ProductService;

@Controller
public class ProductController {

	@Autowired
	ProductService  productService;
	
@GetMapping("/productform")
public String productform()
{
	return "productform";
}
@PostMapping("/saveproduct")
public String saveProductDetails(ProductModel productModel)
{
	productService.saveProductDetails(productModel);
	return "success";
}

	@GetMapping("/Productlist")
	public String getAllproducts(Model model)
{
	List<ProductEntity> product= productService.getAllProducts();
    model.addAttribute("products", product);
	return "productlist";
}
@GetMapping("/searchform")

	public String searchform()
	{
		return "searchproduct";
	}
@PostMapping("/searchbyid")
public String searchproductById(@RequestParam Long id,Model model)
{
	ProductEntity products= productService.searchProductEntityById(id);
	model.addAttribute("product", products);
	return "searchproduct";
}
@GetMapping("/delete/{id}")
public String deleteproductById(@PathVariable Long id)
{
	productService.deleteProductById(id);
	return "redirect:/Productlist";
}

@GetMapping("/edit/{id}")
public String editProductById(@PathVariable Long id,Model model) {
	ProductModel product=productService.editProductById(id);
	model.addAttribute("product",product);
	model.addAttribute("id", id);
	return "editform";
}
@PostMapping("/editproductsave/{id}")
public String updateProductById(@PathVariable Long id,ProductModel productModel ) {
	productService.updateProductById(id,productModel);
	return "redirect:/Productlist";
}
}
