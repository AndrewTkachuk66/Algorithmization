package most_common_symbol;
/*Строка содержит символы английского алфавита (A…Z и a..z), символ “пробел” и знаки препинания. Найти символ, который встречается чаще
всего (без учета регистра). Если таких символов несколько, вывести любой из них.*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class MostCommonSymbol {
    private static String InputString;
    private static BufferedReader InputReader;
    public static void count(String String) {
        Set<Character> characters = new HashSet<>();
        for (char current_Character : InputString.toCharArray()) {
            characters.add(current_Character);

        }
System.out.println(characters);

        characters.forEach((Character currentCharacter) -> {
                System.out.print("\'" + currentCharacter + "\' - ");

                System.out.println(InputString.chars()
                        .mapToObj(intCharacter -> (char) intCharacter)
                        .filter(character -> character.equals(currentCharacter))
                        .count());
            });
    }
    public static void main(String[] args) throws IOException {

       InputReader = new BufferedReader(new InputStreamReader(System.in));
       InputString = InputReader.readLine();
       InputReader.close();
       InputString=InputString.toLowerCase();
       System.out.println(InputString);
       count(InputString);

    }
}

