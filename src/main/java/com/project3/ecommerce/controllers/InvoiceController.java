package com.project3.ecommerce.controllers;

import com.project3.ecommerce.models.*;
import com.project3.ecommerce.services.implementations.GuestServiceImpl;
import com.project3.ecommerce.services.implementations.InvoiceDetailsServiceImpl;
import com.project3.ecommerce.services.implementations.InvoiceServiceImpl;
import com.project3.ecommerce.services.implementations.PaymentTypeServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/invoice")
public class InvoiceController {

    private InvoiceServiceImpl invoiceServiceImpl;
    private InvoiceDetailsServiceImpl invoiceDetailsServiceImpl;
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

    @PostMapping("/save")
    @ResponseBody
    public void saveInvoice(){
        Guest guest = guestServiceImpl.getGuestById(1L);
        PaymentType paymentType = paymentTypeServiceImpl.getPaymentTypeById(1L);
        //InvoiceDetails invoiceDetails = invoiceDetailsServiceImpl.getInvoiceDetailsById(1L);

        Invoice invoice = new Invoice();
        invoice.setDate(this.date);
        invoice.setStatus("Not delivered");
        //invoice.setTotalOrder(invoiceDetails.getSubTotal()+(invoiceDetails.getSubTotal()*0.15));
        invoice.setTotalOrder(210.12);
        invoice.setGuest(guest);
        invoice.setPaymentType(paymentType);

        invoiceServiceImpl.saveInvoice(invoice);
    }
}
