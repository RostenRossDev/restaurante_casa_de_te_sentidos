package com.sentidos.api.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sentidos.api.dto.MenuDto;
import com.sentidos.api.dto.OrderDesktop;
import com.sentidos.api.dto.OrderDesktopDto;
import com.sentidos.api.dto.OrderDetailDesktopDto;
import com.sentidos.api.dto.OrderDto;
import com.sentidos.api.enitiesWrapper.OrderWrapper;
import com.sentidos.api.entities.Customer;
import com.sentidos.api.entities.Menu;
import com.sentidos.api.entities.Order;
import com.sentidos.api.entities.OrderDetail;
import com.sentidos.api.entities.User;
import com.sentidos.api.services.CostumerServiceImpl;
import com.sentidos.api.services.ICustomerService;
import com.sentidos.api.services.MenuService;
import com.sentidos.api.services.OrderServiceImpl;
import com.sentidos.api.services.UserService;

@RequestMapping("/api/v1/order/")
@RestController
public class OrderController {
	private Logger log = LoggerFactory.getLogger(OrderController.class);
	@Autowired
	private OrderServiceImpl orderService;
	@Autowired
	private UserService userService;
	
	@Autowired
	private CostumerServiceImpl customerServiceImpl;
	
	@Autowired
	private MenuService menuService;
	
	@Secured({"ROLE_ADMIN"})
	@GetMapping("")
	public ResponseEntity<Map<String, Object>> findAll(){
		Map<String, Object> response = new HashMap<String, Object>();		
		List<Order> orders = orderService.findAll();
		List<OrderDto> ordersDto = new ArrayList<OrderDto>();
		
		orders.forEach(item->{
				log.info("ordenes details: "+item.getOrderDetails().size());
				item.getOrderDetails().forEach(d -> log.info(d.getMenu().getName()));
				ordersDto.add(OrderWrapper.entityToDto(item));
		});		
		
		response.put("orders", ordersDto);
		return new ResponseEntity<Map<String,Object>>(response, HttpStatus.OK);
	}
	
	@Secured({"ROLE_ADMIN"})
	@PostMapping("")
	public ResponseEntity<Map<String, Object>> save(@RequestBody OrderDto orderDto){
		Map<String, Object> response = new HashMap<String, Object>();		
		Order newOrder = OrderWrapper.dtoToEntity(orderDto);
		newOrder = orderService.save(newOrder);
		if(newOrder != null) {
			return new ResponseEntity<Map<String,Object>>(response, HttpStatus.OK);
		}
		return new ResponseEntity<Map<String,Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@PostMapping("desktop")
	public ResponseEntity<Map<String, Object>> nuevaDesktop(@RequestBody OrderDesktop order){
		Map<String, Object> response = new HashMap<String, Object>();		
		log.info("iniciamos : "+order.toString());
		User user = userService.findByUsername(order.getUsername());
		log.info("user : "+user.toString());

		if(user == null) {
			log.info("es nulo el usuario");

			response.put("msg", "No existe el usuario.");
			return new ResponseEntity<Map<String,Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		log.info("antes del customer");

		Customer customer = customerServiceImpl.findByUser(user);
		log.info("despues del customer");

		Order newOrder = new Order();
		newOrder.setCustomer(customer);
		newOrder.setIsDelivered(order.getIsDelivered());
		newOrder.setState(order.getEstado());
		log.info("antes del arreglo");

		List<OrderDetail> orderDetails = new ArrayList<OrderDetail>();
		log.info("antes del foreach");

		order.getOrden().forEach(i ->{
			i.forEach((String key, Integer value)->{
				log.info("dentro del foreach");

				log.info("Key: "+key+", value: "+value);
				Menu newMenu = menuService.findMenuByName(key);
				OrderDetail oDetail = new OrderDetail();
				oDetail.setMenu(newMenu);
				oDetail.setQuantity(value);
				orderDetails.add(oDetail);
			});
		});
		/*order.getOrden().forEach( (String key, Integer value)->{
			log.info("dentro del foreach");

			log.info("Key: "+key+", value: "+value);
			Menu newMenu = menuService.findMenuByName(key);
			OrderDetail oDetail = new OrderDetail();
			oDetail.setMenu(newMenu);
			oDetail.setQuantity(value);
			orderDetails.add(oDetail);
		});*/
		newOrder.setOrderDetails(orderDetails);
		log.info("newOrder: "+newOrder.toString());
		newOrder = orderService.save(newOrder);
		log.info("newOrder despues de guardar: "+newOrder.toString());

		if(newOrder.getId() != null) {
			List<Order> orders = orderService.findAll();
			List<OrderDesktopDto> ordedrsDesktopDto = new ArrayList<>();
			orders.forEach(o ->{
				
				OrderDesktopDto dto = new OrderDesktopDto();
				dto.setId(o.getId());
				dto.setIsDelivered(o.getIsDelivered());
				dto.setState(o.getState());
				dto.setUsername(o.getCustomer().getUser().getUsername());
				o.getOrderDetails().forEach(od->{
					OrderDetailDesktopDto odDetail =new  OrderDetailDesktopDto();
					odDetail.setName(od.getMenu().getName());
					odDetail.setMenuType(od.getMenu().getMenuType().getType());
					odDetail.setPrice(od.getMenu().getPrice());
					odDetail.setQuantity(od.getQuantity());
					dto.getOrderDetails().add(odDetail);
				});
				ordedrsDesktopDto.add(dto);
			});
			response.put("orders", ordedrsDesktopDto);
			log.info("correcto");
			return new ResponseEntity<Map<String,Object>>(response, HttpStatus.OK);
		}
		response.put("msg", "Ocurrio un problema. Intente nuevamente.");
		log.info("incorrecto");
		return new ResponseEntity<Map<String,Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@GetMapping("desktop/all")
	public ResponseEntity<HashMap<String, Object>> allDesktop(){
		HashMap<String, Object> response = new HashMap<>();
		List<Order> orders = orderService.findAll();
		List<OrderDesktopDto> ordedrsDesktopDto = new ArrayList<>();
		orders.forEach(o ->{
			
			OrderDesktopDto dto = new OrderDesktopDto();
			dto.setId(o.getId());
			dto.setIsDelivered(o.getIsDelivered());
			dto.setState(o.getState());
			dto.setUsername(o.getCustomer().getUser().getUsername());
			o.getOrderDetails().forEach(od->{
				OrderDetailDesktopDto odDetail =new  OrderDetailDesktopDto();
				odDetail.setName(od.getMenu().getName());
				odDetail.setMenuType(od.getMenu().getMenuType().getType());
				odDetail.setPrice(od.getMenu().getPrice());
				odDetail.setQuantity(od.getQuantity());
				dto.getOrderDetails().add(odDetail);
			});
			ordedrsDesktopDto.add(dto);
		});
		log.info(ordedrsDesktopDto.toString());
		response.put("orders", ordedrsDesktopDto);
		return new ResponseEntity<HashMap<String, Object>>(response, HttpStatus.OK);
	}
}
