package com.example.livraison.use_case.exeption;

public class ColisAlreadyDeliveredException extends Exception{

    public ColisAlreadyDeliveredException(String message) {
        super(message);
    }
}
