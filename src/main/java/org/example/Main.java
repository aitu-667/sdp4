package org.example;

import org.example.strategy.external.SimulatedFuelPriceProvider;
import org.example.strategy.packing.*;
import org.example.strategy.pricing.*;
import org.example.strategy.selector.FulfillmentStrategySelector;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Assignment 5: Strategy Pattern Demo ===");

        SimulatedFuelPriceProvider fuelProvider = new SimulatedFuelPriceProvider();
        FulfillmentStrategySelector selector = new FulfillmentStrategySelector(fuelProvider);

        double weight = 45.0; // kg
        double distance = 100.0; // km

        System.out.println("\n--- 1. Manual Strategy Assignment & Runtime Switching ---");
        ShippingPricingContext pricingContext = new ShippingPricingContext(new StandardShippingStrategy());
        System.out.println("Standard Price: $" + pricingContext.executeCalculation(weight, distance));

        pricingContext.setStrategy(new ExpressShippingStrategy(fuelProvider));
        System.out.println("Express Price (Runtime Swapped): $" + pricingContext.executeCalculation(weight, distance));

        pricingContext.setStrategy(new BulkShippingStrategy());
        System.out.println("Bulk Price (Runtime Swapped): $" + pricingContext.executeCalculation(weight, distance));

        System.out.println("\n--- 2. Automatic Selection via Selector ---");
        ShippingPricingStrategy autoPricing = selector.selectPricingStrategy(true, weight);
        pricingContext.setStrategy(autoPricing);
        System.out.println("Auto Selected Pricing Result: $" + pricingContext.executeCalculation(weight, distance));

        BoxSelectionStrategy autoPacking = selector.selectPackingStrategy(true, false);
        PackingContext packingContext = new PackingContext(autoPacking);
        System.out.println("Auto Selected Packing Result: " + packingContext.executePacking(200.0, weight));
    }
}