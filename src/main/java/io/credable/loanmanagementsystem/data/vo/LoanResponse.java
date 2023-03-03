package io.credable.loanmanagementsystem.data.vo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class LoanResponse {
     Long id;
     String customerNumber;
     Double score;
     Double limitAmount;
     String exclusion;
     String exclusionReason;

    public LoanResponse(Double limitAmount, String customerNumber, Double score, Long id) {
        this.score = score;
        this.limitAmount = limitAmount;
        this.customerNumber = customerNumber;
        this.id = id;
    }
}
