/*
 * Developed by GSK on 5/9/19 1:27 PM.
 * Last Modified 5/1/19 1:39 AM.
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
import quarks.vending_machine.config.VendingMachine;

import javax.naming.CannotProceedException;
import java.util.HashMap;
import java.util.Map;

public class VendingExample {
    public static void main(String[] args) throws CannotProceedException {
        VendingMachine VENDING_MACHINE = VendingMachine.INSTANCE;
        Map<Product,Integer> products = VENDING_MACHINE.getProducts();
        products.entrySet().stream().forEach(product ->
                System.out.println(product.getKey().name+"-"+product.getKey().productCode.getCode()+"="+product.getValue()));


        VendingManager vendingManager = new DefaultVendingManager();

        // Buy Pepsi
        Map<Denominations,Integer>  denominations = new HashMap<>();
        denominations.put(Denominations.QUARTER,1);
        denominations.put(Denominations.DIME,3);

        ProductDispenser productDispenser = vendingManager.makePaymentAndSelect(denominations,20);

        System.out.println("Dispensed_Product="+productDispenser.product.name);
        productDispenser.changeCoins.entrySet().stream().forEach( e ->
                System.out.println(e.getKey().getFaceValue() + "-" + e.getValue()));

    }
}
