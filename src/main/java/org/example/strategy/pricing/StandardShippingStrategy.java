package org.example.strategy.pricing;

public class StandardShippingStrategy implements ShippingPricingStrategy {
    @Override
    public double calculatePrice(double weight, double distance) {
        return Math.max(5.0, distance * 1.2 + weight * 0.5);
    }
}