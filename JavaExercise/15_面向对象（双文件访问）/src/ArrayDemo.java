class ArrayDemo {
    public static void main(String[] args){
        int[] arr={28,55,37,46,19};
        //通过新建对象访问遍历数组的方法
        //若不希望通过对象来调用
        //可以通过修改对象的构造函数，将其定义为private
        /*
        ArrayTool at=new ArrayTool();
        at.printArray(arr);
        */
        //用于是成员静态方法，也可以直接通过类名调用

        //遍历数组
        ArrayTool.printArray(arr);

        //获取最大值和最小值
        int max=ArrayTool.getMaxArray(arr);
        System.out.println("The max of array is "+max);
        int min=ArrayTool.getMinArray(arr);
        System.out.println("The min of array is "+min);

        //获取55的索引
        int index=ArrayTool.getIndex(arr,55);
        System.out.println("The index of 55 is "+index);
    }
}
