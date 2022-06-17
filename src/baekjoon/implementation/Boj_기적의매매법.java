package baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_기적의매매법 {
    static final int period = 14;
    static class Person {
        int hasCash;
        int hasStock;

        public Person(int hasCash, int hasStock) {
            this.hasCash = hasCash;
            this.hasStock = hasStock;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int cash = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        Person junhyun = new Person(cash, 0);
        Person sungmin = new Person(cash, 0);

        int downCheck = 0;
        int upCheck = 0;
        int pre = 0;
        int stockValue = 0;
        for (int i = 0; i < period; i++) {
            stockValue = Integer.parseInt(st.nextToken());
            if (i != 0) {
                if (pre > stockValue) {
                    downCheck++;
                    upCheck = 0;
                }
                else if(pre < stockValue) {
                    upCheck++;
                    downCheck = 0;
                }
            }

            if (downCheck == 3 || upCheck == 3) {
                buyStocksIn33Way(stockValue, sungmin, upCheck);
                upCheck = 0; downCheck = 0;
            }
            buyStocksInBNP(stockValue, junhyun);
            pre = stockValue;
        }

        int totalValueSung = (sungmin.hasStock * stockValue) + sungmin.hasCash;
        int totalValueJun = (junhyun.hasStock * stockValue) + junhyun.hasCash;

        if (totalValueSung == totalValueJun) {
            System.out.println("SAMESAME");
        }else if (totalValueSung > totalValueJun) {
            System.out.println("TIMING");
        }else {
            System.out.println("BNP");
        }
    }
    // 33방식
    private static void buyStocksIn33Way(int stockValue, Person sungmin, int up) {
        if (up == 3) {
            // selling
            int hasStocks = sungmin.hasStock;
            sungmin.hasStock = 0;
            sungmin.hasCash += (hasStocks * stockValue);
        }else {
            // buying
            if (sungmin.hasCash != 0) {
                int buyingStocks = sungmin.hasCash / stockValue;
                sungmin.hasStock += buyingStocks;
                sungmin.hasCash -= (stockValue * buyingStocks);
            }
        }
    }
    // BNP
    private static void buyStocksInBNP(int stockValue, Person junhyun) {
        if (junhyun.hasCash != 0) {
            int buyingStocks = junhyun.hasCash / stockValue;
            junhyun.hasStock += buyingStocks;
            junhyun.hasCash -= (stockValue * buyingStocks);
        }
    }
}
