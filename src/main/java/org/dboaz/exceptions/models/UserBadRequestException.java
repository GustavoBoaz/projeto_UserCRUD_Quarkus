package org.dboaz.exceptions.models;

/**
 * Class responsible for user exceptions case bad request
 * 
 * @author Boaz
 * @version 1.0
 * @date Feb 10, 2022
 */
public class UserBadRequestException extends Exception {

    public UserBadRequestException(String message) {
        super(message);
    }
    
}
