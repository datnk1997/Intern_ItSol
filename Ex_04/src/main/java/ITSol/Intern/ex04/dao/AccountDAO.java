package ITSol.Intern.ex04.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ITSol.Intern.ex04.model.Account;

@Repository
public interface AccountDAO extends JpaRepository<Account, String>{

}
