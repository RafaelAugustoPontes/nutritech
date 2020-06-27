package br.com.nutritech.util;

import java.text.DecimalFormat;

public class DecimalUtil {

	private static DecimalFormat df = new DecimalFormat("#.##");

	public static String format(Number imc) {
		return df.format(imc);
	}

}
