package org.example.strategy;

import org.example.strategy.external.FuelPriceProvider;
import org.example.strategy.packing.*;
import org.example.strategy.pricing.*;
import org.example.strategy.selector.FulfillmentStrategySelector;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class StrategyTests {

    private FuelPriceProvider fakeFuelProvider;
    private FulfillmentStrategySelector selector;

    @BeforeEach;
    void setUp() {
        // Fake implementation with fixed data for isolated unit testing
        fakeFuelProvider = () -> 0.10;
        selector = new FulfillmentStrategySelector(fakeFuelProvider);
    }

    @Test
    void testStandardShippingStrategy() {
        ShippingPricingStrategy strategy = new StandardShippingStrategy();
        double price = strategy.calculatePrice(10, 50);
        assertEquals(65.0, price, 0.001);
    }

    @Test
    void testExpressShippingStrategyWithFakeData() {
        ShippingPricingStrategy strategy = new ExpressShippingStrategy(fakeFuelProvider);
        double price = strategy.calculatePrice(10, 50);
        assertTrue(price > 0);
    }

    @Test
    void testSelectorRules() {
        ShippingPricingStrategy express = selector.selectPricingStrategy(true, 10);
        assertInstanceOf(ExpressShippingStrategy.class, express);

        ShippingPricingStrategy bulk = selector.selectPricingStrategy(false, 50);
        assertInstanceOf(BulkShippingStrategy.class, bulk);

        BoxSelectionStrategy protectedBox = selector.selectPackingStrategy(true, false);
        assertInstanceOf(ProtectedBoxStrategy.class, protectedBox);
    }

    static Stream<ShippingPricingStrategy> pricingStrategiesProvider() {
        FuelPriceProvider fake = () -> 0.10;
        return Stream.of(
                new StandardShippingStrategy(),
                new ExpressShippingStrategy(fake),
                new BulkShippingStrategy()
        );
    }

    @ParameterizedTest
    @MethodSource("pricingStrategiesProvider")
    void testPriceIsNeverNegativeOrZero(ShippingPricingStrategy strategy) {
        double result = strategy.calculatePrice(5.0, 10.0);
        assertTrue(result > 0, "Calculated shipping price must always be strictly positive");
    }
}