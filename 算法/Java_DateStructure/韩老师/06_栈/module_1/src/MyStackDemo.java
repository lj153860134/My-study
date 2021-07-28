/**
 * @author lingjian
 * @date 2019/12/3 - 9:42 上午
 */
public class MyStackDemo {
    public static void main(String[] args){
       MyStack stack=new MyStack(5);
       stack.push(1);
       stack.push(2);
       stack.push(3);
       stack.push(4);
       stack.push(5);
       stack.push(6);

       stack.pop();

       stack.printStack();
    }
}

//用数组模拟栈
class MyStack{
    private int maxSize;
    private int[] stack;
    private int top;  //指向出栈数据的位置（栈顶）

    //构造器
    public MyStack(int maxSize) {
        this.maxSize = maxSize;
        stack=new int[maxSize];
        top=-1;
    }

    //判断栈满
    public boolean isFull(){
        return top==maxSize-1;
    }

    //判断栈空
    public boolean isEmpty(){
        return top==-1;
    }

    //入栈
    public void push(int data){
        if(isFull()){
            System.out.println("栈满 无法添加数据");
            return;
        }
        stack[++top]=data;
    }

    //出栈
    public int pop(){
        if(isEmpty()){
            throw new RuntimeException("栈空 无法弹出数据");
        }
        return stack[top--];
    }

    //遍历栈数据
    public void printStack(){
        if(isEmpty()){
            System.out.println("栈空 无法打印数据");
            return;
        }
//        System.out.print("[ "+stack[top--]);
//        while(top!=-1){
//            System.out.print(", "+stack[top--]);
//        }
//        System.out.println(" ]");  //打印栈 top不能变化
        for (int i = top; i >=0 ; i--) {
            if(i==top)
                System.out.print("[ ");
            System.out.print(+stack[i]+", ");
        }
        System.out.println("]");
    }
}

