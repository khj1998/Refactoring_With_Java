package com.java_refactoring._11_primitive_obsession._03_replace_conditional_with_polymorphism.variation;

import java.util.List;

public class ChinaExperienceVoyageRating extends VoyageRating {
    public ChinaExperienceVoyageRating(Voyage voyage, List<VoyageHistory> history) {
        super(voyage, history);
    }

    @Override
    protected int captainHistoryRisk() {
        int rating = super.captainHistoryRisk() - 2;
        return Math.max(rating,0);
    }

    @Override
    protected int voyageLengthFactor() {
        int result = 0;
        if (this.voyage.length() > 12) result += 1;
        if (this.voyage.length() > 18) result -= 1;

        return result;
    }

    @Override
    protected int historyLengthFactor() {
        return (this.history.size() > 10) ? 1 : 0;
    }

    @Override
    protected int voyageProfitFactor() {
        return super.voyageProfitFactor() + 4;
    }

    @Override
    protected int voyageRisk() {
        int result = super.voyageRisk() + 4;
        return Math.max(result,0);
    }
}
