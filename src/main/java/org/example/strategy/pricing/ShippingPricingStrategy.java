package org.example.strategy.pricing;

public interface ShippingPricingStrategy {
    double calculatePrice(double weight, double distance);
}