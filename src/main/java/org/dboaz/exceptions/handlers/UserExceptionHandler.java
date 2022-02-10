package org.dboaz.exceptions.handlers;

import java.time.LocalDateTime;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.fasterxml.jackson.annotation.JsonFormat;

import org.dboaz.exceptions.models.UserBadRequestException;
import org.dboaz.exceptions.models.UserExistException;
import org.dboaz.exceptions.models.UserNotExistException;

/**
 * Class responsible for handling user exceptions
 * 
 * @author Boaz
 * @version 1.0
 * @date Feb 10, 2022
 * @see ExceptionMapper
 * @see UserNotExistException
 * @see UserExistException
 * @see UserBadRequestException
 */
@Provider
public class UserExceptionHandler implements ExceptionMapper<Exception> {

    /**
     * Method responsible for delivery handling user exceptions
     * 
     * @param exception
     * @return Response
     * @author Boaz
     * @version 1.0
     * @date Feb 10, 2022
     */
    @Override
    public Response toResponse(Exception exception) {
        if(exception instanceof UserNotExistException) {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity(new ErrorResponseBody(404L ,exception.getMessage()))
                    .build();
        }

        if (exception instanceof UserExistException) {
            return Response.status(Response.Status.CONFLICT)
                    .entity(new ErrorResponseBody(409L, exception.getMessage()))
                    .build();
        }

        if (exception instanceof UserBadRequestException) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity(new ErrorResponseBody(400L, exception.getMessage()))
                    .build();
        }

        return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                .entity(new ErrorResponseBody(500L, "Internal Server Error"))
                .build();
    }

    /**
     * Public static class responsible for returning error response body
     * 
     * @author Boaz
     * @version 1.0
     * @date Feb 10, 2022
     * @see ErrorResponseBody
     */
    public static final class ErrorResponseBody {

        private final Long status;
        private final String message;
        private final @JsonFormat(pattern = "yyyy/MM/dd HH:MM:SS") LocalDateTime timestamp = LocalDateTime.now();

        public ErrorResponseBody( Long status, String message) {
            this.status = status;
            this.message = message;
        }

        public String getMessage() {
            return message;
        }

        public Long getStatus() {
            return status;
        }

        public LocalDateTime getTimestamp() {
            return timestamp;
        }
    }
    
}
