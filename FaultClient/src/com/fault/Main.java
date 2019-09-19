package com.fault;

import java.rmi.RemoteException;

public class Main {
	public static void main(String[] args) {
		HelloWorldProxy helloWorldProxy=new HelloWorldProxy();
		
		try {
			String res=helloWorldProxy.sayHelloWorld("Anubhav");
			System.out.println(res);
		} catch (MissingName e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
