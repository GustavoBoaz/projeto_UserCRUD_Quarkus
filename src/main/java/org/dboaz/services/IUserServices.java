package org.dboaz.services;

import javax.ws.rs.core.Response;

import org.dboaz.dtos.UserRegisterDTO;
import org.dboaz.dtos.UserUpdateDTO;
import org.dboaz.exceptions.models.UserBadRequestException;
import org.dboaz.exceptions.models.UserExistException;
import org.dboaz.exceptions.models.UserNotExistException;

/**
 * User interface services, yor class is inplemented in UserServicesImplements.java
 * 
 * @author Boaz
 * @version 1.0
 * @date Feb 10, 2022
 * @see UserServicesImplements
 * @see UserRegisterDTO
 * @see UserUpdateDTO
 * @see UserBadRequestException
 * @see UserExistException
 * @see UserNotExistException
 * @see Response
 */
public interface IUserServices {
    
    Response getUserById(Long idUser) throws UserNotExistException;

    Response getAllUsers();

    Response updateUser(Long idUser, UserUpdateDTO user) throws UserNotExistException, UserBadRequestException;

    Response createUser(UserRegisterDTO user) throws UserExistException, UserBadRequestException;

    Response deleteUser(Long idUser) throws UserNotExistException;

}
