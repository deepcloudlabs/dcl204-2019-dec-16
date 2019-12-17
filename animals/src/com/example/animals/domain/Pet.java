package com.example.animals.domain;

/**
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 */
public abstract interface Pet {
	public abstract String getName();
	abstract void setName(String name);
	public void play();
}
