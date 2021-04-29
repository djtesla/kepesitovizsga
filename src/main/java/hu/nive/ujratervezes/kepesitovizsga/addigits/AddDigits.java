package hu.nive.ujratervezes.kepesitovizsga.addigits;

import java.util.Arrays;
import java.util.List;

public class AddDigits {

    public static final List<Character> NUMBERS = Arrays.asList('0', '1', '2', '3', '4', '5', '6', '7', '8', '9');


    public int addDigits(String input) {
        if (isEmpty(input)) {
            return -1;
        }
        int sum = 0;
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (NUMBERS.contains(c)) {
                int number = Integer.parseInt(String.valueOf(c));
                sum += number;
            }
        }
        return sum;
    }

    private boolean isEmpty(String input) {
        return "".equals(input) || input == null;
    }


}


/*    Hozd létre az AddDigits osztályt, és annak az addDigits(String input) metódusát.
        A metódus feladata, hogy a paraméterben kapott Stringben található összes számjegyet adja össze,
        és ennek az összegét adja vissza. Ha a bemeneti String üres, vagy null, adjon vissza -1 értéket.*/
