package com.example;

import java.text.DecimalFormat;
import java.util.Locale;

/**
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 */
public class StudyNumberFormatter {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		double money = 12_345.6789;
		Locale tr = new Locale("tr", "TR");
		DecimalFormat df = (DecimalFormat) DecimalFormat.getCurrencyInstance(Locale.ITALY);
//		DecimalFormatSymbols dfs = 
//				DecimalFormatSymbols.getInstance(tr);
//		dfs.setCurrencySymbol("\u20BA");
//		df.setDecimalFormatSymbols(dfs);
		System.out.println(df.format(money));
	}

}
