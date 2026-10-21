package org.example.strategy.external;

public class SimulatedFuelPriceProvider implements FuelPriceProvider {
    @Override
    public double getFuelSurchargePerKm() {
        return 0.25; // Simulated dynamic surcharge
    }
}