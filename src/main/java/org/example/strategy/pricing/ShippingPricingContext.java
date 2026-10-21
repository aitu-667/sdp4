package org.example.strategy.pricing;

public class ShippingPricingContext {
    private ShippingPricingStrategy strategy;

    public ShippingPricingContext(ShippingPricingStrategy initialStrategy) {
        this.strategy = initialStrategy;
    }

    public void setStrategy(ShippingPricingStrategy strategy) {
        this.strategy = strategy;
    }

    public double executeCalculation(double weight, double distance) {
        return strategy.calculatePrice(weight, distance);
    }
}