import java.util.Scanner;

public class RD {
    private int length;
    private int wideth;
    public RD(){} // 无参构造函数
    public RD(int length,int wideth){
        this.length=length;
        this.wideth=wideth;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getLength() {
        return length;
    }

    public void setWideth(int wideth) {
        this.wideth = wideth;
    }

    public int getWideth() {
        return wideth;
    }
    public  int getArea(){
        return length*wideth; //不能用public static length和wideth都是费静态变量
    }
}
class RDDemo{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        RD r=new RD();
        System.out.println("Please enter a length");
        r.setLength(sc.nextInt());
        System.out.println("Please enter a wideth");
        r.setWideth(sc.nextInt());
        System.out.println("The area is "+r.getArea());


    }

}
