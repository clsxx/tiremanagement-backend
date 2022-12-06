package com.adesso.tireManagement.repository;

import com.adesso.tireManagement.model.Account;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends CrudRepository<Account, Long> {
    Account findTop1ByUsername(String username);
}
