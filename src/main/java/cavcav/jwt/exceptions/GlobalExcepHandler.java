package cavcav.jwt.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class GlobalExcepHandler {

    @ExceptionHandler(EmailAlreadyExistException.class)
    public ResponseEntity<?> emailAlreadyExist(EmailAlreadyExistException ex){
        List<String> detail=new ArrayList<String>();
        detail.add(ex.getMessage());
        ErrorResponse errorResponse=new ErrorResponse("Email Already Exist",detail);
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

}
