import java.math.BigInteger;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class BigSqrt {
	
	public BigSqrt() {
		
	}
	
	//using newton's method
	public static BigDecimal calc(BigInteger num, int scale){
		int count = 0;
		BigInteger findLength = num;
		do{
			findLength = findLength.divide(BigInteger.valueOf(10));
			count++;
		} while (!findLength.equals(BigInteger.ZERO));
		
		BigDecimal value = new BigDecimal(num);
		BigDecimal approx = new BigDecimal(count);
		for(int i =0; i<scale; i++){
			approx = approx.subtract(approx.pow(2).subtract(value).divide(approx.multiply(new BigDecimal(2)), scale, RoundingMode.HALF_UP));
			//x of n'th = x n-1 - (f(n-1)/f'(n-1))
		}
		return approx;
	}

}
