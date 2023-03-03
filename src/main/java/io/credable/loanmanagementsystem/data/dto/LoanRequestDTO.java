package io.credable.loanmanagementsystem.data.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class LoanRequestDTO {
    private String customerNumber;
    private  Double amount;

}
