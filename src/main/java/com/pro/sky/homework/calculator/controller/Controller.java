package com.pro.sky.homework.calculator.controller;

import com.pro.sky.homework.calculator.service.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping ("calculator")
public class Controller {

    private final Service service;

    public Controller(Service service) {
        this.service = service;
    }

    @GetMapping
    public String hello() {
        return "<b>Добро пожаловать в калькулятор</b>";
    }
    @GetMapping ("plus")
    public String plus(@RequestParam(required = false, name = "num1") Integer num1, @RequestParam (required = false, name = "num2") Integer num2) {
        if (num1 == null || num2 == null) {
            return "<i><b>Нужны оба числа!</b></i>";
        }
        return num1 + " + " + num2 + " = " + service.plus(num1, num2);
    }
    @GetMapping ("minus")
    public String minus(@RequestParam(required = false, name = "num1") Integer num1, @RequestParam (required = false, name = "num2") Integer num2) {
        if (num1 == null || num2 == null) {
            return "<i><b>Нужны оба числа!</b></i>";
        }
        return num1 + " - " + num2 + " = " + service.minus(num1, num2);
    }
    @GetMapping ("multiply")
    public String multiply(@RequestParam(required = false, name = "num1") Integer num1, @RequestParam (required = false, name = "num2") Integer num2) {
        if (num1 == null || num2 == null) {
            return "<i><b>Нужны оба числа!</b></i>";
        }
        return num1 + " * " + num2 + " = " + service.multiply(num1, num2);
    }
    @GetMapping ("divide")
    public String divide(@RequestParam(required = false, name = "num1") Integer num1, @RequestParam (required = false, name = "num2") Integer num2) {
        if (num1 == null || num2 == null) {
            return "<i><b>Нужны оба числа!</b></i>";
        }
        if (num2 == 0) {
            return  "<i><b>На ноль делить нельзя!</b></i>";
        }
        return num1 + " / " + num2 + " = " + service.divide(num1, num2);
    }
}

