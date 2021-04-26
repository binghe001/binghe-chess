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
 * @description 马
 */
public class HorseChess implements Chess {

    @Override
    public boolean check(int[][] map, int currentRow, int currentColumn, int toRow, int toColumn, boolean isBlack) {
        int columnDistance=Math.abs(currentColumn - toColumn);
        int rowDistance=Math.abs(currentRow - toRow);

        boolean success = (columnDistance ==2&&rowDistance==1)||(columnDistance ==1&&rowDistance==2);

        if(!success) return false; //如果不是日，直接失败!

        int r;//r为马脚的行坐标
        int c;//c为马脚的列坐标
        if(columnDistance==1){//走日
            r=(toRow+currentRow)/2;
            c=currentColumn;
        }
        else{//走横着的 日
            r=currentRow;
            c=(toColumn+currentColumn)/2;
        }

        if(isBlack && map[toRow][toColumn]=='G'){
            JOptionPane.showMessageDialog(null, "黑方胜利！");
            return true;
        }
        if(!isBlack && map[toRow][toColumn]==1000+'G'){
            JOptionPane.showMessageDialog(null, "红方胜利！");
            return true;
        }

        return map[r][c]==0;
    }


    @Override
    public int getType() {
        return 'H';
    }

    @Override
    public String getName() {
        return "马";
    }

    @Override
    public Image getImage(boolean isBlack) {
        return ImageTools.loadImage(isBlack?"black_h.gif":"red_h.gif");
    }
}
