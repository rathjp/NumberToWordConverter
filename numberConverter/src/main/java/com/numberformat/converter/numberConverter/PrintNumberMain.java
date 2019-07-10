package com.numberformat.converter.numberConverter;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.numberformat.converter.numberConverter.Exception.MyNumberFormatException;
import com.numberformat.converter.numberConverter.utility.NumberToWordConverterUtil;



public class PrintNumberMain {
	public static void main(String[] args) {
		System.out.println("Please enter a valid number i.e, negetive,decimal numbers ae not allowed."
				+ " Number should not be greater that 999999999999999l) ");
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		// Reading data using readLine
		try {
			String name = reader.readLine();
			long num = 0;
			if (num > 999999999999999l) {
				throw new MyNumberFormatException("Please enter a valid Number");
			}
			num = new Long(name);

			if (num < 0) {
				throw new MyNumberFormatException("Please enter a valid Number");
			}
			System.out.println("converted ::::" + NumberToWordConverterUtil.beyondHundreed(num));

		} catch (IOException e) {
			e.getMessage();
		} catch (NumberFormatException ex) {
			ex.getMessage();
		}

	}
}
