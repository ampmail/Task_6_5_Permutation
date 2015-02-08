public class CharPermutation {

    public static void main(String[] args) {

        ViewDialog viewDialog = new ViewDialog();

        String inputString;
//        inputString = "qwertyuiopa";
        inputString = ViewDialog.getSomeText();
        if(inputString != null) {
            if (!inputString.isEmpty()) {
                Permutation.STRING_LENGTH = inputString.length(); //uncomment this line for use various inputString length
                if (null != Permutation.checkInputString(inputString)) {
//            System.out.println(Arrays.deepToString(Permutation.startPermutation(inputString)));
                    viewDialog.viewData(Permutation.startPermutation(inputString));
                    viewDialog.showInfo("Result", "Permutations quantity: " + (Permutation.getPermutationQty() - 1));
                } else {
                    viewDialog.showInfo("Info","Please enter letters or digits");
                    System.exit(0);
                }
            } else {
                viewDialog.showInfo("Info","Input data not defined");
//                System.err.println("Input data not defined");
                System.exit(0);
            }
        }else {
            System.exit(0);
        }
    }
}