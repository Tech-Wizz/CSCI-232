import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeSet;


public class BinPacking {

    //FirstFit is an algorithim that processes the items in the order they arrive.
    //It attempts to place each item in the first available bin that can accommodate it.
    //If no bin is found, it opens a new bin and puts the item into the new bin.

    public static ArrayList<Bin> FirstFit(int binSize, int[] itemSizes) {
        ArrayList<Bin> bins = new ArrayList<Bin>();

        for (int i = 0; i < itemSizes.length; i++) {
            boolean foundBin = false;
            for (Bin bin : bins) {
                if (bin.GetBinSize() > itemSizes[i]) {
                    bin.AddItem(itemSizes[i]);
                    foundBin = true;
                    break;

                }
            }
            if (foundBin == false) {
                Bin myBin = new Bin(binSize);
                myBin.AddItem(itemSizes[i]);
                bins.add(myBin);
            }
            if (itemSizes[i]
                    > binSize) { //Case that the Item is larger than the max bin size, asks user to restart
                StdOut.println(
                        "ERROR: Item is larger than bin sizes, please change your inputs and try again.");
                System.exit(0);
            }

        }
        return bins;
    }

    //Assisting method to BestFitDecreasing.
    //BestFit takes an item size x and returns the bin whose remaining capacity is at least x and is closest to x.

    public static Bin BestFit(int itemSize, TreeSet<Bin> tree, int maxCapacity) {
        //Bin tempBin = new Bin(maxCapacity - itemSize); //original
        Bin tempBin = new Bin(itemSize); //new
        return tree.ceiling(tempBin);
    }

    //Implements a BinarySearch Tree through the TreeSet class. Places each bin in a search tree for ease of access.
    public static TreeSet<Bin> BestFitDecreasing(int binSize, int[] itemSizes) {

        TreeSet<Bin> bestTree = new TreeSet<Bin>();
        for (int i = 0; i < itemSizes.length; i++) {
            if (BestFit(itemSizes[i], bestTree, binSize) == null) {
                Bin myBin = new Bin(binSize);
                myBin.AddItem(itemSizes[i]);
                bestTree.add(myBin);
            }
            else {
                Bin returnValue = BestFit(itemSizes[i], bestTree, binSize);
                bestTree.remove(returnValue);
                returnValue.AddItem(itemSizes[i]);
                bestTree.add(returnValue);
            }
        }
        return bestTree;
    }

    //Assisting method to WorstFitDecreasing
    //WorstFit takes an item size x and returns the bin whose remaining capacity is the greatest and can hold x.
    public static Bin WorstFit(int itemSize, TreeSet<Bin> tree) {
        if (tree.isEmpty() || tree.last().GetBinSize() < itemSize) {
            return null;
        }
        else {
            return tree.last();
        }
    }

    //Implements a BinarySearch Tree through the TreeSet class. Places each bin in a search tree for ease of access.
    //Very Similar to BestFitDecreasing
    public static TreeSet<Bin> WorstFitDecreasing(int binSize, int[] itemSizes) {

        TreeSet<Bin> worstTree = new TreeSet<Bin>();
        for (int i = 0; i < itemSizes.length; i++) {
            if (WorstFit(itemSizes[i], worstTree) == null) {
                Bin myBin = new Bin(binSize);
                myBin.AddItem(itemSizes[i]);
                worstTree.add(myBin);
            }
            else {
                Bin returnValue = WorstFit(itemSizes[i], worstTree);
                worstTree.remove(returnValue);
                returnValue.AddItem(itemSizes[i]);
                worstTree.add(returnValue);
            }
        }
        return worstTree;
    }

    public static void main(String[] args) {

        //Reads in an integer and a text file from the command line arguments to be used
        int input = Integer.parseInt(args[0]);
        In readIn = new In(args[1]);
        String myArray[] = readIn.readAllLines();
        int intArray[] = new int[myArray.length];

        for (int i = 0; i < myArray.length; i++) {
            int add = Integer.parseInt(myArray[i]);
            intArray[i] = add;
        }

        //Prints out each of the three tests using the same data.
        StdOut.println("Array of items to be put into bins and bin size");
        StdOut.println(Arrays.toString(intArray) + ", Bin Size: " + input);

        StdOut.println();
        StdOut.println("Bin packing using First-fit:");
        StdOut.println(FirstFit(input, intArray));

        StdOut.println();
        StdOut.println("Bin packing using BestFitDecreasing:");
        StdOut.println(BestFitDecreasing(input, intArray));

        StdOut.println();
        StdOut.println("Bin packing using WorstFitDecreasing:");
        StdOut.println(WorstFitDecreasing(input, intArray));


    }
}
