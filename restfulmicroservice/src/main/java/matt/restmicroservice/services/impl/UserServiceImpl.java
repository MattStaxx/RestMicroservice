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

	@Override
	public List<AppUserDTO> getAllUsers() {
		List<AppUser> u = (List<AppUser>) uRepo.findAll();
		log.info("Service...entity....." + u);
		List<AppUserDTO> users = u.stream().map(tmp -> 
								new AppUserDTO(
								tmp.getId(), tmp.getEmail(), tmp.getName()))
								.collect(Collectors.toList());

		log.info("Service...dto....." + users);
		return users;
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
