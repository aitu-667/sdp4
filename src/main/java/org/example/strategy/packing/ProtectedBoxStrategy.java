package org.example.strategy.packing;

public class ProtectedBoxStrategy implements BoxSelectionStrategy {
    @Override
    public String selectBox(double itemVolume, double itemWeight) {
        return "Heavy-Duty Reinforced Box + Bubble Wrap [Volume: " + (itemVolume * 1.35 + 50.0) + " cm³]";
    }
}