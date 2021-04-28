package matt.restmicroservice.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.management.AttributeNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import matt.restmicroservice.entities.AppUser;
import matt.restmicroservice.modals.AppUserDTO;
import matt.restmicroservice.repositories.UserRepository;
import matt.restmicroservice.services.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository uRepo;

	Logger log = LoggerFactory.getLogger(UserService.class);
	
	public UserServiceImpl(UserRepository uRepo) {
		super();
		this.uRepo = uRepo;
	}

//	@Override
	public List<AppUserDTO> getAllUsers() {
		return ((List<AppUser>) uRepo
				.findAll())
				.stream()
				.map(this::convertToAppUserDTO)
				.collect(Collectors.toList());
				
	}
	
	private AppUserDTO convertToAppUserDTO(AppUser user) {
		AppUserDTO appUserDTO = new AppUserDTO();
		appUserDTO.setId(user.getId());
		appUserDTO.setEmail(user.getEmail());
		appUserDTO.setName(user.getName());
		return appUserDTO;
	}
	
	@Override
	public AppUserDTO getUserByName(String name) throws AttributeNotFoundException {
		
		
		AppUserDTO user = new AppUserDTO();
		log.info("Service....name...." + name);
		AppUser convert = uRepo.findByName(name);
		user.setId(convert.getId());
		user.setEmail(convert.getEmail());
		user.setName(convert.getName());
		log.info("Service....user...." + user);
//		user.setId(u.getId(uRepo.findById(id)));
		if(convert == null) {
			throw new AttributeNotFoundException();
		} else {
			return user;
		}
	}

	@Override
	public AppUserDTO addNewUser(AppUser user) {
		// TODO Auto-generated method stub
		return null;
	}
	
//	public AppUserDTO addNewUser(AppUser newUser) {
//		return uRepo.save(newUser);
//	}
}
