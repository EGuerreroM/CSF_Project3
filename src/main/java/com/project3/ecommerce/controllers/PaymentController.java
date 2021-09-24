package com.project3.ecommerce.controllers;

import com.project3.ecommerce.models.PaymentType;
import com.project3.ecommerce.services.implementations.PaymentTypeServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/payment")
public class PaymentController {
    private PaymentTypeServiceImpl paymentTypeService;

    public PaymentController(PaymentTypeServiceImpl paymentTypeService) {
        super();
        this.paymentTypeService = paymentTypeService;
    }

    @GetMapping("/show")
    public List<PaymentType> showAllPayments(){
        return paymentTypeService.getAllPaymentTypes();
    }

    @PostMapping("/save")
    @ResponseBody
    public PaymentType savePayment(@ModelAttribute PaymentType paymentType){
        return paymentTypeService.savePaymentType(paymentType);
    }

    @PutMapping("/update/{id}")
    public PaymentType updateCategory(
            @PathVariable(value = "id") Long paymentId,
            @ModelAttribute PaymentType paymentType
    ){
        PaymentType foundPayment = paymentTypeService.getPaymentTypeById(paymentId);
        foundPayment.setType(paymentType.getType());

        return paymentTypeService.savePaymentType(foundPayment);
    }
}
