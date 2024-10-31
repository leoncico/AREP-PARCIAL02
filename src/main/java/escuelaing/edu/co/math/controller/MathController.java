/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package escuelaing.edu.co.math.controller;

import escuelaing.edu.co.math.services.MathService;
import java.util.List;
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
    
    public MathService mathService;
    
    @Autowired
    public MathController(MathService mathService){
        this.mathService = mathService;
    }
    
    @PostMapping("/linearSearch")
    public ResponseEntity<?> linealSearch(@RequestParam String list, @RequestParam int value){
        
        String[] listString = new String[list.length()];
        listString = list.split(",");
        
        int[] listInt = new int[list.length()];
        
        for(int i=0; i<list.length(); i++){
            listInt[i] = Integer.parseInt(listString[i]);
        }
        
        return new ResponseEntity(mathService.linearSearch(listInt, value), HttpStatus.OK);
    }
    
    @PostMapping("/binarySearch")
    public ResponseEntity<?> binarySearch(@RequestParam String list, @RequestParam int value){
        
        String[] listString = new String[list.length()];
        listString = list.split(",");
        
        int[] listInt = new int[list.length()];
        
        for(int i=0; i<list.length(); i++){
            listInt[i] = Integer.parseInt(listString[i]);
        }
        
        return new ResponseEntity(mathService.binarySearch(listInt, value), HttpStatus.OK);
    }
    
}
