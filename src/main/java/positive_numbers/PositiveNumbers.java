package positive_numbers;

import java.util.Arrays;
import java.util.Random;

/*Из двумерного массива целых чисел сформировать новый массив, исключив из исходного отрицательные числа. В полученном массиве найти номер строки, среднее
арифметическое значений в которой максимально. Если таких строк несколько, вывести номер первой такой строки.*/
public class PositiveNumbers {
   static int [][]array = new int[5][5];
    Random rand = new Random();
    public  void positiveAndAverageNumbers(int array[][]){
        System.out.println("Initial array:");
        for (int i = 0; i < array.length ; i++) {
            for (int j = 0; j < array[i].length ; j++) {
                array[i][j]=rand.nextInt(30) - 10;
                System.out.print(array[i][j] + "\t\t");
            }
            System.out.println();
        }
        //removing negative numbers
        int j ;
        double result = 0;
        for (int i = 0; i < array.length ; i++) {
            for ( j = 0; j < array[i].length ; j++) {
                if(array[i][j] < 0)
                    array[i][j]=0;

            }

        }
        //output of positive array
        System.out.println("Positive array:");
        for (int i = 0; i < array.length ; i++) {
            for (j = 0; j < array[i].length ; j++) {

                System.out.print(array[i][j] + "\t\t");
            }
            System.out.println();
        }
       //Finding average of lines
        int count=0;
        for (int i = 0; i < array.length ; i++) {
            for ( j = 0; j < array[i].length ; j++) {
                if(array[i][j] == 0)
                    continue;
                count++;
                result+=array[i][j];
            }
            double avarageNumber = result/count;
            System.out.println("Avarage number of line" + i + ": " + avarageNumber);
            result = 0;
            count = 0;
        }

    }

    public static void main(String[] args) {
        PositiveNumbers pn = new PositiveNumbers();
        pn.positiveAndAverageNumbers(array);
    }
}
