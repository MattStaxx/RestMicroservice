package matt.RestMicroservice.repositrories;

import org.springframework.data.repository.CrudRepository;

import matt.restmicroservice.entities.AppUser;

public interface UserRepository extends CrudRepository <AppUser, Integer> {

}
