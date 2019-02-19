public class Abundance {
    public static void main(String[] args){
        int counter = 0;
        for(int number = 3; number <= 10000; number+=2){
            int factor = 0;
            for(int sub = 2; sub <= number /2; sub++){
                if(number % sub == 0){
                    factor = factor + sub;
                }
            }
            if(factor > number){
                System.out.println(number);
                counter++;
            }
        }
        System.out.println("Total: "+counter);
    }
}
