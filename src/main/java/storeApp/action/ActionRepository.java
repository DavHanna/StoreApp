package storeApp.action;

import org.springframework.data.repository.CrudRepository;

import storeApp.action.Action;

public interface ActionRepository extends CrudRepository<Action, Integer> {
	
}
