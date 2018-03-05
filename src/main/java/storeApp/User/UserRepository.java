package storeApp.User;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

public interface UserRepository extends CrudRepository<User, Integer>, Repository<User, Integer> {

	public User findByUsername(String username);
}
