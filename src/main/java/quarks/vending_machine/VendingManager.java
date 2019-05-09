/*
 * Developed by GSK on 5/9/19 1:28 PM.
 * Last Modified 5/1/19 1:27 AM.
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

import javax.naming.CannotProceedException;
import java.util.List;
import java.util.Map;

public interface VendingManager {
    /**
     * To List/Display all Products.
     *
     * @return
     */
    Map<Product,Integer> listProducts();

    /**
     * Method to make payments
     *
     * @param denominations
     * @param code
     * @return
     */
    ProductDispenser makePaymentAndSelect(Map<Denominations,Integer>  denominations, int code) throws CannotProceedException;

}
