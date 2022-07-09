package Main;

import G23.G23;

import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        G23 HuffmanCode = new G23();
        Random random = new Random();
        final int size = 5;
        char[] alphabet = new char[size];
        float[] probabilities = new float[size];
        float total = 0;
        String alpha;
        String alpha2;
        String code;
        char ch = 0;
        boolean repetition;

        for (int i = 0; i < size; ++i) {
            repetition = true;
            while (repetition) {
                repetition = false;
                ch = (char) random.nextInt(65, 91);
                for (char c : alphabet)
                    if (c == ch) {
                        repetition = true;
                        break;
                    }
            }
            alphabet[i] = ch;
        }

        for (int i = 0; i < size; ++i) {
            probabilities[i] = (float) random.nextInt(0, 100);
            total += probabilities[i];
        }

        for (int i = 0; i < size; ++i) probabilities[i] *= 1/total;



        /*
        alphabet = new char[]{'a', 'b', 'c', 'd'};
        probabilities = new float[]{(float) 0.15, (float) 0.15, (float) 0.3, (float) 0.4};

        HuffmanCode.set_alphabet(alphabet, probabilities);

        alpha = "ccabd";
        code = HuffmanCode.encode(alpha);
        alpha2 = HuffmanCode.decode("00000110101"); */


        alpha = Randomstring(alphabet);
        code = HuffmanCode.encode(alpha);
        alpha2 = HuffmanCode.decode(code);

        System.out.println(alphabet);
        System.out.println(Arrays.toString(probabilities) + "\n");

        System.out.println(HuffmanCode.get_codes() + "\n");

        System.out.println("Alpha: " + alpha);
        System.out.println("Code: " + code);
        System.out.println("Alpha2: " + alpha2);
    }

    public static String Randomstring(char[] symbols) {
        Random random = new Random();
        StringBuilder str = new StringBuilder();
        int size = symbols.length;
        int len = random.nextInt(1, 25);

        for (int i = 0; i < len; ++i) str.append(symbols[random.nextInt(0, size)]);
        return str.toString();
    }
}
