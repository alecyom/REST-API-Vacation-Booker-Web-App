package com.example.demo.services;

import com.example.demo.dao.CartRepository;
import com.example.demo.dao.CustomerRepository;
import com.example.demo.entities.Cart;
import com.example.demo.entities.CartItem;
import com.example.demo.entities.Customer;

import com.example.demo.entities.StatusType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;
import java.util.UUID;

@Service
public class CheckoutImplementation implements CheckoutInterface {
    private CartRepository cartRepository;
    private CustomerRepository customerRepository;

    @Autowired
    public CheckoutImplementation(CartRepository cartRepository, CustomerRepository customerRepository) {
        this.cartRepository = cartRepository;
        this.customerRepository = customerRepository;
    }

    @Override
    @Transactional
    public PurchaseResponse placeOrder(PurchaseData purchaseData) {
        Cart cart = purchaseData.getCart();

        String orderTrackingNumber = generateOrderTrackingNumber();
        cart.setOrderTrackingNumber(orderTrackingNumber);

        Set<CartItem> cartItems = purchaseData.getCartItems();
        cartItems.forEach(item -> {
            cart.add(item);
            item.setCart(cart);
        });

        Customer customer = purchaseData.getCustomer();
        cart.setStatusType(StatusType.ordered);
        cartRepository.save(cart);
        return new PurchaseResponse(orderTrackingNumber);
    }

    private String generateOrderTrackingNumber() {
        return UUID.randomUUID().toString();
    }
}
