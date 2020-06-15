package com.soft1851.smart.campus.repository.errendsrepository;


import com.soft1851.smart.campus.model.entity.errendsentity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author wl
 * @ClassNameTransactionRepository
 * @Description TODO
 * @Date 2020/6/9
 * @Version 1.0
 */
public interface TransactionRepository extends JpaRepository<Transaction,Long> {
}
