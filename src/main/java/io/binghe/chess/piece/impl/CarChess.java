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

import javax.swing.*;
import java.awt.*;

/**
 * @author binghe
 * @version 1.0.0
 * @description 车
 */
public class CarChess implements Chess {
    @Override
    public boolean check(int[][] map, int currentRow, int currentColumn, int toRow, int toColumn, boolean isBlack) {
        int columnDistance = Math.abs(currentColumn - toColumn);
        int rowDistance = Math.abs(currentRow - toRow);
        boolean success = (columnDistance == 0 && rowDistance != 0 )||(columnDistance != 0 && rowDistance == 0 );//如果不是单条线，直接失败
        if(!success) return false;

        int from,to;
        if(rowDistance == 0){//横着走
            if(currentColumn < toColumn){//向右走
                from = currentColumn + 1 ;
                to = toColumn;
            }else{
                from = currentColumn - 1;
                to = toColumn;
            }
            for(int i=from;i<to;i++){
                ////中间有棋子，失败！！
                if(map[currentRow][i] != 0){
                    return false;
                }
            }
        }else{ //竖着走
            if(currentRow < toRow){//向上走
                from = toRow;
                to = currentRow - 1;
            }else{//向下走
                from = currentRow + 1;
                to = toRow;
            }
            for(int i=from;i<to;i++){
                if(map[i][currentColumn] != 0 )return false; //中间有棋子，失败！！
            }

        }

        if(isBlack && map[toRow][toColumn] == 'G'){
            JOptionPane.showMessageDialog(null, "黑方胜利！");
            return true;
        }
        if(!isBlack && map[toRow][toColumn] == 1000+'G'){
            JOptionPane.showMessageDialog(null, "红方胜利！");
            return true;
        }
        return true;
    }

    @Override
    public int getType() {
        return 'C';
    }

    @Override
    public String getName() {
        return "车";
    }

    @Override
    public Image getImage(boolean isBlack) {
        return ImageTools.loadImage(isBlack?"black_car.gif":"red_car.gif");
    }
}
