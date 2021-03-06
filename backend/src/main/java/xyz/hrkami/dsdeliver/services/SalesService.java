package xyz.hrkami.dsdeliver.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import xyz.hrkami.dsdeliver.dtos.SalesDTO;
import xyz.hrkami.dsdeliver.entities.Sales;
import xyz.hrkami.dsdeliver.repositories.SalesRepository;
import xyz.hrkami.dsdeliver.repositories.SellerRepository;

@Service
public class SalesService {

	@Autowired
	private SalesRepository salesRepository;

	@Autowired
	private SellerRepository sellerRepository;
	
	
	@Transactional(readOnly = true)
	public Page<SalesDTO> findAll(Pageable pageable) {
		sellerRepository.findAll();
		Page<Sales> list = salesRepository.findAll(pageable);
		return list.map(x -> new SalesDTO(x));
	}

}
