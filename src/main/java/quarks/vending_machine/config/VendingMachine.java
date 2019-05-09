/*
 * Developed by GSK on 5/9/19 1:27 PM.
 * Last Modified 4/30/19 11:47 PM.
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

package quarks.vending_machine.config;

import quarks.vending_machine.Product;

import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public enum VendingMachine {
    INSTANCE;

    Map<Product,Integer> products;
    static final int DEFAULT_COUNT = 10;

    VendingMachine() {
        loadProducts();
    }

    /**
     *  Initialization Method.
     *  This is to load Products onto Vending Machine.
     */
    private void loadProducts(){
        products = new ConcurrentHashMap<>();
        Arrays.stream(ProductCode.values()).forEach( e -> {
            products.put(new Product(e,e.name()),DEFAULT_COUNT);
        });
    }

    public Map<Product,Integer> getProducts(){
        return products;
    }

    /**
     * Reset - will Reload Products
     */
    public void reset(){
        loadProducts();
    }
}
