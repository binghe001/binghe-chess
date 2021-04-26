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
package io.binghe.chess.utils;

import java.awt.Image;
import java.io.File;
import javax.swing.ImageIcon;

/**
 * @author binghe
 * @version 1.0.0
 * @description 图片的工具类
 */
public class ImageTools {

    public static Image loadImage(String path){
        try {
            ImageIcon im = new ImageIcon("image" + File.separator +path);
            return im.getImage();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        ImageIcon im=new ImageIcon("image"+File.separator+"main.gif");
        System.out.println(im);
    }
}
