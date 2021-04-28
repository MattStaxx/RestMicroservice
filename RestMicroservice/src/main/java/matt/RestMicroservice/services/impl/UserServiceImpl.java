package matt.RestMicroservice.services.impl;

import java.util.List;
import java.util.Optional;

import javax.management.AttributeNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import matt.restmicroservice.entities.AppUser;
import matt.restmicroservice.repositrories.UserRepository;
import matt.restmicroservice.services.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository uRepo;
	
	public UserServiceImpl(UserRepository uRepo) {
		super();
		this.uRepo = uRepo;
	}

	@Override
	public AppUser getUserById(Integer id) throws AttributeNotFoundException {
		Optional<AppUser> result = uRepo.findById(id);
		if(result.isPresent()) {
			return result.get();
		} else {
			throw new AttributeNotFoundException();
		}
	}
	
	public AppUser addNewUser(AppUser newUser) {
		return uRepo.save(newUser);
	}

	@Override
	public List<AppUser> getAllUsers() {
		// TODO Auto-generated method stub
		return (List<AppUser>) uRepo.findAll();
	}
}
