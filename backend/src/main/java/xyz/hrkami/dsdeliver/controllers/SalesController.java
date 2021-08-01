package xyz.hrkami.dsdeliver.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import xyz.hrkami.dsdeliver.dtos.SalesDTO;
import xyz.hrkami.dsdeliver.services.SalesService;

@RestController
@RequestMapping(value = "/sales")
public class SalesController {

	@Autowired
	private SalesService salesService;

	@GetMapping
	public ResponseEntity<Page<SalesDTO>> findAll(Pageable pageable) {
		Page<SalesDTO> list = salesService.findAll(pageable);
		return ResponseEntity.ok().body(list);
	}

}
