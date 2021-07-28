import java.math.BigDecimal;

/**
 * @author lingjian
 * @date 2019-09-11 - 17:13
 */
public class hehe {

        public static void main(String[] args) {
            BigDecimal bd1=new BigDecimal("1.301");
            BigDecimal bd2=new BigDecimal("100");
            System.out.println(bd1.divide(bd2,8,BigDecimal.ROUND_HALF_UP));
        }
    }

