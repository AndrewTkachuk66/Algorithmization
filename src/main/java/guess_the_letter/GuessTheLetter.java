package guess_the_letter;

import java.util.*;

/*Пользователь должен угадать загаданную программой латинскую букву вводя свой вариант буквы с клавиатуры.Если пользователь угадал букву, программа выводит
сообщение о выигрыше и количестве попыток пользователя. Если буква не угадана, программа предлагает ввести другую букву. При этом программа выводит подсказки.
Если пользователь ввел букву меньше загаданной – вывести сообщение об этом (например, «Too low!»). Аналогично при вводе буквы больше загаданной (например, «Too high!»).
Если введена не латинская буква – предложить пользователю внимательно ознакомиться с правилами игры. Программа должна быть не чувствительна к регистру введенной
пользователем буквы. Например, при загаданной букве ‘G’ ответы пользователя ‘G’ или ‘g’ в равной степени считаются правильными.Игра продолжается до выигрыша пользователя.*/
public class GuessTheLetter {
    static char[] alphabet = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
    static Random rand = new Random();
    static int randomIndex = rand.nextInt(26);


    public char getRandomLetter(){
        char randomLetter = alphabet[randomIndex];
        System.out.println("Random leter:" + randomLetter);
        return randomLetter;
   }

   public  int whatIndexEnterLetter(char enterLetter){
       int count = -1;
       for (int i = 0; i < alphabet.length; i++) {
           count++;
           if (enterLetter == alphabet[i])
               break;
       }
       //System.out.println("Index of random letter: " + count);
       return count;

   }

   public boolean analyze(int randomIndex, char enterLetter){
      boolean win = true;
       GuessTheLetter gl = new GuessTheLetter();
       int indexOfEnterletter = gl.whatIndexEnterLetter(enterLetter);
           if (indexOfEnterletter==randomIndex) {
               System.out.println("You win");
               win = false;
           }
           else if(indexOfEnterletter < randomIndex){
               System.out.println("Find higher");
           }
           else System.out.println("Find lower");
           return win;
   }

   public  boolean validation(char enterLetter){
       boolean valid = false;
       int i;
       for (i = 0; i < alphabet.length; i++) {
           if (alphabet[i]==enterLetter) {
               valid = true;
               break;
           }
       }
       i = 0;
       return valid;
   }
    public static void main(String[] args) {
        boolean win;
        boolean valid;
        int count = 0;
        GuessTheLetter gl = new GuessTheLetter();
        gl.getRandomLetter();
        while (true) {
            count++;
            System.out.println("Quess a letter for A to Z");
            Scanner scanner = new Scanner(System.in);
            char enterLetter = scanner.next().charAt(0);
            char enterLetterInLowCase = Character.toLowerCase(enterLetter);
            valid = gl.validation(enterLetterInLowCase);
            if (valid) {
                win = gl.analyze(randomIndex, enterLetterInLowCase);
                if (win == false) break;
            }else System.out.println("You can enter only latin letters");
        }
        System.out.println("You use "+ count  + " attempts");
    }
}
