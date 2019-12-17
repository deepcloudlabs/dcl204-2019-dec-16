package com.example.animals.app;

import java.util.Arrays;
import java.util.List;
import java.util.function.ToIntFunction;

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
		
		int legs = 0;
		for (Animal animal : animals)
			if (animal instanceof Pet) 
			   legs += animal.getLegs();
		System.out.println(legs);
		
		ToIntFunction<Animal> mapToLegs = 
//			animal -> animal.getLegs()	;
				Animal::getLegs;
		legs = animals.stream()
//		       .filter(animal -> animal instanceof Pet)
		       .filter(Pet.class::isInstance)
		       .mapToInt(mapToLegs)
		       .sum();
		System.out.println(legs);
	}

}
