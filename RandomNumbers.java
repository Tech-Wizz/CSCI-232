/* *****************************************************************************
 *  Name:    Kruize Christensen
 *  NetID:   alovelace
 *  Precept: P00
 *
 *  Description:  Prints 'Hello, World' to the terminal window.
 *                By tradition, this is everyone's first program.
 *                Prof. Brian Kernighan initiated this tradition in 1974.
 *
 **************************************************************************** */

import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;
import java.util.Random;

public class RandomNumbers {
    public static void main(String[] args) {

        //made it so R and N are random numbers for presentation
        Random rd = new Random();
        int N = rd.nextInt(1000 - 1);
        int R = rd.nextInt(1000 - 1);

        //this was so you can enter values in if wanted
        //Scanner in = new Scanner(System.in);
        //StdOut.print("Maximun number value: ");
        //int R = in.nextInt();

        //this part is the number generator from 31-39
        int amountNumbers = N;
        int max = R;

        int numbers[] = new int[amountNumbers];

        for (int i = 0; i < amountNumbers; i++) {
            int randomNumber = rd.nextInt(max - 1);
            numbers[i] = randomNumber;
        }

        //print out the info needed
        StdOut.println("Random Integers: " + Arrays.toString(numbers));
        StdOut.println(
                amountNumbers + " random integers were generated in the range 0 to " + (max - 1));

    }
}
