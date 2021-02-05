import java.util.ArrayList;

public class Bin implements Comparable<Bin> { //This constructor class implements comparable

    public int binSize;
    public ArrayList<Integer> items = new ArrayList<Integer>();
    private static int count = 0;
    public int id = 0;

    public Bin(int binSize) { //Constructor for Bin class
        this.binSize = binSize;
        count++;
        id = count;


    }

    public int GetBinSize() { //returns the size of the bin to be used in BinPacking
        return binSize;
    }

    public void AddItem(int addItem) { //Adds the item to the bin and re adjusts the binSize
        items.add(addItem);
        binSize -= addItem;
    }

    public String toString() { //toString method for printing out the Bin# and its contents
        String myString = "Bin #" + id + ": " + items;
        return myString;
    }

    public int compareTo(
            Bin myBin) { //used to compare the sizes of bins and determines which is larger or smaller
        if (binSize > myBin.binSize) {
            return 1;
        }

        else if (binSize < myBin.binSize) {
            return -1;
        }

        else {
            if (id > myBin.id) {
                return 1;
            }
            else if (id < myBin.id) {
                return -1;
            }
            else {
                return 0;
            }

        }

    }
}
