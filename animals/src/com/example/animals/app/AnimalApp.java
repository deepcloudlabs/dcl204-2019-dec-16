package com.example.animals.app;

import java.util.Arrays;
import java.util.List;

import com.example.animals.domain.Animal;
import com.example.animals.domain.Cat;
import com.example.animals.domain.Fish;
import com.example.animals.domain.Pet;
import com.example.animals.domain.Spider;

/**
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 */
public class AnimalApp {

	public static void main(String[] args) {
		List<Animal> animals = Arrays.asList(
				new Spider(),
				new Cat(),
				new Fish("Free Willy"),
				new Cat("Garfield"),
				new Fish("Jaws"),
				new Spider(),
				new Cat("Çakıl")
		);
		for (Animal animal : animals) {
			animal.walk();
			animal.eat();
			if (animal instanceof Pet) {
				((Pet) animal).play();
			}
		}
		
	}

}
