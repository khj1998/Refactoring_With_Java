package com.java_refactoring._11_primitive_obsession._03_replace_conditional_with_polymorphism.variation;

import java.util.List;

public class EastIndiesExperienceVoyageRating extends VoyageRating {
    public EastIndiesExperienceVoyageRating(Voyage voyage, List<VoyageHistory> history) {
        super(voyage, history);
    }

    @Override
    protected int voyageProfitFactor() {
        return super.voyageProfitFactor() + 1;
    }

    @Override
    protected int voyageRisk() {
        int result = super.voyageRisk() + 4;
        return Math.max(result,0);
    }
}
