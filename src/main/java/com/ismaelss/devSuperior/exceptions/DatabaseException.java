package com.ismaelss.devSuperior.exceptions;

public class DatabaseException extends RuntimeException{
    public DatabaseException(String msn){
        super(msn);
    }
}
