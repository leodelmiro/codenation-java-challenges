package br.com.codenation.desafioexe;

import java.util.ArrayList;
import java.util.List;

public class DesafioApplication {
    
	public static List<Integer> fibonacci() {
		List<Integer> fibonacciUntil350 = new ArrayList<>();
		int number = 0;
		while (number < 350) {
			if (fibonacciUntil350.size() < 2){
				fibonacciUntil350.add(number);
				number++;
			} else {
				int lastArrayElement = fibonacciUntil350.size()-1;
				number = fibonacciUntil350.get(lastArrayElement) + fibonacciUntil350.get(lastArrayElement - 1);
				fibonacciUntil350.add(number);
			}
		}
		return fibonacciUntil350;
	}

	public static Boolean isFibonacci(Integer a) {
		List<Integer> fibonacciUntil350 = fibonacci();
		return fibonacciUntil350.contains(a);
	}

}