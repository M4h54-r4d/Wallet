package Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.util.Optional;

import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import Entitiy.Account;
import Repository.AccountRepository;
import Service.AccountService;

@SpringBootTest
public class AccountServiceTest {

    @InjectMocks
    private AccountService accountService; 

    @Mock
    private AccountRepository accountRepository; // Mock Repository

    @Test
    public void testWithdraw_Success() {
        
        Account account = new Account();
        account.setId(1L);
        account.setBalance(new BigDecimal("500000"));

        // repository
        when(accountRepository.findById(1L)).thenReturn(Optional.of(account));


        accountService.withdraw(1L, new BigDecimal("100000"));

        assertEquals(new BigDecimal("400000"), account.getBalance());
        verify(accountRepository).save(account); 
    }

    @Test(expected = RuntimeException.class)
    public void testWithdraw_InsufficientBalance() {
        Account account = new Account();
        account.setId(1L);
        account.setBalance(new BigDecimal("50000"));

        // repository
        when(accountRepository.findById(1L)).thenReturn(Optional.of(account));

        accountService.withdraw(1L, new BigDecimal("100000"));
    }
}
