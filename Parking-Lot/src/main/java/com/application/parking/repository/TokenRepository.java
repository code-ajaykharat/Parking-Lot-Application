package com.application.parking.repository;

import com.application.parking.exception.TokenNotFoundException;
import com.application.parking.model.Token;

import java.util.HashMap;
import java.util.Map;

public class TokenRepository {
    private Map<Integer, Token> tokenDb;

    private static int id = 0;

    public TokenRepository() {
        tokenDb = new HashMap<>();
    }

    public Token save(Token token) {
        if(token!=null){
            if(!tokenDb.containsKey(token.getId())){
                token.setId(++id);
            }
            tokenDb.put(token.getId(), token);
            //System.out.println("Token saved successfully!");
            return token;
        }
        throw new TokenNotFoundException("Token not found!");
    }

    public Token getById(int id) {
        if(tokenDb.containsKey(id)){
            return tokenDb.get(id);
        }
        throw new TokenNotFoundException("Token not found with id "+id);
    }
}
