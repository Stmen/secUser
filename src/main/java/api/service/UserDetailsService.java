/**
 * 
 */
package api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import api.dao.UserDetailsRepository;
import api.model.UserDetails;


/**
 * Camada de servico da entidade UserDetails
 * 
 * @author juccelino.barros
 *
 */
@Component
public class UserDetailsService {
	
	@Autowired
	private UserDetailsRepository userRepository;

	/**
	 * Encontra usuário através do nome informado
	 * @param name do usuário
	 * @return {@link UserDetails} - objeto que representa o usuário
	 */
	public Iterable<UserDetails> getAll(){
		return this.userRepository.findAll();
	}
	
	/**
	 * Persiste usuario
	 * Atualiza caso o usuario ja exista no sistema
	 * @param userDetails
	 */
	public void persistUser(UserDetails user){
		this.userRepository.save(user);
	}
	
	/**
	 * Encontra usuário através do nome informado
	 * @param name do usuário
	 * @return {@link UserDetails} - objeto que representa o usuário
	 * 
	 * TO DO
	 */
//	public UserDetails findUserByName(String name){
//		return this.userRepository.find
//	}
	
	/**
	 * Encontra usuário através do ID
	 * @param name do usuário
	 * @return {@link UserDetails} - objeto que representa o usuário
	 */
	public UserDetails findByID(Integer id){
		return this.userRepository.findOne(id);
	}
	
	/**
	 * Encontra usuário através do ID
	 * @param name do usuário
	 * @return {@link UserDetails} - objeto que representa o usuário
	 */
	public void deleteUser(Integer id){
		this.userRepository.delete(id);
	}
	
}