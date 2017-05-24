package api.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import api.model.UserDetails;

/**
 * Repositorio CRUD da entidade UserDetail
 * @author juccelino.barros
 *
 */
@Repository
public interface UserDetailsRepository extends CrudRepository<UserDetails, Integer>{
	
}
