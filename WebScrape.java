<<<<<<< HEAD
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webscrape;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.text.DecimalFormat;

/**
 *
 * @author Anish Madan
 */
public class WebScrape {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException{
        String cryptos[] = {"bitcoin","ethereum","ripple","litecoin","dogecoin"};
        double crypto_val[] = new double[cryptos.length];
        DecimalFormat cash = new DecimalFormat("$#,###,##0.00####");
        URL url = new URL("https://coinmarketcap.com/currencies/bitcoin/");
        URLConnection urlConn = url.openConnection();
        InputStreamReader inStream = new InputStreamReader(urlConn.getInputStream());
        BufferedReader buff = new BufferedReader(inStream);
        
        double price = 0;
        int start = 0;
        int end = 0;
        System.out.println("1 Coffee = $5");
        double coffeePrice = 5;
        //finding crypto values
        for(int i = 0; i < cryptos.length; i++){
            url = new URL("https://coinmarketcap.com/currencies/" + cryptos[i] +  "/");
            urlConn = url.openConnection();
            inStream = new InputStreamReader(urlConn.getInputStream());
            buff = new BufferedReader(inStream);
            String line = buff.readLine();
            while(line!=null){
                if(line.contains("data-currency-value>")){
                    end = line.indexOf("/") - 1;
                    start = line.indexOf(">") + 1;
                    price = Double.parseDouble(line.substring(start, end));
                    break;
                }
                line = buff.readLine();
            }
            crypto_val[i] = price;
        }
        
        //class='uccResultAmount
        url = new URL("http://www.xe.com/currencyconverter/convert/?Amount=1&From=USD&To=CAD");
        urlConn = url.openConnection();
        inStream = new InputStreamReader(urlConn.getInputStream());
        buff = new BufferedReader(inStream);
        String line = buff.readLine();
        while(line!=null){
            if(line.contains("class='uccResultAmount")){
                end = line.indexOf("</span><span class='uccToCurrencyCode'>") - 1;
                start = line.indexOf("<span class='uccResultAmount'>") + "<span class='uccResultAmount'>".length();
                price = Double.parseDouble(line.substring(start, end));
                break;
            }
            line = buff.readLine();
        }
        
        double USD_to_CAD = price;
        System.out.println(USD_to_CAD);
        
        PrintWriter writer = new PrintWriter("File.txt", "UTF-8");

        for(int i = 0; i < cryptos.length; i++){
            writer.println(cryptos[i] + ": " + crypto_val[i] * USD_to_CAD + " CAD");
            writer.println(" Coffee: " + coffeePrice/(crypto_val[i] * USD_to_CAD) + " " + cryptos[i]);
        }
        writer.close();        
    }    
}
=======
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webscrape;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.text.DecimalFormat;

/**
 *
 * @author Anish Madan
 */
public class WebScrape {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException{
        String cryptos[] = {"bitcoin","ethereum","ripple","litecoin","dogecoin"};
        double crypto_val[] = new double[cryptos.length];
        DecimalFormat cash = new DecimalFormat("$#,###,##0.00####");
        URL url = new URL("https://coinmarketcap.com/currencies/bitcoin/");
        URLConnection urlConn = url.openConnection();
        InputStreamReader inStream = new InputStreamReader(urlConn.getInputStream());
        BufferedReader buff = new BufferedReader(inStream);
        
        double price = 0;
        int start = 0;
        int end = 0;
        System.out.println("1 Coffee = $5");
        double coffeePrice = 5;
        //finding crypto values
        for(int i = 0; i < cryptos.length; i++){
            url = new URL("https://coinmarketcap.com/currencies/" + cryptos[i] +  "/");
            urlConn = url.openConnection();
            inStream = new InputStreamReader(urlConn.getInputStream());
            buff = new BufferedReader(inStream);
            String line = buff.readLine();
            while(line!=null){
                if(line.contains("data-currency-value>")){
                    end = line.indexOf("/") - 1;
                    start = line.indexOf(">") + 1;
                    price = Double.parseDouble(line.substring(start, end));
                    break;
                }
                line = buff.readLine();
            }
            crypto_val[i] = price;
        }
        
        //class='uccResultAmount
        url = new URL("http://www.xe.com/currencyconverter/convert/?Amount=1&From=USD&To=CAD");
        urlConn = url.openConnection();
        inStream = new InputStreamReader(urlConn.getInputStream());
        buff = new BufferedReader(inStream);
        String line = buff.readLine();
        while(line!=null){
            if(line.contains("class='uccResultAmount")){
                end = line.indexOf("</span><span class='uccToCurrencyCode'>") - 1;
                start = line.indexOf("<span class='uccResultAmount'>") + "<span class='uccResultAmount'>".length();
                price = Double.parseDouble(line.substring(start, end));
                break;
            }
            line = buff.readLine();
        }
        
        double USD_to_CAD = price;
        System.out.println(USD_to_CAD);
        
        PrintWriter writer = new PrintWriter("File.txt", "UTF-8");

        for(int i = 0; i < cryptos.length; i++){
            writer.println(cryptos[i] + ": " + crypto_val[i] * USD_to_CAD + " CAD");
            writer.println(" Coffee: " + coffeePrice/(crypto_val[i] * USD_to_CAD) + " " + cryptos[i]);
        }
        writer.close();
        
    }
    
}
>>>>>>> 7589a36541030e37507e08ca9e4ff6a536b74170
