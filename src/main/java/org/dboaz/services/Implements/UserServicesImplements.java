package org.dboaz.services.Implements;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.validation.Validator;
import javax.ws.rs.core.Response;

import org.dboaz.dtos.UserRegisterDTO;
import org.dboaz.dtos.UserUpdateDTO;
import org.dboaz.exceptions.models.UserBadRequestException;
import org.dboaz.exceptions.models.UserExistException;
import org.dboaz.exceptions.models.UserNotExistException;
import org.dboaz.repositories.UserRepository;
import org.dboaz.services.IUserServices;

/**
 * User class services implements interface IUserServices
 * 
 * @author Boaz
 * @version 1.0
 * @date Feb 10, 2022
 * @see IUserServices
 */
@ApplicationScoped
public class UserServicesImplements implements IUserServices {

    private @Inject UserRepository repository;
    private @Inject Validator validator;

    /**
     * Method search user by id in database
     * 
     * @param idUser
     * @return Response
     * @throws UserNotExistException
     * @author Boaz
     * @version 1.0
     * @date Feb 10, 2022
     * @see UserNotExistException
     */
    @Override
    public Response getUserById(Long idUser) throws UserNotExistException {
        return repository.findByIdOptional(idUser).map(resp -> {
            return Response.ok(resp).build();
        }).orElseThrow(() -> new UserNotExistException("User not exist"));
    }

    /**
     * Method search all users in database
     * 
     * @return Response
     * @author Boaz
     * @version 1.0
     * @date Feb 10, 2022
     */
    @Override
    public Response getAllUsers() {
        return Response.ok(repository.listAll()).build();
    }

    /**
     * Method create user in database
     * 
     * @param user
     * @return Response
     * @throws UserExistException
     * @throws UserBadRequestException
     * @author Boaz
     * @version 1.0
     * @date Feb 10, 2022
     */
    @Transactional
    @Override
    public Response createUser(UserRegisterDTO user) throws UserExistException, UserBadRequestException {
        if (!validator.validate(user).isEmpty()) {
            throw new UserBadRequestException("User bad request, provide all fields");
        }

        if (repository.findByEmail(user.getEmail()).isEmpty()) {
            repository.persistAndFlush(user.toUserModel());
            return Response.status(201).entity(repository.findByEmail(user.getEmail()).get()).build();
        } else {
            throw new UserExistException("User exist in database, try another email");
        }
    }

    /**
     * Method update user in database
     * 
     * @param idUser
     * @param user
     * @return Response
     * @throws UserNotExistException
     * @throws UserBadRequestException
     * @author Boaz
     * @version 1.0
     * @date Feb 10, 2022
     */
    @Transactional
    @Override
    public Response updateUser(Long idUser, UserUpdateDTO user) throws UserNotExistException, UserBadRequestException {
        if (!validator.validate(user).isEmpty()) {
            throw new UserBadRequestException("User bad request, provide all fields");
        }
        return repository.findByIdOptional(idUser).map(resp -> {
            resp.setName(user.getName());
            resp.setPassword(user.getPassword());
            repository.persist(resp);
            return Response.ok(resp).build();
        }).orElseThrow(() -> new UserNotExistException("User not exist"));
    }

    /**
     * Method delete by id user in database
     * 
     * @param idUser
     * @return Response
     * @throws UserNotExistException
     * @author Boaz
     * @version 1.0
     * @date Feb 10, 2022
     */
    @Override
    public Response deleteUser(Long idUser) throws UserNotExistException {
        return repository.findByIdOptional(idUser).map(resp -> {
            repository.deleteById(idUser);
            return Response.noContent().build();
        }).orElseThrow(() -> new UserNotExistException("User not exist"));
    }
    
}
