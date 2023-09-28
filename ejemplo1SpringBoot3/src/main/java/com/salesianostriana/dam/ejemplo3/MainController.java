package com.salesianostriana.dam.ejemplo3;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @GetMapping("/index/")
    public String index(Model model){
        model.addAttribute("mensaje","hola a todos los coders de 2ªDAM");
        return "index";
        //return "resources/templates/index.html";
    }
}
