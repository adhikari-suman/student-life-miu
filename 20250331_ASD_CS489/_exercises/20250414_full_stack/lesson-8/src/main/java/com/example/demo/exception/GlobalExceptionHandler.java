package com.example.demo.exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.stream.Collectors;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public String handleMethodArgumentNotValidException(MethodArgumentNotValidException e, Model model) {

        String errorMessage = e.getBindingResult().getFieldErrors()
                .stream().map(fieldError -> fieldError.getField() + ": "+fieldError.getDefaultMessage())
                .collect(Collectors.joining(", "));

        model.addAttribute("errorMessage", errorMessage);

        return "error";
    }
}
