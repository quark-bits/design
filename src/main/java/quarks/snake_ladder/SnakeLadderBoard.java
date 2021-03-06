/*
 * Developed by GSK on 5/9/19 1:26 PM.
 * Last Modified 5/1/19 2:52 AM.
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

public interface SnakeLadderBoard {
    /**
     * Add Player
     *
     * @param playerName
     */
    void addPlayer(String playerName);


    /**
     *
     * @param playerName
     * @return
     */
    int play(String playerName, int dice) throws WinnerException;

}
