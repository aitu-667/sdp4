package org.example.strategy.selector;

import org.example.strategy.external.FuelPriceProvider;
import org.example.strategy.packing.*;
import org.example.strategy.pricing.*;

public class FulfillmentStrategySelector {
    private final FuelPriceProvider fuelPriceProvider;

    public FulfillmentStrategySelector(FuelPriceProvider fuelPriceProvider) {
        this.fuelPriceProvider = fuelPriceProvider;
    }

    public ShippingPricingStrategy selectPricingStrategy(boolean isUrgent, double weight) {
        if (isUrgent) {
            return new ExpressShippingStrategy(fuelPriceProvider);
        } else if (weight >= 40.0) {
            return new BulkShippingStrategy();
        } else {
            return new StandardShippingStrategy();
        }
    }

    public BoxSelectionStrategy selectPackingStrategy(boolean isFragile, boolean isEcoCustomer) {
        if (isFragile) {
            return new ProtectedBoxStrategy();
        } else if (isEcoCustomer) {
            return new EcoFriendlyBoxStrategy();
        } else {
            return new MinimalBoxStrategy();
        }
    }
}