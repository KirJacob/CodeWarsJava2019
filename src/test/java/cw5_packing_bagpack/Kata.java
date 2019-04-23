package cw5_packing_bagpack;

import java.util.ArrayList;
import java.util.List;

public class Kata {
    /**
        scores = [15, 10, 9, 5]
        weights = [1, 5, 3, 4]
        capacity = 8
     */
    //1+3+4 = 15 + 9 + 5
    //1,2,3,4,12,13,14
    //12345
    //123, 124, 125, 134, 135, 145
    //234, 235, 245
    //345
    //6+3+1=10 5!/2!*3!=5*4/2 = 10
    private static List<List<Integer>> getBinomic(int n, int k){ //k<n
        List<List<Integer>>result = new ArrayList<>();
        List<Integer>result1 = new ArrayList<>();
        for (int i = 0; i < n; )
        result.add(result1);
        return result;
    }
}
