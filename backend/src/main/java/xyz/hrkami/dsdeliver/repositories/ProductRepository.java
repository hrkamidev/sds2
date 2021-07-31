package xyz.hrkami.dsdeliver.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import xyz.hrkami.dsdeliver.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

}
