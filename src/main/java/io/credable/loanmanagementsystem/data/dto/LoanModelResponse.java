package io.credable.loanmanagementsystem.data.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class LoanModelResponse {

    Long id;
    String loanStatus;
    Double amount;
   Double score;
    String customerNumber;


    public LoanModelResponse(Double amount, String customerNumber, String loanStatus,Double score,Long id) {
        this.amount = amount;
        this.customerNumber = customerNumber;
        this.loanStatus = loanStatus;
        this.score = score;
        this.id =id;
    }
}
