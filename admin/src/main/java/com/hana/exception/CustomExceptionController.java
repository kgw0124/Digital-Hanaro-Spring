package com.hana.exception;

import org.springframework.dao.DuplicateKeyException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomExceptionController {
    @ExceptionHandler(Exception.class) // Exception error가 던져지면 여기서 처리한다.
    public String except(Exception e, Model model){
        model.addAttribute("msg", e.getMessage());
        model.addAttribute("center", "error");
        return "index";
   }

    @ExceptionHandler(DuplicateKeyException.class) // Exception error가 던져지면 여기서 처리한다.
    public String except2(Exception e, Model model){
        model.addAttribute("msg", e.getMessage());
        model.addAttribute("center", "error");
        return "index";
    }
}
