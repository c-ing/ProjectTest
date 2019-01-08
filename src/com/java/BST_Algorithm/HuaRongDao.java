package com.java.BST_Algorithm;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * Created by cdc on 2018/10/19.
 *
 * 华龙道问题——深搜索
 */
public class HuaRongDao {

    //定义方向
    private static final  int LEFT= 1;
    private static final  int RIGHT = 2;
    private static final int UP = 3;
    private static final int DOWN = 4;

    // 3x3的九宫格
    private int[][] arr;

    //记录空格的位置
    private int x;
    private int y;

    // 定义移动的数组
    private List<Integer> moveArr = new LinkedList<Integer>();

    // 定义终点状态
    private static final Integer WIN_STATE = 123456780;

    // 保存已经搜索过的状态
    private Set<Integer> statusSet = new HashSet<Integer>();

    // 初始化，数字0代表空格，先遍历，找出空格的位置
    public HuaRongDao(int[][] arr) {
        this.arr = arr;
        for(int i=0; i<arr.length; i++) {
            for(int j=0; j<arr.length; j++) {
                if(arr[i][j] == 0) {
                    x = i;
                    y = j;
                }
            }
        }
    }

    // 判断是否可以朝某个方向进行移动
    private boolean canMove(int direction) {
        switch (direction) {
            case LEFT:
                return  y > 0;
            case RIGHT:
                return  y < 2;
            case UP:
                return x>0;
            case DOWN :
                return x<2;
            default:
                return false;
        }
    }

    // 朝某个方向进行移动，该函数不作判断，直接移动
    // 调用前请自行用canMove先行判断
    private void moveForward(int direction) {
        int temp;
        switch (direction) {
            case LEFT:
                temp = arr[x][y - 1];
                arr[x][y-1] = 0;
                arr[x][y]=temp;
                y = y -1;
                break;
            case RIGHT:
                temp = arr[x][y + 1];
                arr[x][y+1] = 0;
                arr[x][y] = temp;
                y = y+1;
                break;
            case UP:
                temp = arr[x-1][y ];
                arr[x-1][y] = 0;
                arr[x][y] = temp;
                x = x-11;
                break;
            case DOWN:
                temp = arr[x+1][y ];
                arr[x+ 1][y] = 0;
                arr[x][y] = temp;
                x = x + 1;
                break;
        }
        //该方向记录
        moveArr.add(direction);
    }

    // 某个方向的回退，该函数不作判断，直接移动
    // 其操作和moveForward方法正好相反
    private void moveBack(int direction) {
        int temp;
        switch (direction) {
            // 空格和左侧数字交换
            case LEFT:
                temp = arr[x][y + 1];
                arr[x][y + 1] = 0;
                arr[x][y] = temp;
                y = y + 1;
                break;
            // 空格和右侧数字交换
            case RIGHT:
                temp = arr[x][y - 1];
                arr[x][y - 1] = 0;
                arr[x][y] = temp;
                y = y - 1;
                break;
            // 空格和上方数字交换
            case UP:
                temp = arr[x + 1][y];
                arr[x + 1][y] = 0;
                arr[x][y] = temp;
                x = x + 1;
                break;
            // 空格和下方数字交换
            case DOWN:
                temp = arr[x - 1][y];
                arr[x - 1][y] = 0;
                arr[x][y] = temp;
                x = x - 1;
                break;
        }
        // 记录的移动步骤出栈
        moveArr.remove(moveArr.size() - 1);
    }


    // 获取状态，这里把9个数字按顺序组成一个整数来代表状态
    // 方法不唯一，只要能区分九宫格状态就行
    private Integer getStatus() {
        int status = 0;
        for (int i = 0; i<arr.length;i++) {
            for (int j = 0; j<arr.length;j++) {
                status = status * 10 + arr[i][j];
            }
        }
        return status;
    }


}
