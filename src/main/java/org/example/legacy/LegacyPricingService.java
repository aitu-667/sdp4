package org.example.legacy;

public class LegacyPricingService {
    public double calculatePrice(String shippingType, double weight, double distance) {
        if ("STANDARD".equalsIgnoreCase(shippingType)) {
            return distance * 1.5 + weight * 0.5;
        } else if ("EXPRESS".equalsIgnoreCase(shippingType)) {
            return (distance * 1.5 + weight * 0.5) * 1.8 + 15.0; // Express surge + flat fee
        } else if ("BULK".equalsIgnoreCase(shippingType)) {
            double base = distance * 1.2 + weight * 0.3;
            return weight > 50 ? base * 0.8 : base; // 20% discount if heavy
        } else {
            throw new IllegalArgumentException("Unknown shipping type: " + shippingType);
        }
    }
}