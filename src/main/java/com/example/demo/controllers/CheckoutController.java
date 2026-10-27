package com.example.demo.controllers;

import com.example.demo.services.CheckoutInterface;
import com.example.demo.services.PurchaseData;
import com.example.demo.services.PurchaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("http://localhost:4200/")
@RestController
@RequestMapping("/api/checkout")
public class CheckoutController {
    private CheckoutInterface checkoutInterface;
    @Autowired
    public CheckoutController(CheckoutInterface checkoutInterface) {
        this.checkoutInterface = checkoutInterface;
    }
    @PostMapping("/purchase")
    public PurchaseResponse placeOrder(@RequestBody PurchaseData purchaseData) {
        PurchaseResponse PurchaseResponse = checkoutInterface.placeOrder(purchaseData);
        return PurchaseResponse;
    }
}
