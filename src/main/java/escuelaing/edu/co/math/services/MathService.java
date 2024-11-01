/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package escuelaing.edu.co.math.services;

import java.util.List;

import org.springframework.stereotype.Service;

/**
 *
 * @author david.pineros-c
 */
@Service
public class MathService {

    public int linearSearch(List<Integer> list, int number) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == number) {
                return i;
            }
        }
        return -1;
    }

    public int binarySearch(List<Integer> list, int number) {
        int start = 0;
        int end = list.size() - 1;

        while (start <= end) {
            int middle = start + (end - start) / 2;

            if (list.get(middle) == number) {
                return middle;
            }

            if (list.get(middle) < number) {
                start = middle + 1;
            } else {
                end = middle - 1;
            }
        }

        return -1;
    }
}

