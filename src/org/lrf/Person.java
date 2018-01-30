package org.lrf;

public class Person implements Runnable{

	public Person(String name,Chopstick leftChopstick,Chopstick rightChopstick) {
		this.name = name;
		this.leftChopstick = leftChopstick;
		this.rightChopstick = rightChopstick;
		this.state = PersonState.SLEEPING;
	}
	
	
	private String name;
	
	private PersonState state;
	
	private Chopstick leftChopstick;
	private Chopstick rightChopstick;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public PersonState getState() {
		return state;
	}
	public void setState(PersonState state) {
		this.state = state;
	}
	public Chopstick getLeftChopstick() {
		return leftChopstick;
	}
	public void setLeftChopstick(Chopstick leftChopstick) {
		this.leftChopstick = leftChopstick;
	}
	public Chopstick getRightChopstick() {
		return rightChopstick;
	}
	public void setRightChopstick(Chopstick rightChopstick) {
		this.rightChopstick = rightChopstick;
	}
	
	public void changeState() throws InterruptedException {
		
		if(this.state == PersonState.SLEEPING) 
			this.state = PersonState.EATING;
		else if(this.state == PersonState.EATING)
			this.state = PersonState.SLEEPING;
		
		System.out.println(this.name+" "+this.state);
		Thread.sleep(TimeUtil.calculateRandomSecond(3));
	}
	
	public void pickChopstick() throws InterruptedException {
		synchronized (rightChopstick) {
			System.out.println(this.name+" "+"pick right up");
			synchronized (leftChopstick) {
				System.out.println(this.name+" "+"pick left up");
				changeState();
				System.out.println(this.name+" drop down");
			}
		}
	}
	
	public void operate() throws InterruptedException {
		
		Thread.sleep(TimeUtil.calculateRandomSecond(3));
		
		pickChopstick();
		changeState();
	}
	
	
	@Override
	public void run() {
		while(true) {
			try {
				operate();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
	
}
