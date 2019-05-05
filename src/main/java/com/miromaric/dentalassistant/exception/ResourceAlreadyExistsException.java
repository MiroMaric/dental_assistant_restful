package com.miromaric.dentalassistant.exception;

import java.io.Serializable;

/**
 *
 * @author MikoPC
 */
public class ResourceAlreadyExistsException extends RuntimeException implements Serializable {

    public ResourceAlreadyExistsException(String message) {
        super(message);
    }

}
