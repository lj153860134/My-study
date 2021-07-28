public class loopDemo8 {
    public static void main(String[] args) {
        wc:for (int i = 0; i <4 ; i++) {
            nc:for (int j = 0; j <4 ; j++) {
                System.out.print(j);
                if(i==2){
                    break wc;
                }
            }
            System.out.println();
        }
    }
}
