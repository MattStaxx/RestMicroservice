package matt.RestMicroservice.services;

import java.util.List;

import matt.restmicroservice.entities.AppUser;

public interface UserService {

	AppUser getUserById(Integer id) throws Exception;
	
	AppUser addNewUser(AppUser user);
	List<AppUser> getAllUsers();
}
