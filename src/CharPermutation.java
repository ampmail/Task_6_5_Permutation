import java.util.Arrays;

public class CharPermutation {

    public static void main(String[] args) {

        String inputString;
//        inputString = "qwertyuiopa";
        inputString = viewDialog.getSomeText();
        Permutation.STRING_LENGTH = inputString.length(); //uncomment this line for use various inputString length

        if (null == Permutation.checkInputString(inputString)) {
            System.err.println("Метод принимает слово из " + Permutation.STRING_LENGTH + " любых букв латинского алфавита");
        } else {
//            System.out.println(Arrays.deepToString(Permutation.startPermutation(inputString)));
            viewDialog.viewData(Permutation.startPermutation(inputString));
            System.out.println("Количество перестановок равно: " + (Permutation.getPermutationQty() - 1));
        }
//        System.exit(0);
    }
}
