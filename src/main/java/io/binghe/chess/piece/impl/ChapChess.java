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
 * @description 士
 */
public class ChapChess implements Chess {
    @Override
    public boolean check(int[][] map, int currentRow, int currentColumn, int toRow, int toColumn, boolean isBlack) {
        int columnDistance = Math.abs(currentColumn - toColumn);
        int rowDistance = Math.abs(currentRow - toRow);
        boolean success;
        if(isBlack){//黑士
            //如果不是一条斜线，直接失败,还要保证目标位置没有棋子
            success = columnDistance==1 && rowDistance==1 && (toRow>=0 && toRow <= 2 && toColumn >= 3 && toColumn <= 5);
        }
        else{//红士
            //如果不是一条斜线，直接失败
            success = columnDistance==1 && rowDistance==1 &&(toRow >= 7 && toRow <= 9 && toColumn >= 3 && toColumn <= 5);
        }
        return success;
    }

    @Override
    public int getType() {
        return 'S';
    }

    @Override
    public String getName() {
        return "士";
    }

    @Override
    public Image getImage(boolean isBlack) {
        return ImageTools.loadImage(isBlack?"black_s.gif":"red_s.gif");
    }
}
