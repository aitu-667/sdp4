package org.example.strategy.packing;

public class MinimalBoxStrategy implements BoxSelectionStrategy {
    @Override
    public String selectBox(double itemVolume, double itemWeight) {
        return "Compact Fit Box [Volume: " + (itemVolume * 1.05) + " cm³]";
    }
}