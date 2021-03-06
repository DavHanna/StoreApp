package storeApp.brand;

import org.springframework.data.repository.CrudRepository;

public interface BrandRepository extends CrudRepository<Brand, Integer> {

	public Brand findByName(String name);
}
