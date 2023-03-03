package io.credable.loanmanagementsystem.service;

import io.credable.loanmanagementsystem.config.LoanConfig;
import io.credable.loanmanagementsystem.data.dto.LoanModelResponse;
import io.credable.loanmanagementsystem.data.dto.LoanRequestDTO;
import io.credable.loanmanagementsystem.data.vo.LoanResponse;
import io.credable.loanmanagementsystem.data.vo.Loanstatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

//
@Service
public class LoanService {


    private final LoanConfig loanConfig;
    private LoanModelResponse loanModelResponse;

    @Autowired
    public LoanService(LoanConfig loanConfig) {
        this.loanConfig = loanConfig;
    }

    /**********************************************************
     loan status checking conditions
     *********************************************************/

    public ResponseEntity<LoanModelResponse> loanStatus(LoanRequestDTO loanrquest) {
        LoanResponse scoring = loanConfig.clientScore(loanrquest.getCustomerNumber());
        String loanStatus;
        Long id = scoring.getId();
        Double score = scoring.getScore();


        if (scoring.getLimitAmount() >= loanrquest.getAmount()) {
            loanStatus = String.valueOf(Loanstatus.Succesfull);
            Logger.getGlobal().info("you will be request a loan from us!." + loanStatus);
        }
        else if (scoring.getLimitAmount() <= loanrquest.getAmount()) {
            loanStatus = String.valueOf(Loanstatus.Pending);
            Logger.getGlobal().info("wait for  the response from us !!" + loanStatus);
        } else {
            loanStatus = String.valueOf(Loanstatus.Rejected);
            Logger.getGlobal().info("Sorry !! ,your not allowed to get a loan " + loanStatus);

        }

        LoanModelResponse responseDTO = new LoanModelResponse(loanrquest.getAmount(), loanrquest.getCustomerNumber(), loanStatus, score, id);

        return ResponseEntity.ok(responseDTO);
    }


}
