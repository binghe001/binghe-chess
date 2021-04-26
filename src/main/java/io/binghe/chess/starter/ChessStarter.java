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
package io.binghe.chess.starter;

import io.binghe.chess.canvas.Canvas;
import io.binghe.chess.music.MusicPlayer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

/**
 * @author binghe
 * @version 1.0.0
 * @description 项目启动类
 */
public class ChessStarter {

    public static void main(String[] args){
        JFrame f =new JFrame("中国象棋(冰河作品)");
        ImageIcon icon = new ImageIcon("image" + File.separator + "red_e.gif");
        f.setIconImage(icon.getImage());

        f.setSize(730,750);
        f.setLocationRelativeTo(null);
        f.setLayout(new BorderLayout());
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        final Canvas canvas = new Canvas();
        f.add(canvas);

        JButton newStartGame = new JButton("新游戏");
        JButton startMusic = new JButton("播放音乐");
        JButton ExitGame = new JButton("退出游戏");

        //为新游戏按钮  添加事件
        newStartGame.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                canvas.initMap();//新游戏
                canvas.repaint();//新游戏后，出棋先后顺序互换
                canvas.setSelectColumn(-1);
                canvas.setSelectRow(-1);
                canvas.setBlack(!canvas.isBlack());
            }
        });

        //为退出按钮  添加事件
        ExitGame.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                int j=JOptionPane.showConfirmDialog(null, "真的要退出吗？","退出",JOptionPane.YES_OPTION,JOptionPane.QUESTION_MESSAGE);
                if(j==JOptionPane.YES_OPTION){
                    System.exit(0);
                }
            }
        });

        //为音乐播放按钮  添加事件
        startMusic.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                String filepath = "music" + File.separator + "music.wav";
                MusicPlayer musicPlayer = new MusicPlayer();
                musicPlayer.playMusic(filepath);//音乐播放
            }

        });
        f.add(newStartGame, BorderLayout.WEST);
        f.add(startMusic,BorderLayout.EAST);
        f.add(ExitGame,BorderLayout.SOUTH);
        f.setVisible(true);
    }
}
