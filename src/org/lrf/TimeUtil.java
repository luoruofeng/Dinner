package org.lrf;

public class TimeUtil {
	public static long calculateRandomSecond(int maxSecond) {
		 return fromSecondToMillisecond(Math.random()*maxSecond);
	}
	
	public static long fromSecondToMillisecond(double second) {
		return  new Double(second*1000).longValue();
	}
}
