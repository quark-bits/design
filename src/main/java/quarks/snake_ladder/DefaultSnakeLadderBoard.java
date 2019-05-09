/*
 * Developed by GSK on 5/9/19 1:26 PM.
 * Last Modified 5/1/19 3:56 AM.
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

public class DefaultSnakeLadderBoard implements SnakeLadderBoard{
    Map<String,Integer> playerPosition;
    SnakeLadderConfig snakeLadderConfig;
    Map<String,String> playerTrail;

    public DefaultSnakeLadderBoard(int players, SnakeLadderConfig snakeLadderConfig) {
        this.playerPosition = new HashMap<>(players);
        this.playerTrail = new HashMap<>(players);
        this.snakeLadderConfig = snakeLadderConfig;
    }

    @Override
    public void addPlayer(String playerName) {
        playerPosition.put(playerName,0);
        playerTrail.put(playerName,"");
    }

    @Override
    public int play(String playerName, int dice) throws WinnerException {
        int currentPosition = playerPosition.get(playerName);
        int newPosition = currentPosition+dice;

        // if new position has snake.
        if(snakeLadderConfig.snakeMap.containsKey(newPosition)){
            newPosition = snakeLadderConfig.snakeMap.get(newPosition);
            playerTrail.put(playerName,playerTrail.get(playerName).concat("-D-").concat(String.valueOf(newPosition)));
        }

        // if new position has ladder.
        if(snakeLadderConfig.ladderMap.containsKey(newPosition)){
            newPosition = snakeLadderConfig.ladderMap.get(newPosition);
            playerTrail.put(playerName,playerTrail.get(playerName).concat("-U-").concat(String.valueOf(newPosition)));
        }
        playerPosition.put(playerName,newPosition);
        playerTrail.put(playerName,playerTrail.get(playerName).concat("->").concat(String.valueOf(newPosition)));

        if(newPosition >= snakeLadderConfig.winningPosition){
            playerTrail.entrySet().stream().forEach(e -> {
                System.out.println(e.getKey() + " has Trail " + e.getValue());
            });

            throw new WinnerException(playerName);
        }
        return newPosition;
    }
}
