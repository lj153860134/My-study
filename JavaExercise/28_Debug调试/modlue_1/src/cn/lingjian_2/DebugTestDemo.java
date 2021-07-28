package cn.lingjian_2;

/**
 * @author lingjian
 * @date 2019-07-23 - 16:12
 */
public class DebugTestDemo {
    /*参数传递问题
* 思考题1：看程序写结果，然后分析为什么是这个样子的。并画图讲解。最后总结Java中参数传递规律。

	    Java中的参数传递问题：
		基本类型：形式参数的改变对实际参数没有影响。
		引用类型：形式参数的改变直接影响实际参数*/
        public static void main(String[] args) {
            int a = 10;
            int b = 20;
            System.out.println("a:"+a+",b:"+b);
            change(a,b);
            System.out.println("a:"+a+",b:"+b);

            int[] arr = {1,2,3,4,5};
            change(arr);
            System.out.println(arr[1]);
        }

        public static void change(int a,int b) {
            System.out.println("a:"+a+",b:"+b);
            a = b;
            b = a + b;
            System.out.println("a:"+a+",b:"+b);
        }

        public static void change(int[] arr) {
            for(int x=0; x<arr.length; x++) {
                if(arr[x]%2==0) {
                    arr[x]*=2;
                }
            }

        }
    }



