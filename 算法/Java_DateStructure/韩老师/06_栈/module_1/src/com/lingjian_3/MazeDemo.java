package com.lingjian_3;

/**
 * @description: 利用递归回溯解决迷宫问题
 * @author: Ling Jian
 * @date: 2019-12-05 10:33
 **/
public class MazeDemo {
    public static void main(String[] args) {
        //设置一个二维数组作为地图
        int[][] map = new int[8][7];

        //用1代表迷宫的墙壁
        //上下设置为墙壁
        for (int i = 0; i < map[0].length; i++) {
            map[0][i] = 1;
            map[7][i] = 1;
        }

        //左右设置为墙壁
        for (int i = 0; i < map.length; i++) {
            map[i][0] = 1;
            map[i][6] = 1;

        }

        //里面两个墙壁
        map[3][1] = 1;
        map[3][2] = 1;
//        map[1][2] = 1;
//        map[2][2]=1;
        printMap(map);
        setWay(map, 1, 1);
        System.out.println("------------");
        printMap(map);

    }

    //如果小球找到map[6][5]位置 通路找到
    //约定：当map[i][j]为  0表示该点没有走过 1表示墙壁
    //                    2表示通路可以走  3该点已经走过（走不通）
    //需要制定一个策略 下->右->上->左

    /**
     * @param map 迷宫地图
     * @param i   开始的横坐标
     * @param j   开始的纵坐标
     * @return 如果找到通路 返回true 否则返回false
     */
    public static boolean setWay(int[][] map, int i, int j) {
        if (map[6][5] == 2) {
            return true;
        } else {
            if (map[i][j] == 0) {  //表示当前该点还没有走过 按照策略走
                map[i][j] = 2;   //假设该点可以走
                if (setWay(map, i+ 1, j )) {  //向下走
                    return true;
                } else if (setWay(map, i , j+ 1)) { //向右走
                    return true;
                } else if (setWay(map, i - 1, j)) { //向上走
                    return true;
                } else if (setWay(map, i, j - 1)) { //向左走
                    return true;
                }    //这里的else可以省略
                map[i][j] = 3;
                return false;

            } else { //如果map[i][j]!=0 是1，2，3
                return false;
            }
        }
    }

    /**
     * @description: 打印地图
     * @param: [map]
     * @return: void
     * @author: Ling Jian
     * @date: 2019/12/5 11:05 上午
     */
    public static void printMap(int[][] map) {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

}





