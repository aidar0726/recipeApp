package com.example.recipeapp.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FirstController {

    @GetMapping
    public String applicationLaunched () {
        return "Application launched";
    }

    @GetMapping("/info")
    public String showGeneralAppInfo () {
        return "Ученик Айдар, Название проекта: recipeApp, Дата создания - 13.01.2023, проект для работы с рецептами";
    }
}
