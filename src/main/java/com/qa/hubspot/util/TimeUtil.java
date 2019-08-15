package com.qa.hubspot.util;
/**
 * 
 * @author VDK
 *
 */
public class TimeUtil {
	
	public static void shortWait(){
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static void mediumWait(){
		try {
			Thread.sleep(7000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static void longWait(){
		try {
			Thread.sleep(12000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
