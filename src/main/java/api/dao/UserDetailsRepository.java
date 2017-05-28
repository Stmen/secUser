package api.dao;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import api.model.UserDetails;

/**
 * Repositorio CRUD da entidade UserDetail
 * @author juccelino.barros
 *
 */
@Repository
public interface UserDetailsRepository extends PagingAndSortingRepository<UserDetails, Integer>{
	
}
