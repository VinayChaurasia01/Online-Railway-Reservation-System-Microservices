package com.railway.paymentgatewayservice.repo;

import com.railway.paymentgatewayservice.model.Payment;
import com.railway.paymentgatewayservice.model.PaymentRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends JpaRepository<PaymentRecord,String> {

}
