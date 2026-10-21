package org.example.strategy.packing;

public interface BoxSelectionStrategy {
    String selectBox(double itemVolume, double itemWeight);
}