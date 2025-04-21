package com.application.parking.dto.request;

public class BillRequest {
    private int tokenId;

    public BillRequest() {
    }
    public BillRequest(int tokenId) {
        this.tokenId = tokenId;
    }
    public int getTokenId() {
        return tokenId;
    }
    public void setTokenId(int tokenId) {
        this.tokenId = tokenId;
    }
}
