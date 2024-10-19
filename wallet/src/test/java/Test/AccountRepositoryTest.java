package Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.util.Optional;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;

import Entitiy.Account;
import Repository.AccountRepository;


@DataJpaTest
@SpringBootTest
public class AccountRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private AccountRepository accountRepository;

    @Test
    public void testFindByAccountNumber() {
        // save repository
        Account account = new Account();
        account.setAccountNumber("123456789");
        account.setBalance(new BigDecimal("500000"));
        entityManager.persist(account);

        Optional<Account> foundAccount = accountRepository.findByAccountNumber("123456789");
        assertTrue(foundAccount.isPresent());
        assertEquals("123456789", foundAccount.get().getAccountNumber());
    }
}
