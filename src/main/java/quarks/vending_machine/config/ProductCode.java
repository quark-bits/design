/*
 * Developed by GSK on 5/9/19 1:27 PM.
 * Last Modified 5/1/19 1:04 AM.
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

/**
 *  Provides Product Code for selection along with the Price of each product.
 */
public enum ProductCode {
    PEPSI(10,25),
    COKE(20,35),
    SODA(30,40);

    int code;
    int price;


    ProductCode(int code) {
        this.code = code;
    }

    ProductCode(int code, int price) {
        this.code = code;
        this.price = price;
    }

    public int getCode() {
        return code;
    }

    public int getPrice() {
        return price;
    }

}
