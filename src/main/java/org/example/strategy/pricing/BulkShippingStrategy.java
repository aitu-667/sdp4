package org.example.strategy.pricing;

public class BulkShippingStrategy implements ShippingPricingStrategy {
    @Override
    public double calculatePrice(double weight, double distance) {
        double baseCost = distance * 1.0 + weight * 0.3;
        return weight >= 50.0 ? baseCost * 0.75 : baseCost;
    }
}