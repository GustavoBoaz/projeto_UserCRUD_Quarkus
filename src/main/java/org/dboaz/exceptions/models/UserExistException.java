package org.dboaz.exceptions.models;

/**
 * Class responsible for user exceptions case user exist
 * 
 * @author Boaz
 * @version 1.0
 * @date Feb 10, 2022
 */
public class UserExistException extends Exception {

    public UserExistException(String message) {
        super(message);
    }
  
}
