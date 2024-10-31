/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package escuelaing.edu.co.math.services;

import org.springframework.stereotype.Service;

/**
 *
 * @author david.pineros-c
 */
@Service
public class MathService {
    
    public int linearSearch(int[] list, int number){
        int result = -1;
        
        for(int i=0;i < list.length;i++){
            if(list[i] == number){
                result = i;
            }
        }
        
        return result;
    }
    
    public int binarySearch(int[] list, int number){
        int start = 0;
        int end = list.length-1;
        int index = -1;
        
        while(start <= end){
            
            int middle = start + (end - start);
            
            if(list[middle] == number){
                index = middle;
            }
            
            else if(list[middle] < number){
                start = middle + 1; 
            }
            
            else{
                end = middle - 1;
            }
        }
        
        return index;
    }
}
