/*
 * Developed by GSK on 5/9/19 1:27 PM.
 * Last Modified 5/8/19 2:46 PM.
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

package quarks.tic_tac_toe;

import java.util.HashMap;
import java.util.Map;

public enum TicTacToeConfig {
    INSTANCE;

    char[][] ticTacGrid ;
    Map<Integer,Integer[]> postionToMatrixMapping;

    TicTacToeConfig() {
        this.ticTacGrid = new char[3][3];
        postionToMatrixMapping = new HashMap<>();
        postionToMatrixMapping.put(1,new Integer []{0,0});
        postionToMatrixMapping.put(2,new Integer []{0,1});
        postionToMatrixMapping.put(3,new Integer []{0,2});
        postionToMatrixMapping.put(4,new Integer []{1,0});
        postionToMatrixMapping.put(5,new Integer []{1,1});
        postionToMatrixMapping.put(6,new Integer []{1,2});
        postionToMatrixMapping.put(7,new Integer []{2,0});
        postionToMatrixMapping.put(8,new Integer []{2,1});
        postionToMatrixMapping.put(9,new Integer []{2,2});
    }

    // Possible values for Tic-Tac-Toe
    enum TicTacToeValue{
        X('X'),
        O('O');
        private final char tictacChar;

        TicTacToeValue(char c) {
            this.tictacChar = c;
        }

        public char getTictacChar() {
            return tictacChar;
        }
    }
}
