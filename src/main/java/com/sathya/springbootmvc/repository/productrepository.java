package com.sathya.springbootmvc.repository;

import org.hibernate.type.descriptor.converter.spi.JpaAttributeConverter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sathya.springbootmvc.entity.ProductEntity;



@Repository
public interface productrepository  extends JpaRepository<ProductEntity, Long>{

	

}
