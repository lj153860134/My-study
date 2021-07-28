/*
	定义一个长方形类,定义 求周长和面积的方法，
	然后定义一个测试了Test2，进行测试。

	长方形的类：
		成员变量：
			长，宽
		成员方法：
			求周长：(长+宽)*2;
			求面积：长*宽

	注意：
		import必须出现在所有的class前面。
*/
import java.util.Scanner;
class RectangleDemo {
    //成员变量（长 宽）
    private int length;
    private int width;
    //无参的构造方法
    RectangleDemo(){}
    //赋值长和宽的方法
    public void setLength(int length){
        this.length=length;
    }
    public void setWidth(int width) {
        this.width = width;
    }
    //求周长的方法
    public int getPerimeter(){
        int p=(length+width)*2;
        return p;
    }
    //求面积的方法
    public int getArea(){
        int a=length*width;
        return a;
    }

}
class RectangleTest{
    public static void main(String[] args){
        //创建键盘录入对象
        Scanner sc=new Scanner(System.in);
        //创建长方形对象
        RectangleDemo r=new RectangleDemo();
        System.out.println("Please enter the length");
        r.setLength(sc.nextInt());
        System.out.println("Please enter the width");
        r.setWidth(sc.nextInt());
        System.out.println("The perimeter is "+r.getPerimeter());
        System.out.println("The area is "+r.getArea());
    }
}

