package com.miromaric.dentalassistant.exception;

import java.io.Serializable;

/**
 *
 * @author MikoPC
 */
public class ResourceNotFoundException extends RuntimeException implements Serializable {

    public ResourceNotFoundException(String message) {
        super(message);
    }
}
