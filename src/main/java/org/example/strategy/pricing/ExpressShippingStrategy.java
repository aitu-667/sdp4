package org.example.strategy.pricing;

import org.example.strategy.external.FuelPriceProvider;

public class ExpressShippingStrategy implements ShippingPricingStrategy {
    private final FuelPriceProvider fuelPriceProvider;

    public ExpressShippingStrategy(FuelPriceProvider fuelPriceProvider) {
        this.fuelPriceProvider = fuelPriceProvider;
    }

    @Override
    public double calculatePrice(double weight, double distance) {
        double fuelSurcharge = fuelPriceProvider.getFuelSurchargePerKm();
        return (distance * (1.5 + fuelSurcharge) + weight * 0.8) * 1.3 + 10.0;
    }
}