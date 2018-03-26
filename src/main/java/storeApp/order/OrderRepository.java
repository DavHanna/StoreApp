package storeApp.order;

import org.springframework.data.repository.CrudRepository;

import storeApp.order.Order;

public interface OrderRepository extends CrudRepository<Order, Integer>{
	
//	public Order findByUsername(String username);
}
