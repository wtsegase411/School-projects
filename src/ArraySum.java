
public class ArraySum {

	public int sumOfArray(Integer[] myArray, int i) {
		int sum=0;
		if(i<=0) {
			sum=myArray[0];
		}
		else {
			sum+=sumOfArray(myArray,i-1)+myArray[i];
		}
		return sum;
	}



}
