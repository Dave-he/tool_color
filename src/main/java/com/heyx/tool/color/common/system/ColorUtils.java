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
                    colorList.add(toHexFromInt(i, j, k));
                }
            }
        }
        return colorList;
    }

    private static String toHexStr(Integer src){
        String result = Integer.toHexString(src).toUpperCase();
        return result.length()==1 ? "0" + result : result;
    }

    public static String toHexFromInt(Integer r, Integer g, Integer b){
        return  "#"+toHexStr(r)+toHexStr(g)+toHexStr(b);
    }

    public static String toHexFromColor(Color color){
        return toHexFromInt(color.getRed(), color.getGreen(), color.getBlue());
    }
    /**
     * 字符串转换成Color对象
     * @param colorStr 16进制颜色字符串
     * @return Color对象
     * */
    public static Color toColorFromString(String colorStr) {
        return new Color(Integer.parseInt(colorStr.substring(4), 16));
    }

    public static String getRandomColor(){
        Random random = new Random();
        int size = 255;
        return toHexFromInt(random.nextInt(size), random.nextInt(size), random.nextInt(size));
    }

    public static List<String> getRandomColorList(int max) {
        Random random = new Random();
        boolean[]  bool = new boolean[255];
        int randInt;
        List<String> colorList = new ArrayList<>();
        for(int j = 0; j < max ; j++) {
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
