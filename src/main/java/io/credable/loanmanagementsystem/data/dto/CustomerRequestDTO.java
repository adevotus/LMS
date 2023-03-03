package io.credable.loanmanagementsystem.data.dto;

import io.credable.loanmanagementsystem.data.vo.Gender;
import io.credable.loanmanagementsystem.data.vo.IdType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.sql.Timestamp;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CustomerRequestDTO {
    private String customerNumber;
    private String customerAmount;
    private String customerStatus;
    private IdType idType;
    private Long ID;
    private String firstName;
    private String email;
    private String status;
    private String lastname;
    private String mobile;
    private Gender gender;
    private String middleName;
    private Double monthlyIncome;
    private Date dob;
    private Date createdDate;
    private Timestamp updatedAt;
    private Timestamp createdAt;


}
