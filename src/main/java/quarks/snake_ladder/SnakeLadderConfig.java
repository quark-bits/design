/*
 * Developed by GSK on 5/9/19 1:26 PM.
 * Last Modified 5/1/19 3:51 AM.
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

package quarks.snake_ladder;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public enum SnakeLadderConfig {
    INSTANCE_5x5(5),
    INSTANCE_8x8(8),
    INSTANCE_10x10(10);

    Map<Integer,Integer> snakeMap;
    Map<Integer,Integer> ladderMap;

    int winningPosition;

    // Initialize Board with Snake/Ladders
    SnakeLadderConfig(int boardSize) {
        snakeMap = new HashMap<>(boardSize);
        ladderMap = new HashMap<>(boardSize);

        winningPosition = boardSize*boardSize;

        int snakeCount=0;
        while(snakeCount<boardSize/2){
            Random random = new Random();
            int fromRand = random.nextInt((boardSize*boardSize)-1)+1;
            int toRand = random.nextInt((boardSize*boardSize)-1)+1;

            if(fromRand > toRand && fromRand != winningPosition){
                snakeMap.put(fromRand,toRand);
                snakeCount++;
            }
        }

        int ladderCount=0;
        while (ladderCount<boardSize){
            Random random = new Random();
            int fromRand = random.nextInt((boardSize*boardSize)-1)+1;
            int toRand = random.nextInt((boardSize*boardSize)-1)+1;

            if(fromRand < toRand){
                if(!snakeMap.containsKey(fromRand)
                        && !snakeMap.containsKey(toRand)
                        && !snakeMap.containsValue(fromRand)
                        && !snakeMap.containsValue(toRand)){
                    ladderMap.put(fromRand,toRand);
                    ladderCount++;
                }
            }
        }
    }
}
