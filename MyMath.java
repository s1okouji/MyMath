import java.lang.*;
import java.util.*;
import java.io.*;

public class MyMath {
    private static Mode mode;
    public static void main(String args[]){

        List<Double> list = new ArrayList<>();

        if(args.length == 1) mode = Mode.v;
        if(args.length == 2){
            switch(args[0]){
                case "v": mode = Mode.v; break;
                case "avg": mode = Mode.avg; break;
            }
        }
        if(args.length >= 3){
            System.err.println("Invalid args. java MyMath <mode> <csv file>");
            return ;
        }

        // Input

        try {
            File file = new File(args[1]);
            FileReader reader = new FileReader(file);
            BufferedReader bf = new BufferedReader(reader);
            String line;
            while((line = bf.readLine()) != null){
                line = line.replace(",","");
                list.add(Double.parseDouble(line));
            }

        }catch (IOException e){
            e.printStackTrace();
        }


        if(mode == Mode.avg){
            System.out.println(getAvg(list));
        }
        if(mode == Mode.v){
            System.out.println(getV(list));
        }
    }

    public static double getV(List<Double> list){
        double ans = 0;
        double avg = getAvg(list);
        for(Double p:list){
            ans += (p - avg) * (p - avg);            
        }
        ans /= list.size();
        return ans;
    }
    public static double getAvg(List<Double> list){
        double ans = 0;
        for(double p : list){
            ans += p;
        }
        ans /= list.size();

        return ans;
    }
}

enum Mode{
    v,
    avg,
};