package racingcar.domain;

import racingcar.constant.ErrorLog;

public class FinalRoundChecker {
    private final int finalRoundNumber;

    public FinalRoundChecker(int finalRoundNumber) {
        this.finalRoundNumber = finalRoundNumber;
    }

    public boolean isFinal(int roundNumber) {
        if (roundNumber > finalRoundNumber) {
            throw new IllegalArgumentException(ErrorLog.OVER_FINAL_ROUND_NUMBER.getMessage());
        }
        return finalRoundNumber == roundNumber;
    }
}