package org.lrf;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Desk {
	
	public Desk() {
		setChopsticks(createChopstick());
		createAndSetChopstickToPersons();
		startDinner();
	}
	
	private static final int NUMBER_OF_PERSON = 3;
	
	
	private List<Chopstick> createChopstick() {
		List<Chopstick> chopsticks = new ArrayList<Chopstick>();
		
		for (int i = 0; i < NUMBER_OF_PERSON; i++) {
			chopsticks.add(new Chopstick());
		}
		return chopsticks;
	}
	
	private void createAndSetChopstickToPersons() {
		List<Person> persons = new ArrayList<>();
		
		for (int i = 0; i < NUMBER_OF_PERSON; i++) {
			Chopstick left = this.chopsticks.get(i);
			Chopstick right = (i+1 == NUMBER_OF_PERSON) ? this.chopsticks.get(0) : this.chopsticks.get(i+1);
			Person person = PersonFacotry.createPerson("name"+i, left, right);
			
			persons.add(person);
		}
		setPersons(persons);
	}
	
	
	private List<Chopstick> chopsticks;
	private List<Person> persons;
	public List<Chopstick> getChopsticks() {
		return chopsticks;
	}
	public void setChopsticks(List<Chopstick> chopsticks) {
		this.chopsticks = chopsticks;
	}
	public List<Person> getPersons() {
		return persons;
	}
	public void setPersons(List<Person> persons) {
		this.persons = persons;
	}
	
	public void startDinner() {
		for (int i = 0; i < persons.size(); i++) {
			new Thread(persons.get(i)).start();
		}
	}
	
	
}
