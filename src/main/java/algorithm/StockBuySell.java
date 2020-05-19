package algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.System.out;

class Interval{
    int buy,sell;

    @Override
    public String toString() {
        return ("Buy on : "+buy+"\t"+"Sell on : "+sell);
    }
}

public class StockBuySell {

    List<Interval> stockBuySell(int priceInput[]){

        int cheapestCost = priceInput[0];
        int cheapestCostDay =0;
        int maxDiff = priceInput[1]-priceInput[0];
        List<Interval> list = new ArrayList<Interval>();
        for(int i=0;i<priceInput.length;i++){
            if(priceInput[i]-cheapestCost > maxDiff){
                maxDiff = priceInput[i]-cheapestCost;
                Interval obj = new Interval();
                obj.buy = i;
                obj.sell = cheapestCostDay;
                list.add(obj);
            }
            if(priceInput[i]<cheapestCost)
                cheapestCost = priceInput[i];
                cheapestCostDay = i;
        }
        return list;
    }

    public static void main(String [] a){

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] priceInput = new int[n];
        for(int i=0;i<n;i++)
            priceInput[i] = sc.nextInt();

        StockBuySell obj = new StockBuySell();
        List<Interval> list = obj.stockBuySell(priceInput);

        list.stream().forEach(out::println);
    }
}
