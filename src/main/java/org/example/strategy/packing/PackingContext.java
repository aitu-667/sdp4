package org.example.strategy.packing;

public class PackingContext {
    private BoxSelectionStrategy strategy;

    public PackingContext(BoxSelectionStrategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(BoxSelectionStrategy strategy) {
        this.strategy = strategy;
    }

    public String executePacking(double itemVolume, double itemWeight) {
        return strategy.selectBox(itemVolume, itemWeight);
    }
}