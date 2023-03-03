package io.credable.loanmanagementsystem.controller;

import io.credable.loanmanagementsystem.config.LoanConfig;
import io.credable.loanmanagementsystem.data.dto.LoanModelResponse;
import io.credable.loanmanagementsystem.data.dto.LoanRequestDTO;
import io.credable.loanmanagementsystem.data.vo.LoanResponse;
import io.credable.loanmanagementsystem.service.LoanService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/restws")

public class LoanController {
    private static final Logger log = LoggerFactory.getLogger(LoanController.class);
    @Autowired
    private LoanService loanService;
    @Autowired
    private LoanConfig loanConfig;




    /***************************************************
     API FOR QUERY SCORE
     *************************************************/
    @GetMapping("/getScore/{customerNumber}")
    public ResponseEntity<LoanResponse> getClientScore(@PathVariable String customerNumber) {
        LoanResponse register = loanConfig.clientScore(customerNumber);
        return new ResponseEntity<>(register, HttpStatus.OK);

    }



    /***************************************************
            API FOR CHECKING LOAN STATUS
     *************************************************/
    @PostMapping("/LoanStatus/")
    public ResponseEntity<LoanModelResponse> getLoanStatus(@RequestBody LoanRequestDTO loanRequestDTO) {
        ResponseEntity<LoanModelResponse> response = loanService.loanStatus(loanRequestDTO);
        return ResponseEntity.ok(response.getBody());

    }



}
