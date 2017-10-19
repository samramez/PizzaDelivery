package com.example.samramezanli.pizzadelivery;

/**
 * Created by samramezanli on 10/18/17.
 */

public class Direction {
    public final static String E_DIRECTION = "E";
    public final static String W_DIRECTION = "W";
    public final static String N_DIRECTION = "N";
    public final static String S_DIRECTION = "S";
    public final static String DROP = "D";


    static String getXDirection(String result, int x) {

        if (x < 0) {

            while (x != 0) {
                result += W_DIRECTION;
                x++;
            }
        }
        else if (x > 0) {

            while (x != 0) {
                result += E_DIRECTION;
                x--;
            }
        }
        return result;
    }

    static String getYDirection(String result, int y) {

        if (y < 0) {

            while (y != 0) {
                result += S_DIRECTION;
                y++;
            }
        } else if (y > 0) {

            while (y != 0) {
                result += N_DIRECTION;
                y--;
            }
        }
        return result;
    }
}
