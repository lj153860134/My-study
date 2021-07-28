/*求两个数据值和的函数*/
public class functionDemo {
    public static void main(String[] args){
        int sum1;
        int sum2;
        sum1=sum(10,20);
        sum2=sum(200,388);
        System.out.println("sum1: "+sum1);
        System.out.println("sum2: "+sum2);

    }
   private static int sum(int x,int y){
        int z;
        z=x+y;
        return z;  // 也可以直接return x+y；
    }
}
