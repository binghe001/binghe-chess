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
 * @description 士兵与卒的棋子
 */
public class SoldierChess implements Chess {

    @Override
    public boolean check(int[][] map, int currentRow, int currentColumn, int toRow, int toColumn, boolean isBlack) {
        int columnDistance = toColumn - currentColumn;
        int rowDistance = toRow - currentRow;
        //黑色棋子
        if(isBlack){
            //当前棋子未过河，只能向下移动一格
            if(currentRow <= 4){
                //如果是向下移动一格，则返回true，否则，返回false
                return (columnDistance == 0 && rowDistance == 1);
            }
            //当前棋子已经过河
            columnDistance = Math.abs(toColumn - currentColumn);
            //如果当前棋子已经过河，则前进一格，可以横向移动
            boolean success = (columnDistance == 1 && rowDistance == 0) || (rowDistance == 1 && columnDistance == 0);
            //如果不是向下，向左或向右移动，则失败
            if(!success){
                return false;
            }
            if(map[toRow][toColumn] == 'G'){
                JOptionPane.showMessageDialog(null, "黑方胜利！");
            }
            return true;
        }else{  //红色棋子
            if(currentRow >= 5){  //红色棋子未过河
                //红色棋子未过河，只能向上走
                return (columnDistance == 0 && rowDistance == -1);
            }
            //当前棋子已经过河
            columnDistance = Math.abs(toColumn - currentColumn);
            //红卒过河后向上、向左、向右移动
            boolean success = (columnDistance == 1 && rowDistance == 0) || (rowDistance == -1 && columnDistance == 0);
            if(!success){
                return false;
            }
            if(map[toRow][toColumn] == 1000 + 'G'){
                JOptionPane.showMessageDialog(null, "红方胜利！");
            }
            return true;
        }
    }

    @Override
    public int getType() {
        return 'A';
    }

    @Override
    public String getName() {
        return "卒";
    }

    @Override
    public Image getImage(boolean isBlack) {
        return ImageTools.loadImage(isBlack?"black_soldier.gif":"red_soldier.gif");
    }
}
