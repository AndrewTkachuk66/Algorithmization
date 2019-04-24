package palindrome;

/*Среди всех чисел типа int найти такие, двоичное представление которых является палиндромом (без учета ведущих нулей)*/
public class Palindrome {
    static int number = 2145789 ;
    String result = "";

    public void checkOnPalindrom(int number){
       String numbreToString = Integer.toBinaryString(number);
        for (int i = numbreToString.length() - 1; i >= 0; i--)
        {
            result = result + numbreToString.substring(i, i+1);
        }
        System.out.println(result);

        if(numbreToString.equals(result))
            System.out.println("Number " + number + " is a palindrome" );
        else System.out.println("Number " + number + " is not a palindrome");
    }

    public static void main(String[] args) {
        Palindrome palindrome = new Palindrome();
        palindrome.checkOnPalindrom(number);
    }
}
