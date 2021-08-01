package xyz.hrkami.dsdeliver.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import xyz.hrkami.dsdeliver.dtos.SellerDTO;
import xyz.hrkami.dsdeliver.entities.Seller;
import xyz.hrkami.dsdeliver.repositories.SellerRepository;

@Service
public class SellerService {

	@Autowired
	private SellerRepository sellerRepository;

	@Transactional(readOnly = true)
	public List<SellerDTO> findAll() {

		List<Seller> list = sellerRepository.findAll();
		return list.stream().map(x -> new SellerDTO(x)).collect(Collectors.toList());
	}

}
