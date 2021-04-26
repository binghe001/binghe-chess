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
package io.binghe.chess.check;

/**
 * @author binghe
 * @version 1.0.0
 * @description 范围校验
 */
public class RangeChecker {

    // 1  r和c 是不是合法的
    // 2 目标位置是否已经有其它棋子，如果有敌方棋子可以走，有己方不可走
    public static boolean inRange(int[][] map,int p_r,int p_c, int r, int c, boolean isBlack){
        if(r<0 || r>9 || c< 0 || c>9) return false;
        if(map[r][c] == 0){//目标位置没有棋子,走棋
            return false;
        }else{//目标位置有棋子   判断是否为友方！友方不可走，敌对方可走。
            if(map[r][c]<1000 && map[p_r][p_c] > 1000){//红方，之前的是黑方。 结果是敌方   可以走棋
                return true;
            }else if(map[r][c]>1000 && map[p_r][p_c] < 1000){//黑方，之前的是红方，结果是敌方   不可走棋
                return true;
            }else{
                return false;
            }
        }
    }

    public static boolean selectInRange(int[][] map, int r, int c,boolean isBlack) {
        //下表在范围内，且当前点由自己放的棋子可以， 否则不可以。
        if(r<0 || r>9 || c< 0 || c>9) return false;
        if(map[r][c] == 0) return true;
        return (isBlack && map[r][c] > 1000) ||  (!isBlack && map[r][c]<1000);
    }
}
