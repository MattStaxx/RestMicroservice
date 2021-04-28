package matt.restmicroservice.services;

import java.util.List;

import javax.management.AttributeNotFoundException;

import matt.restmicroservice.entities.AppUser;
import matt.restmicroservice.modals.AppUserDTO;


public interface UserService {

//	AppUserDTO getUserById(Integer id) throws Exception;

	AppUserDTO getUserByName(String name) throws AttributeNotFoundException;
	AppUserDTO addNewUser(AppUser user);
	List<AppUserDTO> getAllUsers();


//	AppUser getUserById(AppUserDTO u) throws AttributeNotFoundException;
}
