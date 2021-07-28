public class Son extends Father {
    public int num1=30;
    public int num2=20;
    //super()和this()都必须放在第一条语句中
    public Son(){
      super(" ");   //访问父类有参构造方法 结果 F有 S无 F有 S无 S有
//        super();        //访问父类无参构造方法 结果 F无 S无 F无 S无 S有
        System.out.println("Son无参构造方法");
    }
    public Son(String name){
        this();           //访问本类的其他构造方法 且那个构造方法中
                          //有super（...）访问父类中的有参构造方法
        System.out.println("Son有参构造方法");
    }
    public void show(){
        int num1=40;
        System.out.println(num1);      //输出局部范围num1
        System.out.println(this.num1); //输出本类成员范围的num1
        System.out.println(super.num1);//输出父类成员范围的num1
        System.out.println(num2);
    }
}
