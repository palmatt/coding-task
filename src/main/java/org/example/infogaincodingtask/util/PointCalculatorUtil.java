package org.example.infogaincodingtask.util;

import org.example.infogaincodingtask.domain.Transaction;

public class PointCalculatorUtil {
    public static int calculatePoints(Transaction transaction) {
        int amount = transaction.getTransactionAmount();
        int sum = 0;
        if (amount >= 100) {
            sum += 50;
            sum += (amount - 100) * 2;
        } else {
            if (amount >= 50) {
                sum += amount - 50;
            }
        }

        return sum;
    }
}
