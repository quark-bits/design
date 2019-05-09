/*
 * Developed by GSK on 5/9/19 1:25 PM.
 * Last Modified 4/30/19 5:18 PM.
 * Copyright (c) 2019.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package quarks.problems;

import java.util.EnumMap;
import java.util.Map;

public class CoinChange {
    static final int CUSTOMER_PAY = 100;

    public static void main(String[] args) {
        Map<Denomination,Integer> coinMap = buy(15);

        coinMap.keySet().stream().forEach(e -> {
           System.out.println(e +"=="+coinMap.get(e));
        });

    }

    private static Map<Denomination,Integer> buy(int price){
        Map<Denomination,Integer> coinMap = new EnumMap<>(Denomination.class);

        int balance = CUSTOMER_PAY-price;

        while(balance>0){
            int coinCount = 0;
            if(balance>=Denomination.QUARTER.value){
                coinCount=balance/Denomination.QUARTER.value;
                balance=balance%Denomination.QUARTER.value;
                if(coinMap.containsKey(Denomination.QUARTER)){
                    coinCount+=coinMap.get(Denomination.QUARTER);
                }
                coinMap.put(Denomination.QUARTER,coinCount);
            }
            if(balance>=Denomination.DIME.value){
                coinCount=balance/Denomination.DIME.value;
                balance=balance%Denomination.DIME.value;
                if(coinMap.containsKey(Denomination.DIME)){
                    coinCount+=coinMap.get(Denomination.DIME);
                }
                coinMap.put(Denomination.DIME,coinCount);
            }
            if(balance>=Denomination.NICKEL.value){
                coinCount=balance/Denomination.NICKEL.value;
                balance=balance%Denomination.NICKEL.value;
                if(coinMap.containsKey(Denomination.NICKEL)){
                    coinCount+=coinMap.get(Denomination.NICKEL);
                }
                coinMap.put(Denomination.NICKEL,coinCount);
            }
            if(balance>=Denomination.PENNY.value){
                coinCount=balance/Denomination.PENNY.value;
                balance=balance%Denomination.PENNY.value;
                if(coinMap.containsKey(Denomination.PENNY)){
                    coinCount+=coinMap.get(Denomination.PENNY);
                }
                coinMap.put(Denomination.PENNY,coinCount);
            }
        }
        return coinMap;
    }

}

 enum Denomination{
    QUARTER(25),
    DIME(10),
    NICKEL(5),
    PENNY(1);

    int value;
     Denomination(int value) {
         this.value = value;
     }
 }
