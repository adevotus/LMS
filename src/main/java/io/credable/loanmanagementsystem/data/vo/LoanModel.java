package io.credable.loanmanagementsystem.data.vo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
//@Table(name = "Loan")
public class LoanModel {
  //  @Id
  //  @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

  //  @Column(name = "url")
    private String url;

  //  @Column(name = "name")
    private String name;

  //  @Column(name = "username")
    private String username;

 //   @Column(name = "password")
    private String password;

 //   @Column(name = "token")
    private String token;


}

