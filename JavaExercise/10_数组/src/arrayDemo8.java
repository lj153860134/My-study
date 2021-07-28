/*销售额求和
* 某公司按照季度和月份统计的数据如下：单位(万元)
  第一季度：22,66,44
  第二季度：77,33,88
  第三季度：25,45,65
  第四季度：11,66,99*/
public class arrayDemo8 {
    public static void main(String[] args){
        int[][] array={{22,66,44},{77,33,88},{25,45,65},{11,66,99}};
        sumTwoArray(array);

    }
    public static void sumTwoArray(int[][] arr){
        int yearsum=0;
        int len=arr.length;
        for(int i=0;i<len;i++){
            int seasonsum=0;
            for (int j=0;j<arr[i].length;j++){
                seasonsum+=arr[i][j];
                yearsum+=arr[i][j];
            }
            System.out.println("The sum of "+(i+1)+" season:"+seasonsum);
        }
        System.out.println("The sum of year:"+yearsum);
    }
}
