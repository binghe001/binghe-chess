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
 * @description 将
 */
public class GeneralChess implements Chess {

    @Override
    public boolean check(int[][] map, int currentRow, int currentColumn, int toRow, int toColumn, boolean isBlack) {
        int columnDistance = Math.abs(currentColumn - toColumn);
        int rowDistance = Math.abs(currentRow - toRow);

        boolean success;
        int count=0;
        int min_r= currentRow < toRow ? currentRow : toRow;
        int max_r = currentRow > toRow ? currentRow : toRow;
        for(int i = min_r + 1; i < max_r; i++){
            if(columnDistance==0 && map[i][currentColumn]!=0){
                count=1;
                return false;
            }
        }

        if(isBlack){//黑将
            //如果是一条斜线，直接失败
            //目标为红将，且之间没有棋子，移动
            if(map[toRow][toColumn] == 'G' && count==0){
                JOptionPane.showMessageDialog(null, "黑方胜利");
                return true;
            }
            success = ((columnDistance==1 && rowDistance==0)||(columnDistance==0 && rowDistance==1)) &&(toRow >= 0 && toRow <= 2 && toColumn >= 3 && toColumn <= 5);
        }
        else{//红帅
            if(map[toRow][toColumn] == 1000 + 'G' && count==0){
                JOptionPane.showMessageDialog(null, "红方胜利");
                return true;
            }
            success = ((columnDistance==1 && rowDistance==0)||(columnDistance==0 && rowDistance == 1)) &&(toRow >= 7 && toRow <= 9 && toColumn >= 3 && toColumn <= 5);
        }
        return success;
    }

    @Override
    public int getType() {
        return 'G';
    }

    @Override
    public String getName() {
        return "将";
    }

    @Override
    public Image getImage(boolean isBlack) {
        return ImageTools.loadImage(isBlack?"black_g.gif":"red_g.gif");
    }
}
