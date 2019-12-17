package com.example.animals.domain;

/**
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 */
public abstract class Animal {
	protected int legs;

	public Animal(int legs) {
		this.legs = legs;
	}

	public int getLegs() {
		return legs;
	}

	public void walk(int distance) {
		System.out.println("Animal is walking " + distance + " km. now...");
	}

	public void walk() {
		walk(3);
	}

	public abstract void eat();
}
