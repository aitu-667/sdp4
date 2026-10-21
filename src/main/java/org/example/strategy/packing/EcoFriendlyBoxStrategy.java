package org.example.strategy.packing;

public class EcoFriendlyBoxStrategy implements BoxSelectionStrategy {
    @Override
    public String selectBox(double itemVolume, double itemWeight) {
        return "Recycled Biodegradable Box [Volume: " + (itemVolume * 1.15) + " cm³]";
    }
}