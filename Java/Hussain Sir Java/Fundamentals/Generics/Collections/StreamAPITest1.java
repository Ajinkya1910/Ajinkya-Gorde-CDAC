import java.util.*;

class StreamAPITest1{

	public static void main(String[] args){
		int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		/*
		for(int n : numbers){
			if((n % 2) == 1)
				System.out.println(n * n);
		}
		*/
		Arrays.stream(numbers)
			.filter(n -> (n % 2) == 1)
			.map(n -> n * n)
			.forEach(System.out::println);
	}
}


