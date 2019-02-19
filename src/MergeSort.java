import java.util.Scanner;
import java.util.ArrayList;
import java.io.*;

public class MergeSort{
    public static void main(String[] main){
        String scannerFile = "nums.txt";//put in a file
        ArrayList<Integer> scanList = new ArrayList<>();
        try{
            Scanner scan = new Scanner(new BufferedReader(new FileReader((scannerFile))));
            while(scan.hasNextInt()){
                scanList.add(scan.nextInt());
            }
            scan.close();
        }
        catch(Exception e){
            System.out.println(e);
            e.printStackTrace();
        }
        scanList = sort(scanList);
        for(Integer i: scanList){
            System.out.println(i);
        }
    }
    public static ArrayList<Integer> sort(ArrayList<Integer> list){
        if(list.size() == 1){
            return list;
        }
        ArrayList<Integer> a = sort(new ArrayList(list.subList(0,list.size() / 2)));
        ArrayList<Integer> b = sort(new ArrayList(list.subList(list.size() / 2, list.size())));
        return merge(a,b);
    }
    public static ArrayList<Integer> merge(ArrayList<Integer> list1, ArrayList<Integer> list2){
        ArrayList<Integer> merged = new ArrayList<>();
        int x = 0;
        int y = 0;
        while(x < list1.size() && y < list2.size()){
                if(list1.get(x) > list2.get(y)){
                    merged.add(list2.get(y));
                    y++;
                }
                else if(list1.get(x) <= list2.get(y)) {
                    merged.add(list1.get(x));
                    x++;
                }
        }
        //Adds the rest of the list to the merged list in case of uneven list lengths
        if(x < list1.size()){
            merged.addAll(list1.subList(x, list1.size()));
        }
        if(y < list2.size()){
            merged.addAll(list2.subList(y, list2.size()));
        }
        return merged;
    }
}