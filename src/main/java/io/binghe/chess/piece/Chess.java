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
package io.binghe.chess.piece;

import java.awt.*;

/**
 * @author binghe
 * @version 1.0.0
 * @description 基础的棋子接口
 */
public interface Chess {

    /**
     * 检查落子是否合法
     * @param map 地图
     * @param currentRow 当前棋子的行号
     * @param currentColumn 当前棋子的列号
     * @param toRow  移动的目标行号
     * @param toColumn  移动的目标列号
     * @param isBlack 是否为黑方棋子移动 传true 否则传false
     * @return 如果合法，返回true, 否则返回false
     */
    boolean check(int[][] map,int currentRow, int currentColumn ,int toRow, int toColumn, boolean isBlack);

    /**
     * 返回类型
     */
    int getType();

    /**
     * 返回名称
     */
    String getName();

    /**
     * 返回颜色信息
     */
    Image getImage(boolean isBlack);
}
