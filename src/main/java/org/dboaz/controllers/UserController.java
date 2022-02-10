package org.dboaz.controllers;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.dboaz.dtos.UserRegisterDTO;
import org.dboaz.dtos.UserUpdateDTO;
import org.dboaz.exceptions.handlers.UserExceptionHandler;
import org.dboaz.exceptions.models.UserBadRequestException;
import org.dboaz.exceptions.models.UserExistException;
import org.dboaz.exceptions.models.UserNotExistException;
import org.dboaz.models.UserModel;
import org.dboaz.services.Implements.UserServicesImplements;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;

/**
 * Controller class responsible for user services
 * 
 * @author Boaz
 * @version 1.0
 * @date Feb 10, 2022
 */
@Path("/api/v1/users")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserController {

    private @Inject UserServicesImplements services;

    @GET
    @Operation(summary = "Get all users", description = "Get all users")
    @APIResponses(
        value = {
            @APIResponse(
                responseCode = "200",
                description = "Successful operation",
                content = @Content(mediaType = "application/json", schema = @Schema(implementation = UserModel.class))),
            @APIResponse(
                responseCode = "500",
                description = "Internal Server Error",
                content = @Content(mediaType = "application/json", schema = @Schema(implementation = UserModel.class)))
        }
    )
    public Response getUsers() {
        return services.getAllUsers();
    }
    
    @GET
    @Path("/{id_user}")
    @Operation(summary = "Get user by id", description = "Get user by id")
    @APIResponses(
        value = {
            @APIResponse(
                responseCode = "200",
                description = "Successful operation",
                content = @Content(mediaType = "application/json", schema = @Schema(implementation = UserModel.class))),
            @APIResponse(
                responseCode = "404",
                description = "User not exist",
                content = @Content(mediaType = "application/json", schema = @Schema(implementation = UserExceptionHandler.ErrorResponseBody.class))),
            @APIResponse(
                responseCode = "500",
                description = "Internal Server Error",
                content = @Content(mediaType = "application/json", schema = @Schema(implementation = UserExceptionHandler.ErrorResponseBody.class)))
        }
    )
    public Response findUserById(@PathParam("id_user") Long idUser) throws UserNotExistException {
        return services.getUserById(idUser);
    }

    @POST
    @Operation(summary = "Create a new user", description = "Create a new user")
    @APIResponses(
        value = {
            @APIResponse(
                responseCode = "201",
                description = "Successful operation",
                content = @Content(mediaType = "application/json", schema = @Schema(implementation = UserModel.class))),
            @APIResponse(
                responseCode = "400",
                description = "Bad request",
                content = @Content(mediaType = "application/json", schema = @Schema(implementation = UserExceptionHandler.ErrorResponseBody.class))),
            @APIResponse(
                responseCode = "409",
                description = "User already exist",
                content = @Content(mediaType = "application/json", schema = @Schema(implementation = UserExceptionHandler.ErrorResponseBody.class))),
            @APIResponse(
                responseCode = "500",
                description = "Internal server error",
                content = @Content(mediaType = "application/json", schema = @Schema(implementation = UserExceptionHandler.ErrorResponseBody.class)))
        }
    )
    public Response saveUser(UserRegisterDTO user) throws UserExistException, UserBadRequestException {
        return services.createUser(user);
    }

    @PUT
    @Path("/{id_user}")
    @Operation(summary = "Update user by id", description = "Update user by id")
    @APIResponses(
        value = {
            @APIResponse(
                responseCode = "200",
                description = "Successful operation",
                content = @Content(mediaType = "application/json", schema = @Schema(implementation = UserModel.class))),
            @APIResponse(
                responseCode = "404",
                description = "User not exist",
                content = @Content(mediaType = "application/json", schema = @Schema(implementation = UserExceptionHandler.ErrorResponseBody.class))),
            @APIResponse(
                responseCode = "500",
                description = "Internal Server Error",
                content = @Content(mediaType = "application/json", schema = @Schema(implementation = UserExceptionHandler.ErrorResponseBody.class)))
        }
    )
    public Response updateUser(@PathParam("id_user") Long idUser, UserUpdateDTO user) throws UserNotExistException, UserBadRequestException {
        return services.updateUser(idUser, user);
    }

    @DELETE
    @Path("/{id_user}")
    @Operation(summary = "Delete user by id", description = "Delete user by id")
    @APIResponses(
        value = {
            @APIResponse(
                responseCode = "200",
                description = "Successful operation",
                content = @Content(mediaType = "application/json", schema = @Schema(implementation = UserModel.class))),
            @APIResponse(
                responseCode = "404",
                description = "User not exist",
                content = @Content(mediaType = "application/json", schema = @Schema(implementation = UserExceptionHandler.ErrorResponseBody.class))),
            @APIResponse(
                responseCode = "500",
                description = "Internal Server Error",
                content = @Content(mediaType = "application/json", schema = @Schema(implementation = UserExceptionHandler.ErrorResponseBody.class)))
        }
    )
    public Response deleteUser(@PathParam("id_user") Long idUser) throws UserNotExistException {
        return services.deleteUser(idUser);
    }

}
