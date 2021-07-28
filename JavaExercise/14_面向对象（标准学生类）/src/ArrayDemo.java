/*对数组进行操作*/
class ArrayDemo {
    public static void main(String[] args){
        int[] arr={28,55,37,46,19};
        //遍历数组
        //printArray(arr);//这里调用的是静态的,后面的方法要加static
        ArrayDemo ad=new ArrayDemo();
        ad.printArray(arr);//这里可以调用是非静态的 只能在对象中用
    }
    //如果有许多数组要进行遍历，代码重复读很高
    //用方法改进
    public void printArray(int[] arr){
        System.out.print("[");
        for(int i=0;i<arr.length;i++){
            if(i==arr.length-1){
                System.out.println(arr[i]+"]");
            }else{
                System.out.print(arr[i]+",");
            }
        }
    }
}
