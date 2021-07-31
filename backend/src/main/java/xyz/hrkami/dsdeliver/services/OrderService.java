package xyz.hrkami.dsdeliver.services;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import xyz.hrkami.dsdeliver.dtos.OrderDTO;
import xyz.hrkami.dsdeliver.dtos.ProductDTO;
import xyz.hrkami.dsdeliver.entities.Order;
import xyz.hrkami.dsdeliver.entities.OrderStatus;
import xyz.hrkami.dsdeliver.entities.Product;
import xyz.hrkami.dsdeliver.repositories.OrderRepository;
import xyz.hrkami.dsdeliver.repositories.ProductRepository;

@Service
public class OrderService {

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private ProductRepository productRepository;

	@Transactional(readOnly = true)
	public List<OrderDTO> findAll() {

		List<Order> list = orderRepository.findOrdersWithProducts();
		return list.stream().map(x -> new OrderDTO(x)).collect(Collectors.toList());
	}

	@Transactional()
	public OrderDTO insert(OrderDTO dto) {
		Order order = new Order(null, dto.getAddress(), dto.getLatitude(), dto.getLongitude(), Instant.now(),
				OrderStatus.PENDING);

		for (ProductDTO p : dto.getProducts()) {
			Product product = productRepository.getById(p.getId());
			order.getProducts().add(product);
		}
		order = orderRepository.save(order);
		return new OrderDTO(order);

	}

	@Transactional()
	public OrderDTO setDelivered(Long id) {
		Order order = orderRepository.getById(id);
		order.setStatus(OrderStatus.DELIVERED);
		order = orderRepository.save(order);

		return new OrderDTO(order);

	}

}
