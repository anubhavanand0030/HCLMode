package com.hcl.JsonMaven;

import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class JsonArrayExample {
	public static void main(String args[]) {
		JSONObject obj = new JSONObject();
		// JSONArray arr1=new JSONArray();
		for (int i = 0; i < 3; i++) {
			JSONArray arr = new JSONArray();
			arr.add("sonoo");
			arr.add(new Integer(27));
			arr.add(new Double(600000));
			obj.put(i, arr);
		}

		System.out.println(obj);
		JSONArray arr1 = new JSONArray();
		Scanner sc=new Scanner(System.in);
		for (int i = 0; i < 3; i++) {
			JSONArray arr = new JSONArray();
			System.out.println("Enter the name");
			arr.add(sc.nextLine());
			System.out.println("Enter age");
			arr.add(new Integer(Integer.parseInt(sc.nextLine())));
			System.out.println("Enter salary");
			arr.add(new Double(Double.parseDouble(sc.nextLine())));
			arr1.add(arr);
		}

		System.out.println(arr1);
	}
}
