
public class Gregory {
	
	int limit;

	public Gregory(int limit) {
		this.limit = limit;
	}

	public double calculate(){
		int index = 1;
		double sum = 0;
		while(index<limit){
			sum += continueSum(index);
			index++;
		}
		return sum*4;
	}
	
	private double continueSum(double k){
		  if(k%2 == 0){
		    return -1/(2*k-1);
		  } else{
		    return 1/(2*k-1);
		  }
		}
}

//Gregory series by Gregory and Leibniz
//http://mathworld.wolfram.com/PiFormulas.html