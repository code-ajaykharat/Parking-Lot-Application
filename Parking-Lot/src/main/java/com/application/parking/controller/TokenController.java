package com.application.parking.controller;

import com.application.parking.dto.request.TokenRequest;
import com.application.parking.dto.response.TokenResponse;
import com.application.parking.model.Token;
import com.application.parking.model.enums.RequestStatus;
import com.application.parking.model.enums.VehicleType;
import com.application.parking.service.TokenService;

import java.util.Optional;

public class TokenController {
    private TokenService tokenService;

    public TokenController(TokenService tokenService) {
        this.tokenService = tokenService;
    }

    public TokenResponse generateToken(TokenRequest tokenRequest) {
        TokenResponse tokenResponse = new TokenResponse();
        Optional<Token> token = tokenService.generateToken(
                tokenRequest.getUserName(),
                tokenRequest.getVehicleNumber(),
                tokenRequest.getVehicleType(),
                tokenRequest.getFloorNumber()
        );
        if(token.isPresent()){
           tokenResponse.setToken(token.get());
           tokenResponse.setRequestStatus(RequestStatus.SUCCESS);
        }else{
            tokenResponse.setRequestStatus(RequestStatus.FAILURE);
            tokenResponse.setFailureMessage("Token generation failed!");
        }
        return tokenResponse;
    }

    public boolean checkVehicleTypeAllowedOnFloorOrNot(VehicleType vehicleType, String floorNumber) {
        return tokenService.checkVehicleTypeAllowedOnFloorOrNot(vehicleType, floorNumber);
    }

    public void printToken(TokenResponse tokenResponse) {
        tokenService.printToken(tokenResponse);
    }

}
