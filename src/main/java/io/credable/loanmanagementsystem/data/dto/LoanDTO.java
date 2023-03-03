package io.credable.loanmanagementsystem.data.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class LoanDTO {
    private String url;
    private String name;
    private String username;
    private String password;
    private String customerNumber;



}


