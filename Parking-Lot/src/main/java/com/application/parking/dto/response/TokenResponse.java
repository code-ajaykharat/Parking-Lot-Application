package com.application.parking.dto.response;

import com.application.parking.model.Token;
import com.application.parking.model.enums.RequestStatus;

public class TokenResponse {
    private Token token;
    private RequestStatus requestStatus;
    private String failureMessage;

    public TokenResponse(){

    }

    public TokenResponse(Token token, RequestStatus requestStatus, String failureMessage) {
        this.token = token;
        this.requestStatus = requestStatus;
        this.failureMessage = failureMessage;
    }

    public Token getToken() {
        return token;
    }

    public void setToken(Token token) {
        this.token = token;
    }

    public RequestStatus getRequestStatus() {
        return requestStatus;
    }

    public void setRequestStatus(RequestStatus requestStatus) {
        this.requestStatus = requestStatus;
    }

    public String getFailureMessage() {
        return failureMessage;
    }

    public void setFailureMessage(String failureMessage) {
        this.failureMessage = failureMessage;
    }
}
