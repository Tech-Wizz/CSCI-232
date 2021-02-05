import java.util.HashSet;
import java.util.Scanner;

class SubstringCount {
    public static void main(String[] args) {

        Scanner standardInput = new Scanner(System.in);

        //gets the inputing values
        System.out.print("Input String: ");
        String inputString = standardInput.nextLine();

        System.out.print("Input varible \"k\": ");
        int k = standardInput.nextInt();

        //Calculation of hValue
        int hValue = 0;
        int m = 1;
        for (int i = 0; i < k; i++) {
            hValue = (26 * hValue + (inputString.charAt(i) - 97)) % 5001;
        }
        for (int i = 0; i < k - 1; i++) {
            m = (26 * m) % 5001;
        }

        // Hash stuff
        HashSet<Integer> answer = new HashSet<>();
        answer.add(hValue);
        for (int i = k; i < inputString.length(); i++) {
            hValue = ((hValue - m * (inputString.charAt(i - k) - 97) + 5001 * 2) * 26 + (
                    inputString.charAt(i) - 97)) % 5001;
            answer.add(hValue);
        }

        System.out.println("Number of unique substrings of length k are: " + answer.size());
        standardInput.close();
    }
}

//end of program
