package matt.restmicroservice.controllers;

import java.util.List;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import matt.restmicroservice.modals.AppUserDTO;
import matt.restmicroservice.services.UserService;


//@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/")
public class UserController {

	@Autowired
	private ModelMapper modelMapper;
	private UserService uServ;
	public UserController(UserService uServ) {
		super();
		this.uServ = uServ;
	}
	
	Logger log = LoggerFactory.getLogger(UserController.class);
	
	@GetMapping(value="/users")
	public ResponseEntity<List<AppUserDTO>> getAllUsers() {
		List<AppUserDTO> users = uServ.getAllUsers();
		log.info("Controller.....all......");
		return ResponseEntity.ok().body(users);
	}
	
	@GetMapping(value="/user{name}")
	public ResponseEntity<AppUserDTO> getUserByName(String name) throws Exception {
		log.info("Controller....one...." + name);
		AppUserDTO user = uServ.getUserByName(name);
		AppUserDTO userResponse = modelMapper.map(user, AppUserDTO.class);
		return ResponseEntity.ok().body(userResponse);
	}
	
	@PostMapping(value="/")
	public ResponseEntity<AppUserDTO> addNewUser(@RequestBody AppUserDTO newUser) {
		log.info("Controller....one...." + newUser.getName());
		AppUserDTO user = uServ.addNewUser(newUser);
		AppUserDTO userResponse = modelMapper.map(user, AppUserDTO.class);
		return ResponseEntity.ok().body(userResponse);		
	}
}
