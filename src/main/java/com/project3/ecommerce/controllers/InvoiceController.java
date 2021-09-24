package com.project3.ecommerce.controllers;

import com.project3.ecommerce.models.Category;
import com.project3.ecommerce.models.Guest;
import com.project3.ecommerce.models.Invoice;
import com.project3.ecommerce.models.PaymentType;
import com.project3.ecommerce.services.implementations.GuestServiceImpl;
import com.project3.ecommerce.services.implementations.InvoiceServiceImpl;
import com.project3.ecommerce.services.implementations.PaymentTypeServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/invoice")
public class InvoiceController {

    private InvoiceServiceImpl invoiceServiceImpl;
    private GuestServiceImpl guestServiceImpl;
    private PaymentTypeServiceImpl paymentTypeServiceImpl;
    private Date date = new Date();

    public InvoiceController(InvoiceServiceImpl invoiceServiceImpl, GuestServiceImpl guestServiceImpl, PaymentTypeServiceImpl paymentTypeServiceImpl) {
        super();
        this.invoiceServiceImpl = invoiceServiceImpl;
        this.guestServiceImpl = guestServiceImpl;
        this.paymentTypeServiceImpl = paymentTypeServiceImpl;
    }

    @GetMapping("/show")
    public List<Invoice> showAllInvoices(){
        return invoiceServiceImpl.getAllInvoices();
    }

    @GetMapping("/save")
    public void saveInvoice(){
        Guest guest = new Guest();
        guest.setName("Joey");
        guest.setAddress("Des moines");
        guest.setEmail("joey@gmail.com");

        PaymentType paymentType = paymentTypeServiceImpl.getPaymentTypeById(1L);

        Invoice invoice = new Invoice();
        invoice.setDate(this.date);
        invoice.setStatus("Not delivered");
        invoice.setTotalOrder(125.50);
        invoice.setGuest(guest);
        invoice.setPaymentType(paymentType);

        invoiceServiceImpl.saveInvoice(invoice);
    }
}
