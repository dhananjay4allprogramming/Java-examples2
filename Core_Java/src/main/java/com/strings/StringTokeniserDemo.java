package com.strings;

import java.util.StringTokenizer;

public class StringTokeniserDemo {

	public static void main(String[] args) {
		String message = "Hello this is dhananjay pandey from tihiya jamui";
		StringTokenizer st = new StringTokenizer(message);
		while(st.hasMoreTokens()) {
			System.out.println(st.nextToken());
		}
		
		System.out.println("Number of tocken : " +st.countTokens());
		System.out.println("has more element : "+st.hasMoreElements());
		System.out.println("has more tocen : "+st.hasMoreTokens());
		System.out.println("next element : "+st.nextElement());
		System.out.println("next token delimeter space : "+st.nextToken(" "));
		

	}

}
