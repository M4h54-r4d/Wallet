package Service;

import java.math.BigDecimal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Entitiy.Account;
import Repository.AccountRepository;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;
    
    public Account createAccount(Account account) {
        return accountRepository.save(account);
    }

    public Account getAccount(Long id) {
        return accountRepository.findById(id).orElseThrow(() -> new RuntimeException("Account not found"));
    }

    public void deposit(Long accountId, BigDecimal amount) {
        Account account = getAccount(accountId);
        account.setBalance(account.getBalance().add(amount));
        accountRepository.save(account);
    }

    public void withdraw(Long accountId, BigDecimal amount) {
        Account account = getAccount(accountId);
        if (account.getBalance().compareTo(amount) < 0) {
            throw new RuntimeException("Insufficient balance");
        }
        if (amount.compareTo(new BigDecimal("100000")) < 0 || amount.compareTo(new BigDecimal("10000000")) > 0) {
            throw new RuntimeException("Withdrawal amount must be between 100000 and 10000000 Rials");
        }
        account.setBalance(account.getBalance().subtract(amount));
        accountRepository.save(account);
    }

}
