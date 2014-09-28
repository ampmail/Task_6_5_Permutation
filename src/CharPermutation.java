import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CharPermutation {

    static int STRING_LENGTH = 4;

    public static void main(String[] args) {

        String inputString;
        inputString = "qwer";
//        STRING_LENGTH = inputString.length(); //uncomment this line for use various inputString length

        if (null == Permutation.checkInputString(inputString)) {
            System.err.println("Метод принимает слово из " + STRING_LENGTH + " любых букв латинского алфавита");
        } else {
            System.out.println(Arrays.deepToString(Permutation.startPermutation(inputString)));
            System.out.println("Количество перестановок равно: " + (Permutation.getPermutationQty() - 1));
        }
    }

    public static class Permutation {
        private static int resultSetIndex;
        static String[] resultStringSet;
        static int permutationQty;

        public static int getPermutationQty() {
            return permutationQty;
        }

        public static String checkInputString(String inputString) {
            if (inputString != null && inputString.length() == STRING_LENGTH) {
                String pattern = "[a-zA-Z]{" + STRING_LENGTH + "}"; //
                Pattern pat = Pattern.compile(pattern);
                Matcher mat = pat.matcher(inputString);
                return (mat.find()) ? (mat.group()) : (null);
            }
            return null;
        }

        public static int factorial(int n) {
            if (n == 0) return 1;
            return n * factorial(n - 1);
        }

        public static String[] startPermutation(String inputString) {
            permutationQty = factorial(STRING_LENGTH);
            char[] charSet = inputString.toCharArray();
            resultStringSet = new String[permutationQty];
            permutation(charSet, inputString.length());
            return resultStringSet;
        }

        private static void permutation(char[] chars, int size) {
            if (size < 2) {
                resultStringSet[resultSetIndex++] = Arrays.toString(chars);
            } else {
                for (int k = 0; k < size; k++) {
                    swap(chars, k, size - 1);
                    permutation(chars, size - 1);
                    swap(chars, k, size - 1);
                }
            }
        }

        private static void swap(char[] ch, int index0, int index1) {
            char tmp = ch[index0];
            ch[index0] = ch[index1];
            ch[index1] = tmp;
        }
    }
}
