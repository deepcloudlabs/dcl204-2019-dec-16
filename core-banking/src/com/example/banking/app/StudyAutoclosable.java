package com.example.banking.app;

import java.util.Arrays;

/**
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 */
public class StudyAutoclosable {

	public static void main(String[] args) throws Exception {
	    // try-with-resources
		try(
				PreciousResource res1 = new PreciousResource(1);
				PreciousResource res2 = new PreciousResource(2);
				PreciousResource res3 = new PreciousResource(3);				
		) {
			System.err.println("Running inside try block!");
			throw new IllegalStateException("Wrong state!");
		} catch (Exception e) {
			System.err.println(e.getMessage());
			Arrays.stream(e.getSuppressed())
			.map(Throwable::getMessage)
			.forEach(System.err::println);
		}
//		finally {
//			try {
//				res1.close();
//			} catch (Exception e) {
//				System.err.println(e.getMessage());
//			} finally {
//				try {
//					res2.close();
//				} catch (Exception e) {
//					System.err.println(e.getMessage());
//				} finally {
//					try {
//						res3.close();
//					} catch (Exception e) {
//						System.err.println(e.getMessage());
//					}
//				}
//			}
//		}
//	}
	}
}

class PreciousResource implements AutoCloseable {
	private int id;

	public PreciousResource(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	@Override
	public void close() throws Exception {
		System.err.println("Closing the resource " + id + " ...");
		throw new IllegalStateException("Cannot close the resource " + id + "...");
	}

}