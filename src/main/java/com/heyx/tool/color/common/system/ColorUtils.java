package com.heyx.tool.color.common.system;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @description:
 * @author: heyx
 * @create: 2020-07-12 16:22
 * @email; 1064042411@qq.com
 */
public class ColorUtils {

    public static List<String> getAllColor(int r, int g, int b){
        List<String> colorList = new ArrayList<>();
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < g; j++) {
                for (int k = 0; k < b; k++) {
                    colorList.add(toHexFromColor(new Color(i,j,k)));
                }
            }
        }
        return colorList;
    }


    public static String toHexFromColor(Color color){
        String r,g,b;
        StringBuilder su = new StringBuilder();
        r = Integer.toHexString(color.getRed());
        g = Integer.toHexString(color.getGreen());
        b = Integer.toHexString(color.getBlue());
        r = r.length() == 1 ? "0" + r : r;
        g = g.length() ==1 ? "0" +g : g;
        b = b.length() == 1 ? "0" + b : b;
        r = r.toUpperCase();
        g = g.toUpperCase();
        b = b.toUpperCase();
        su.append("0x");
        su.append(r);
        su.append(g);
        su.append(b);
        //0xFF0000FF
        return su.toString();
    }
    /**
     * 字符串转换成Color对象
     * @param colorStr 16进制颜色字符串
     * @return Color对象
     * */
    public static Color toColorFromString(String colorStr) {
        return new Color(Integer.parseInt(colorStr.substring(4), 16));
    }

    public static String getColor(){
        Random random = new Random();
        String red, green, blue;
        red = Integer.toHexString(random.nextInt(256)).toUpperCase();
        green = Integer.toHexString(random.nextInt(256)).toUpperCase();
        blue = Integer.toHexString(random.nextInt(256)).toUpperCase();
        red = red.length()==1 ? "0" + red : red ;
        green = green.length()==1 ? "0" + green : green ;
        blue = blue.length()==1 ? "0" + blue : blue ;
        return  "#"+red+green+blue;
    }

    public static List<String> getRandomColorList(int index) {
        Random random = new Random();
        boolean[]  bool = new boolean[255];
        int randInt;
        List<String> colorList = new ArrayList<>();
        for(int j = 0; j < index ; j++) {
            String red, green, blue;
            do {
                randInt = random.nextInt(255);
            } while (bool[randInt]);
            bool[randInt] = true;

            red = Integer.toHexString(randInt).toUpperCase();
            do {
                randInt = random.nextInt(255);
            } while (bool[randInt]);
            bool[randInt] = true;
            green = Integer.toHexString(randInt).toUpperCase();
            do {
                randInt = random.nextInt(255);
            } while (bool[randInt]);
            bool[randInt] = true;
            blue = Integer.toHexString(randInt).toUpperCase();

            red = red.length()==1 ? "0" + red : red ;
            green = green.length()==1 ? "0" + green : green ;
            blue = blue.length()==1 ? "0" + blue : blue ;
            colorList.add("#"+red+green+blue);
        }
        return colorList;
    }


}
