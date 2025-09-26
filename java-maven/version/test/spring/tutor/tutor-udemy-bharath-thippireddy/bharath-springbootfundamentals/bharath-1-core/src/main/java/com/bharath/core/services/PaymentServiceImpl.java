package com.bharath.core.services;

import com.bharath.core.dao.PaymentDAO;
import lombok.Data;
import org.springframework.stereotype.Service;

@Service
@Data
public class PaymentServiceImpl implements PaymentService {

    private final PaymentDAO dao;

    public PaymentServiceImpl(PaymentDAO dao) {
        this.dao = dao;
    }

}
