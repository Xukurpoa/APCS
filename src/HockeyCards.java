import java.util.Random;
import java.io.PrintWriter;

public class HockeyCards {
    public static void main(String[] args) {
        int minPackage = 0;
        int maxPackage = 0;
        int totalPackage = 0;
        boolean complete;
        int[] generatedCards = new int[7];
        int[] cards = new int[500];
        int size;
        PrintWriter writer;
        try {
            //writer = new PrintWriter("output.txt");
            for (int a = 0; a < 100; a++) {
                arrayClearer(cards);
                size = 0;
                complete = false;
                //Main loop
                while (!complete) {
                    arrayClearer(generatedCards);
                    generate(generatedCards);
                    for (int b = 0; b < 7; b++) {
                        cards[generatedCards[b]]++;
                    }
                    boolean loopFinished = true;
                    for(int i = 0; i < cards.length; i++) {
                        if (cards[i] == 0) {
                            loopFinished = false;
                        }
                    }
                    //only executes true if entire array doesn't contain a 0
                    if (loopFinished) {
                        complete = true;
                    }
                    size++;
                }
                if (size < minPackage || minPackage == 0) {
                    minPackage = size;
                }
                if (size > maxPackage) {
                    maxPackage = size;
                }
                totalPackage = totalPackage + size;
                int d = duplicate(cards);
                System.out.printf("Most Duplicated: %d Value: %d\n",d,cards[d]);
                //writer.println("Most Duplicated: " + duplicate(cards));
            }
            System.out.println("Avg: " + totalPackage / 100);
            System.out.println("Max: " + maxPackage);
            System.out.println("Min: " + minPackage);
            /*writer.println("Avg: " + totalPackage / 100);
            writer.println("Max: " + maxPackage);
            writer.println("Min: " + minPackage);
            writer.flush();
            writer.close();*/
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private static void generate(int[] cards){
        Random rand = new Random();
        int counter = 0;
        boolean bool;
        while(counter < 7){
            bool = true;
            int x = rand.nextInt(500);
            for(int i = counter; i > 0; i--){
                if(cards[i] == x){
                    bool = false;
                }
            }
            if(bool) {
                cards[counter] = x;
                counter++;
            }
        }
    }

    /**
     * Finds the index of the array with the greatest value
     * @return Index with greatest value
     */
    private static int duplicate(int[] cards){
        int check = 0;
        int val = 0;
        for(int a = 1; a < cards.length; a++){
            if(check <= cards[a]){
                check = cards[a];
                val = a;
            }
        }
        return val;
    }

    /**
     * Sets all values in the parameter array to 0
     */
    private static void arrayClearer(int[] array){
        for(int a = 0; a < array.length; a++){
            array[a] = 0;
        }
    }
}
