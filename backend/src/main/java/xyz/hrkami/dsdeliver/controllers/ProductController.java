package xyz.hrkami.dsdeliver.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import xyz.hrkami.dsdeliver.dtos.ProductDTO;
import xyz.hrkami.dsdeliver.services.ProductService;

@RestController
@RequestMapping(value = "/products")
public class ProductController {

	@Autowired
	private ProductService productService;

	@GetMapping
	public ResponseEntity<List<ProductDTO>> findAll() {
		List<ProductDTO> list = productService.findAll();
		return ResponseEntity.ok().body(list);
	}

}
