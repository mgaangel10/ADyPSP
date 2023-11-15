package com.example.solucionEjercicio.Controller;

import error.RutaNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.net.URI;
import java.time.Instant;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(RutaNotFoundException.class)
        ProblemDetail handleBookmarkNotFoundException(RutaNotFoundException r){
        ProblemDetail problemaDetail = ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND,r.getMessage());
        problemaDetail.setTitle(" ruta not found");
        problemaDetail.setType(URI.create("https://api.lugar.com/errors/not-found"));
        problemaDetail.setProperty("errorCategory","generic");
        problemaDetail.setProperty("timestamp", Instant.now());
        return problemaDetail;

    }
}
