package ProjektiProve.advice;

import ProjektiProve.mapper.ExceptionResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.context.request.WebRequest;

import java.util.HashMap;
import java.util.Map;

public class ProjectGlobalExceptionHandling extends    ResponseEntityExceptionHandler{

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        ExceptionResponse resp = new ExceptionResponse(HttpStatus.BAD_REQUEST,getRequiredFields(ex));
        return new ResponseEntity<>(resp,HttpStatus.BAD_REQUEST);
    }

    private Map<String,String> getRequiredFields(MethodArgumentNotValidException ex){
        Map<String,String> errors= new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(e ->{
            errors.put(e.getField(),e.getDefaultMessage());
        });
        return errors;
    }
}
