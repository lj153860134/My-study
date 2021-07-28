public class Phone {
    public void call(String name){
        System.out.println("please call "+name);
    }
}
class NewPhone extends Phone{
    public void call(String name){
        super.call(name);
        System.out.println("listen to weather forecast");
    }
}
class ExtendDemo3{
    public static void main(String[] args){
        NewPhone np=new NewPhone();
        np.call("徐小萌");
    }
}
