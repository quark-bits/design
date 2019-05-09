/*
 * Developed by GSK on 5/9/19 1:26 PM.
 * Last Modified 5/1/19 9:20 PM.
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
import java.util.Scanner;

public class PlaySnakeLadder {
    public static void main(String[] args) throws Exception {

        SnakeLadderConfig snakeLadderConfig = SnakeLadderConfig.INSTANCE_8x8;

        System.out.println("SNAKE_FROM_TO");
        snakeLadderConfig
                .snakeMap
                .entrySet()
                .stream()
                .forEach(e -> System.out.println(e.getKey() + " -> "+ e.getValue()));

        System.out.println("LADDER_FROM_TO");
        snakeLadderConfig
                .ladderMap
                .entrySet()
                .stream()
                .forEach(e -> System.out.println(e.getKey() + " -> "+ e.getValue()));


        System.out.println("Enter number of Players:");
        Scanner in = new Scanner(System.in);
        int players = in.nextInt();

        if(players <=0 || players>4){
            throw new Exception("Insufficient Players or Exceeded...");
        }

        Map<Integer,String> nameMap = new HashMap<>(players);

        SnakeLadderBoard snakeLadderBoard = new DefaultSnakeLadderBoard(players,snakeLadderConfig);
        for(int i=1;i<=players;i++){
            System.out.println("Enter Name for Player "+i);
            String playerName = in.next();
            snakeLadderBoard.addPlayer(playerName);
            nameMap.put(i,playerName);
        }

        in.nextLine();
        Random random = new Random();

        while (true){
            int i;
            for(i = 1; i<=players; i++){
                System.out.println();
                System.out.println(nameMap.get(i)+ " It's your turn to Play..Press Enter/Return..");
                in.nextLine();
                int dice = random.nextInt(5)+1;
                int position = snakeLadderBoard.play(nameMap.get(i),dice);
                System.out.println("You Got "+dice + " and you are now at "+ position);
            }
            i=1;
        }


    }



}
