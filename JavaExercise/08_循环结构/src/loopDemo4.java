/*我国最高山峰是珠穆朗玛峰：8848m，
  现在有一张足够大的纸张，厚度为：0.01m。
  请问，我折叠多少次，
  就可以保证厚度不低于珠穆朗玛峰的高度。
*/
public class loopDemo4 {
    public static void main(String[] args){
        int height=8848;
        double paper=0.01;
        int count=0;
        while(paper<height){
            paper*=2;
            count++;
        }
        System.out.println("需要折叠"+count+"次");
    }
}
