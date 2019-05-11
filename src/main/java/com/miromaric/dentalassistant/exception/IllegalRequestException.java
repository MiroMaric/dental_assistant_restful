package com.miromaric.dentalassistant.exception;

import java.io.Serializable;

/**
 *
 * @author MikoPC
 */
public class IllegalRequestException extends RuntimeException implements Serializable{

    public IllegalRequestException(String message) {
        super(message);
    }
    
}
