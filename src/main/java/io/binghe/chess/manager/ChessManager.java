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
package io.binghe.chess.manager;

import io.binghe.chess.piece.Chess;
import io.binghe.chess.piece.impl.*;

import java.awt.*;
import java.util.HashMap;

/**
 * @author binghe
 * @version 1.0.0
 * @description 管理器
 */
public class ChessManager {

    private HashMap<Integer, Chess> chesses = new HashMap<Integer,Chess>();
    HashMap<String, Image> imgMap=new HashMap<String, Image>();

    public ChessManager(){
        Chess a = new SoldierChess();
        chesses.put(a.getType(), a);

        Chess b =new CannonChess();
        chesses.put(b.getType(),b);

        Chess c = new CarChess();
        chesses.put(c.getType(), c);

        Chess d = new ChapChess();
        chesses.put(d.getType(), d);

        Chess e = new ElephantChess();
        chesses.put(e.getType(), e);

        Chess f = new GeneralChess();
        chesses.put(f.getType(), f);

        Chess g = new HorseChess();
        chesses.put(g.getType(), g);

    }

    /**
     * 根据类型获取象棋句柄
     */
    public Chess getChess(int type){
        if(type > 1000) type -= 1000;
        return chesses.get(type);
    }

    /**
     * 加载所有图片
     */
    public void loadAllImage() {
        for(Chess c : chesses.values()){
            Image img_black = c.getImage(true);
            Image img_red = c.getImage(false);

            imgMap.put(c.getType()+"_black", img_black);
            imgMap.put(c.getType()+"_red", img_red);
        }
    }

    /**
     * 根据类型获取图片句柄
     */
    public Image getImage(int type){
        int color = type /1000;
        type = type % 1000;
        return imgMap.get(type+(color==1?"_black":"_red"));
    }
}
