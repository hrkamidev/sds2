package xyz.hrkami.dsdeliver.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import xyz.hrkami.dsdeliver.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{

}
