package edu.cafeteria.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import edu.cafeteria.DTO.OrderDTO; 
import edu.cafeteria.model.Order; 

@Component
public class OrderConverter {

	
	
	 public OrderDTO convertToDTO(Order order) {
	        return new OrderDTO(order.getId(), order.getOrderDate(), order.getItems() 
	        		,order.getTotalPrice() , order.getUser() , order.getStatus() );
	    }

	    
	    public Order convertToEntity(OrderDTO orderDTO) {
	        return new Order(orderDTO.getId(), orderDTO.getOrderDate(), orderDTO.getItems() 
	        		,orderDTO.getTotalPrice(), orderDTO.getUser() , orderDTO.getStatus() );
	    }
	    
	    public List<OrderDTO> modelToDto(List<Order> orderList) {
			
	        List<OrderDTO> orderDtoList = new ArrayList<>();
	        for (Order order : orderList) {
	            orderDtoList.add(convertToDTO(order));
	        }
	        
	        return orderDtoList;
	        
	        
	    }  
	    
}
