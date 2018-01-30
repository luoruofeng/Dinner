package org.lrf;

public class PersonFacotry {
	public static Person createPerson(String name,Chopstick leftChopstick,Chopstick rightChopstick) {
		return new Person(name, leftChopstick, rightChopstick);
	}
}
