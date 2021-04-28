package matt.restmicroservice.services;

import java.util.List;

import javax.management.AttributeNotFoundException;

import matt.restmicroservice.modals.AppUserDTO;


public interface UserService {

//	AppUserDTO getUserById(Integer id) throws Exception;

	AppUserDTO getUserByName(String name) throws AttributeNotFoundException;
	AppUserDTO addNewUser(AppUserDTO newUser);
	List<AppUserDTO> getAllUsers();
}
