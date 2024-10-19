package Dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import java.math.BigDecimal;

public class AccountDTO {

    @NotNull
    private Long id;

    @NotNull
    private String accountNumber;

    @NotNull
    @Positive
    private BigDecimal balance;

    @NotNull
    private String iban;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAccountNumber() {      
    	return accountNumber;
    }

    public void setAccountNumber( String accountNumber) {
        this.accountNumber = accountNumber;
    }

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	public String getIban() {
		return iban;
	}

	public void setIban(String iban) {
		this.iban = iban;
	}
    

}