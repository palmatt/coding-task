package org.example.infogaincodingtask.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class PointsResponse {
    private int totalPoints;
    private List<Transaction> transactionList;
}
