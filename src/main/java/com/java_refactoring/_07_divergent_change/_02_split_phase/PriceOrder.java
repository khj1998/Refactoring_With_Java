package com.java_refactoring._07_divergent_change._02_split_phase;

/**
 * refactoring smell : 메서드내 여러 문맥 중 일부를 메서드로 분리해낸다.
 * 여러 일을 하는 함수의 구문들을 각기 다른 단계로 구분한다.
 */
public class PriceOrder {

    public double priceOrder(Product product, int quantity, ShippingMethod shippingMethod) {
        PriceData priceData = calculatePriceData(product,quantity);
        final double price = applyShipping(priceData,shippingMethod);

        return price;
    }

    private PriceData calculatePriceData(Product product,int quantity) {
        final double basePrice = product.basePrice() * quantity;
        final double discount = Math.max(quantity - product.discountThreshold(), 0)
                * product.basePrice() * product.discountRate();

        return new PriceData(quantity,basePrice,discount);
    }

    private double applyShipping(PriceData priceData,ShippingMethod shippingMethod) {
        final double shippingPerCase = (priceData.basePrice() > shippingMethod.discountThreshold()) ?
                shippingMethod.discountedFee() : shippingMethod.feePerCase();

        final double shippingCost = priceData.quantity() * shippingPerCase;

        final double price = priceData.basePrice() - priceData.discount() + shippingCost;

        return price;
    }
}
