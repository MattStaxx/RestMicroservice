package matt.restmicroservice.services.impl;

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
	
	private AppUser convertToAppUser(AppUserDTO appUserDTO) {
		AppUser appUser = new AppUser();
		appUser.setEmail(appUserDTO.getEmail());
		appUser.setName(appUserDTO.getName());
		log.info("Service...converter...." + appUserDTO);
		return appUser;
	}
	
	@Override
	public AppUserDTO getUserByName(String name) throws AttributeNotFoundException {
		AppUser convert = uRepo.findByName(name);
		AppUserDTO user = convertToAppUserDTO(convert);
		log.info("Service....name...." + name);
		if(convert == null) {
			throw new AttributeNotFoundException();
		} else {
			log.info("Service....user...." + user);
			return user;
		}
	}
	
	public AppUserDTO addNewUser(AppUserDTO user) {
		AppUser newUser = convertToAppUser(user);
		log.info("Service...add new...." + user);
		uRepo.save(newUser);
		return user;
	}
}
