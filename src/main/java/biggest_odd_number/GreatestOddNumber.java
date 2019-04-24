package biggest_odd_number;

import java.util.*;

/*В одномерном массиве целых чисел найти наибольшее нечетное число*/
public class GreatestOddNumber {
    static private int[] array = new int[20];
    private Random rand = new Random();
    public   TreeSet<Integer> arrayOfOddNumbers = new TreeSet<>();

    public static int[] getArray() {
        return array;
    }

    public void initializeArray(){
        for (int i = 0; i < array.length; i++) {
            array[i] = rand.nextInt(100);
        }
        //System.out.println("Initial array: " + Arrays.toString(array));
    }

    public void findTheBiggestOddNumber(int array[]) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 != 0) {
                arrayOfOddNumbers.add(array[i]);
            }
        }
    }

    public void printResult(){
        System.out.println("Array of odd numbers: " + arrayOfOddNumbers);
        System.out.println("The biggest odd number is: " + arrayOfOddNumbers.last());
    }

    public static void main(String[] args) {
        GreatestOddNumber gr = new GreatestOddNumber();
        gr.initializeArray();
        gr.findTheBiggestOddNumber(array);
        gr.printResult();

    }
}










