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
 * @description 炮
 */
public class CannonChess implements Chess {

    @Override
    public boolean check(int[][] map, int currentRow, int currentColumn, int toRow, int toColumn, boolean isBlack) {
        int columnDistance = Math.abs(toColumn - currentColumn);
        int rowDistance = Math.abs(toRow - currentRow);
        //为 0 说明炮与目标之间没有棋子
        //为 1 说明炮与目标之间有 1个 棋子
        //为 2 说明炮与目标之间有 2个 棋子
        boolean success = (columnDistance == 0 && rowDistance != 0) || (columnDistance != 0 && rowDistance == 0);
        //如果当前走的不是直线，则返回false
        if(!success){
            return false;
        }
        int count = 0;
        int from, to;
        //如果当前棋子横着走
        if(rowDistance == 0){
            //当前棋子向右走
            if(currentColumn < toColumn){
                from = currentColumn + 1;
                to = toColumn;
            }else{  //向左走
                from = toColumn + 1;
                to = currentColumn;
            }
            for(int i = from; i < to; i++){
                if(map[currentRow][i] != 0){
                    count ++;
                }
            }
            if(map[toRow][toColumn] == 0 && count == 0){
                return true;
            }
            if(map[toRow][toColumn] == 0 && count == 1){
                return false;
            }
            //黑方对面是红方，红方对面是黑方
            if(map[toRow][toColumn] != 0 && ((isBlack && map[toRow][toColumn] < 1000) || (!isBlack && map[toRow][toColumn] > 1000)) && count == 1){
                //将军
                if(isBlack && map[toRow][toColumn] == 'G'){
                    JOptionPane.showMessageDialog(null, "黑方胜利！");
                    return true;
                }
                if(!isBlack && map[toRow][toColumn] == 1000 + 'G'){
                    JOptionPane.showMessageDialog(null, "红方胜利！");
                    return true;
                }
                return true;
            }else{
                return false;
            }
        }else{  //竖向行走
            if(currentRow < toRow){  //向下走
                from = currentRow + 1;
                to = toRow;
            }else{    //向上走
                from = toRow + 1;
                to = currentRow;
            }
            for(int i = from; i < to; i++){
                if(map[i][currentColumn] != 0){
                    count++;
                }
            }
            if(map[toRow][toColumn] == 0 && count == 0){
                return true;
            }
            if(map[toRow][toColumn] == 0 && count == 1){
                return false;
            }
            if(map[toRow][toColumn] != 0 && ((isBlack && map[toRow][toColumn] < 1000) || (!isBlack && map[toRow][toColumn] > 1000)) && count ==1){
                if(isBlack && map[toRow][toColumn] == 'G'){
                    JOptionPane.showMessageDialog(null, "黑方胜利！");
                    return true;
                }
                if(!isBlack && map[toRow][toColumn] == 1000+'G'){
                    JOptionPane.showMessageDialog(null, "红方胜利！");
                    return true;
                }
            }else{
                return false;
            }
        }
        return true;
    }

    @Override
    public int getType() {
        return 'P';
    }

    @Override
    public String getName() {
        return "炮";
    }

    @Override
    public Image getImage(boolean isBlack) {
        return ImageTools.loadImage(isBlack?"black_cannon.gif":"red_cannon.gif");
    }
}
