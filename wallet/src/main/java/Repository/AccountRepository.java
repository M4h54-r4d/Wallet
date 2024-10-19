package Repository;

import java.util.Optional;

//import org.springframework.data.repository.CrudRepository; //mr.Fattahi!
import org.springframework.data.jpa.repository.JpaRepository;

import Entitiy.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {

	Optional<Account> findByAccountNumber(String string);
}