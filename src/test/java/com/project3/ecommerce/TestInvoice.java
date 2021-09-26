package com.project3.ecommerce;

import com.project3.ecommerce.models.*;
import com.project3.ecommerce.repositories.GuestRepository;
import com.project3.ecommerce.repositories.InvoiceRepository;
import com.project3.ecommerce.repositories.PaymentTypeRepository;
import com.project3.ecommerce.services.implementations.*;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.Date;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
public class TestInvoice {
    @Autowired
    private InvoiceRepository repo;

    private Date date = new Date();

    @Test
    public void testSaveInvoice() {
        Guest guest = new Guest();
        PaymentType paymentType = new PaymentType();

        guest.setName("test");
        guest.setAddress("address test");
        guest.setEmail("test2@email.com");

        paymentType.setType("Credit/Debit");

        Invoice invoice = new Invoice();
        invoice.setTotalOrder(123.1);
        invoice.setDate(this.date);
        invoice.setGuest(guest);
        invoice.setStatus("StatusTest");
        invoice.setPaymentType(paymentType);

        Invoice savedInvoice = repo.save(invoice);

        Assertions.assertThat(savedInvoice).isNotNull();
        Assertions.assertThat(savedInvoice.getId()).isGreaterThan(0);

    }


}

