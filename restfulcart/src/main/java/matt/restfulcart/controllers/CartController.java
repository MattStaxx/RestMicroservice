package matt.restfulcart.controllers;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import matt.restfulcart.modals.CartDTO;
import matt.restfulcart.services.CartService;


@RestController
@RequestMapping("/cart")
public class CartController {

	@Autowired
	private ModelMapper modelMapper;
	private CartService cServ;
	public CartController(CartService cServ) {
		super();
		this.cServ = cServ;
	}
	
	Logger log = LoggerFactory.getLogger(CartController.class);
	
	@GetMapping(value="/viewcart")
	public ResponseEntity<CartDTO> viewCart() {
		CartDTO cartResponse = cServ.getCart();
		return ResponseEntity.ok().body(cartResponse);
	}
}
