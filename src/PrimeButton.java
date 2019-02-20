import java.util.ArrayList;

/**
 * @author Tomasz Mroz
 * Everytime the button is pushed it outputs the next prime number from 2 to 10000
 */
public class PrimeButton implements Button{
    ArrayList<Integer> ints = new ArrayList<>();
    private int index = 0;
    public void push(){
        index++;
    }
    public String state() {
        return ints.get(index).toString();
    }
    public PrimeButton(){
        for(int i = 1; i < 10000; i++){
            boolean b = true;
            for(int a = 2; a <= i/2; a++){
                if(i % a == 0){
                    b = false;
                }
            }
            if(b){
                ints.add(i);
            }
        }
    }
}

