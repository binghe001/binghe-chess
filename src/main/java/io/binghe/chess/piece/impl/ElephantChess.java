/**
 * Copyright 2020-9999 the original author or authors.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.binghe.chess.piece.impl;

import io.binghe.chess.piece.Chess;
import io.binghe.chess.utils.ImageTools;

import java.awt.*;

/**
 * @author binghe
 * @version 1.0.0
 * @description 象
 */
public class ElephantChess implements Chess {

    @Override
    public boolean check(int[][] map, int currentRow, int currentColumn, int toRow, int toColumn, boolean isBlack) {
        int columnDistance = Math.abs(currentColumn - toColumn);
        int rowDistance = Math.abs(currentRow - toRow);

        boolean success =  columnDistance  == 2 && rowDistance == 2;

        if(!success ) return false; //如果不是田，直接失败！

        int c = (currentColumn + toColumn) / 2;
        int r = (currentRow + toRow) / 2;
        if(isBlack){//黑象
            return map[r][c] == 0 && toRow <= 4;//象不能过河
        }
        else{//红象
            return map[r][c] == 0&& toRow >= 5;//象不能过河
        }
    }

    @Override
    public int getType() {
        return 'E';
    }

    @Override
    public String getName() {
        return "象";
    }

    @Override
    public Image getImage(boolean isBlack) {
        return ImageTools.loadImage(isBlack?"black_e.gif":"red_e.gif");
    }
}
