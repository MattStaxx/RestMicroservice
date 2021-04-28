package matt.RestMicroservice.controllers;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import matt.restmicroservice.entities.AppUser;
import matt.restmicroservice.modals.AppUserDTO;
import matt.restmicroservice.services.UserService;


//@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private ModelMapper modelMapper;
	private UserService uServ;
	public UserController(UserService uServ) {
		super();
		this.uServ = uServ;
	}
	
	Logger log = LoggerFactory.getLogger(UserController.class);
	
	@GetMapping
	public List<AppUserDTO> getAllUsers() {
		return uServ.getAllUsers().stream().map(user -> modelMapper.map(user, AppUserDTO.class))
				.collect(Collectors.toList());
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<AppUserDTO> getUserById(@RequestParam Integer id) throws Exception {
		AppUser user = uServ.getUserById(id);
		AppUserDTO postResponse = modelMapper.map(user, AppUserDTO.class);
		return ResponseEntity.ok().body(postResponse);
	}
	
	@PostMapping(value="/")
	public AppUser addNewUser(AppUser newUser) {
	
		return uServ.addNewUser(newUser);		
	}
}
