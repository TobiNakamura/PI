import com.google.common.math.IntMath;
import com.google.common.math.BigIntegerMath;

import java.math.BigInteger;
import java.math.BigDecimal;
import java.math.RoundingMode;


public class Ramanujan {
	
	BigInteger k_1 = BigInteger.valueOf(545140134), k_2 = BigInteger.valueOf(13591409), k_3 = BigInteger.valueOf(640320), 
			k_4 = BigInteger.valueOf(100100025), k_5 = BigInteger.valueOf(327843840), k_6 = BigInteger.valueOf(53360), k_7;
	BigDecimal k_8 = new BigDecimal(0);
	int limit;
	int factor;
	
	public Ramanujan(int limit) {
		this.limit = limit;
		this.factor = limit*1;
		k_7 = BigInteger.valueOf(8).multiply(k_4).multiply(k_5);
		k_8 = BigSqrt.calc(k_3, factor).multiply(new BigDecimal(k_6));
	}
	
	public BigDecimal calculate(){
		int index = 0;
		BigDecimal sum = new BigDecimal(0);
		while(index<limit){
			if(index%2 == 0){
				sum = sum.add(continueSum(index));
			}else{
				sum = sum.subtract(continueSum(index));
			}
			index++;
		}
		return k_8.divide(sum, limit, RoundingMode.HALF_UP);
	}
	
	private BigDecimal continueSum(int i){
		BigInteger mag_num = BigIntegerMath.factorial(6*i).multiply(k_2.add(k_1.multiply(BigInteger.valueOf(i))));
		BigInteger mag_den = BigIntegerMath.factorial(i).pow(3).multiply(BigIntegerMath.factorial(i*3).multiply(k_7.pow(i)));
		return new BigDecimal(mag_num).divide(new BigDecimal(mag_den), factor, RoundingMode.HALF_UP);
	}

}

//calc by S. Ramanujan added by Chudnovsky
//pi = (k_6 sqrt(k_3))/(S)
//S = sum_(n = 0)^oo (-1)^n ((6n)!(k_2 + nk_1))/(n!^3(3n)!(8k_4k_5)^n)
//https://cs.uwaterloo.ca/~alopez-o/math-faq/mathtext/node12.html

/*	public double calculate(int limit){
		int index = 0;
		double sum = 0;
		while(index<limit){
			sum += continueSum(index);
			index++;
		}
		return (k_6*Math.sqrt(k_3))/sum;
	}
	
	private double continueSum(int i){
		double mag = IntMath.factorial(6*i)*(k_2 + (i*k_1))/(IntMath.pow(IntMath.factorial(i),3)*IntMath.factorial(i*3)*IntMath.pow(8*k_4*k_5, i));
		if(i%2 == 0){
		    return mag;
		  } else{
		    return -1*mag;
		  }
	}
*/
