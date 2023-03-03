package io.credable.loanmanagementsystem.data.vo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.sql.Timestamp;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "customerkyc")

public class CustomerModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    @Column(name = "ID")
    private Long ID;

    @Column(name = "idType")
    private IdType idType;

    @Column(name = "customernumber")
    private String customerNumber;

    @Column(name = "customerAmount")
    private String customerAmount;

    @Column(name = "status")
    private String status;

    @Column(name = "email")
    private String email;

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "gender")
    private Gender gender;

    @Column(name = "lastName")
    private String lastName;

    @Column(name = "middleName")
    private String middleName;

    @Column(name = "mobile")
    private String mobile;

    @Column(name = "monthlyIncome")
    private Double monthlyIncome;

    @Column(name = "dob")
    private Date dob;

    @Column(name = "createDate")
    private Date createdDate;

    @Column(name = "updatedAt")
    private Timestamp updatedAt;

    @Column(name = "createdAt")
    private Timestamp createdAt;


}


