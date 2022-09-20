package com.sentidos.api.controllers;

import com.sentidos.api.entities.Menu;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/menu/")
public class MenuController {

    @GetMapping
    public Menu allMenu(){

        return null;
    }
    @GetMapping("/api/v1/menubyid/")
    @ResponseBody
    public Menu menuById(){

        return null;
    }


}
