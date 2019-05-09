/*
 * Developed by GSK on 5/9/19 1:25 PM.
 * Last Modified 5/9/19 1:22 PM.
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

public class DefaultTicTacToe  implements TicTacToe{

    TicTacToeConfig ticTacToeConfig = TicTacToeConfig.INSTANCE;

    @Override
    public void markPosition(TicTacToeConfig.TicTacToeValue ticTacToeValue, int position) {
        char[][] tttGrid = ticTacToeConfig.ticTacGrid;
        Integer[] gridPosition = ticTacToeConfig.postionToMatrixMapping.get(position);
        tttGrid[gridPosition[0]][gridPosition[1]] = ticTacToeValue.getTictacChar();
    }

    private boolean checkIfComplete(char[][] tttGrid){
        boolean complete = false;
        //TODO: Implement logic to find if its complete?

        return complete;
    }
}
