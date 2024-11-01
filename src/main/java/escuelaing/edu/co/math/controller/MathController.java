/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package escuelaing.edu.co.math.controller;

import escuelaing.edu.co.math.services.MathService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author david.pineros-c
 */
@RestController
public class MathController {
    
    private final MathService mathService;
    
    @Autowired
    public MathController(MathService mathService){
        this.mathService = mathService;
    }
    
    @PostMapping("/linearSearch")
    public ResponseEntity<?> linealSearch(@RequestParam("list") List<Integer> list, @RequestParam("value") int value){
        int result = mathService.linearSearch(list, value);
        Map<String, Object> response = new HashMap<>();
        response.put("operation", "linearSearch");
        response.put("inputList", list.toString());
        response.put("value", value);
        response.put("output", result);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    
    @PostMapping("/binarySearch")
    public ResponseEntity<?> binarySearch(@RequestParam("list") List<Integer> list, @RequestParam("value") int value){
        int result = mathService.binarySearch(list, value);
        Map<String, Object> response = new HashMap<>();
        response.put("operation", "binarySearch");
        response.put("inputList", list.toString());
        response.put("value", value);
        response.put("output", result);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}

