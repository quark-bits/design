/*
 * Developed by GSK on 5/9/19 1:27 PM.
 * Last Modified 5/1/19 1:38 AM.
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

import quarks.vending_machine.config.ProductCode;

import java.util.Objects;

/**
 *
 */
public class Product {
    ProductCode productCode;
    String name;

    public Product(ProductCode productCode) {
        this.productCode = productCode;
        this.name = productCode.name();
    }

    public Product(ProductCode productCode, String name) {
        this.productCode = productCode;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;
        Product product = (Product) o;
        return productCode == product.productCode;
    }

    @Override
    public int hashCode() {
        return Objects.hash(productCode);
    }
}