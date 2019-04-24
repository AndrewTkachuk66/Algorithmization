package identical_numbers;

import java.util.ArrayList;
import java.util.List;

public class IdenticalNumbers {

    public static int[] array1 = {4,5,6,1,3};
    public static int[] array2 = {1,2,3};
    List<Integer> resultArray = new ArrayList<>();
    //public int[]array3 = new int[k];
    public void identicalNumbers(int[] array1, int[] array2){
        for (int i = 0; i < array1.length ; i++) {
            for (int j = 0; j < array2.length ; j++) {
                if (array1[i]==array2[j])
                    resultArray.add(array1[i]);
            }
        }
    }

    public static void main(String[] args) {
        IdenticalNumbers in = new IdenticalNumbers();
        in.identicalNumbers(array1, array2);
        System.out.println("Idencial numbers in both arrays: " + in.resultArray);
    }
}
