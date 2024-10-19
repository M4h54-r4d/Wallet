package Dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TransactionDTO {
    private Long transactionId;        // شناسه تراکنش
    private String type;               // نوع تراکنش (واریز یا برداشت)
    private BigDecimal amount;         // مبلغ تراکنش
    private LocalDateTime timestamp;   // زمان تراکنش

    // setter, getter, constructor
    public TransactionDTO(Long transactionId, String type, BigDecimal amount, LocalDateTime timestamp) {
        this.transactionId = transactionId;
        this.type = type;
        this.amount = amount;
        this.timestamp = timestamp;
    }

    public Long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}

