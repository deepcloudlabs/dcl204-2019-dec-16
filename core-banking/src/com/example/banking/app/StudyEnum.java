package com.example.banking.app;

import com.example.banking.entity.AccountStatus;

/**
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 */
public class StudyEnum {

	public static void main(String[] args) {
		for (AccountStatus st : AccountStatus.values()) {
			System.out.println(
				st.name() + " : " + st.ordinal() 
				+ " : " + st.getCode()
			);
		}

	}

}
