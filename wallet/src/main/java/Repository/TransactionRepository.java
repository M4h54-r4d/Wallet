package Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import Entitiy.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}