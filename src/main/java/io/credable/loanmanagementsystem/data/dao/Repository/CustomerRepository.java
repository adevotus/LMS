package io.credable.loanmanagementsystem.data.dao.Repository;

import io.credable.loanmanagementsystem.data.vo.CustomerModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CustomerRepository extends JpaRepository<CustomerModel, String> {
    CustomerModel findByCustomerNumber(String CustomerNumber);
}
