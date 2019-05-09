/*
 * Developed by GSK on 5/9/19 1:27 PM.
 * Last Modified 5/1/19 1:32 AM.
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

package quarks.vending_machine;

import quarks.vending_machine.config.Denominations;
import quarks.vending_machine.config.ProductCode;
import quarks.vending_machine.config.VendingMachine;

import javax.naming.CannotProceedException;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class DefaultVendingManager implements VendingManager {
    VendingMachine VENDING_MACHINE = VendingMachine.INSTANCE;
    AtomicBoolean vending = new AtomicBoolean();

    @Override
    public Map<Product,Integer> listProducts() {
        return VENDING_MACHINE.getProducts();
    }

    @Override
    public ProductDispenser makePaymentAndSelect(Map<Denominations,Integer> denominations, int code) throws CannotProceedException {
        if(vending.get()){
            throw new CannotProceedException("Vending in Progress..");
        }
        AtomicInteger totalPayment = new AtomicInteger();
        denominations.entrySet().stream().forEach( denomination -> {
            totalPayment.getAndAdd(denomination.getKey().getFaceValue() * denomination.getValue());
        });

        // check if valid Product
        ProductCode productCode = Arrays.stream(ProductCode.values()).filter(e -> e.getCode()==code).findAny().get();

        if (productCode == null){
            throw new CannotProceedException("Invalid Product Code");
        }

        if(totalPayment.get() < productCode.getPrice()){
            throw new CannotProceedException("Insufficient Payment");
        }

        ProductDispenser productDispenser = dispenseProduct(new Product(productCode));
        Map<Denominations,Integer> denoms = calculateBalance(totalPayment.get(), productCode.getPrice());
        productDispenser.changeCoins = denoms;
        return productDispenser;
    }

    /**
     * Dispense a selected Product.
     *
     * @param product
     * @return
     */
    private ProductDispenser dispenseProduct(Product product){
        int count = VENDING_MACHINE.getProducts().get(product);
        VENDING_MACHINE.getProducts().replace(product, --count);
        ProductDispenser productDispenser = new ProductDispenser();
        productDispenser.product = product;
        return productDispenser;
    }

   private static Map<Denominations,Integer> calculateBalance(int totalPayment, int price){
        Map<Denominations,Integer> coinMap = new EnumMap<>(Denominations.class);

        int balance = totalPayment-price;

        while(balance>0){
            int coinCount = 0;
            if(balance>=Denominations.QUARTER.getFaceValue()){
                coinCount=balance/Denominations.QUARTER.getFaceValue();
                balance=balance%Denominations.QUARTER.getFaceValue();
                if(coinMap.containsKey(Denominations.QUARTER)){
                    coinCount+=coinMap.get(Denominations.QUARTER);
                }
                coinMap.put(Denominations.QUARTER,coinCount);
            }
            if(balance>=Denominations.DIME.getFaceValue()){
                coinCount=balance/Denominations.DIME.getFaceValue();
                balance=balance%Denominations.DIME.getFaceValue();
                if(coinMap.containsKey(Denominations.DIME)){
                    coinCount+=coinMap.get(Denominations.DIME);
                }
                coinMap.put(Denominations.DIME,coinCount);
            }
            if(balance>=Denominations.NICKEL.getFaceValue()){
                coinCount=balance/Denominations.NICKEL.getFaceValue();
                balance=balance%Denominations.NICKEL.getFaceValue();
                if(coinMap.containsKey(Denominations.NICKEL)){
                    coinCount+=coinMap.get(Denominations.NICKEL);
                }
                coinMap.put(Denominations.NICKEL,coinCount);
            }
            if(balance>=Denominations.PENNY.getFaceValue()){
                coinCount=balance/Denominations.PENNY.getFaceValue();
                balance=balance%Denominations.PENNY.getFaceValue();
                if(coinMap.containsKey(Denominations.PENNY)){
                    coinCount+=coinMap.get(Denominations.PENNY);
                }
                coinMap.put(Denominations.PENNY,coinCount);
            }
        }
        return coinMap;
    }

}
