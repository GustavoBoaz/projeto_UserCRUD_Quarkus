package org.dboaz.exceptions.models;

/**
 * Class responsible for user exceptions case user not exist
 * 
 * @author Boaz
 * @version 1.0
 * @date Feb 10, 2022
 */
public class UserNotExistException extends Exception {

    public UserNotExistException(String message) {
        super(message);
    }
   
}
