package com.example.banking.app;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

import com.example.banking.entity.Bank;

/**
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 */
public class ReadBankFromFile {

	public static void main(String[] args) {
		File tmp = new File("c:/tmp");
		try( FileInputStream fos = 
				new FileInputStream(
						new File(tmp,"garan.bak"));
		ObjectInputStream oos = 
				new ObjectInputStream(fos);
				){
			Bank bank = (Bank) oos.readObject();
			bank.generateReport();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
