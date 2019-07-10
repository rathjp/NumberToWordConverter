package com.numberformat.converter.numberConverter.utility;
import java.text.DecimalFormat;

public class NumberToWordConverterUtil {

	private static final String[] tensName = { "", " ten", " twenty", " thirty", " forty", " fifty", " sixty",
			" seventy", " eighty", " ninety" };
	private static final String[] numName = { "", " one ", " two", " three", " four", " five", " six", " seven",
			" eight", " nine", " ten", " eleven", " twelve", " thirten", " fourteen", " fivteen", " sixteen",
			" seventeen", " eighteen", " ninteen" };

	//checkless than thousand
	public static String convertLessThanThousand(int num) {
		String fetched;
		if (num % 100 < 20) {
			fetched = numName[num % 100];
			num /= 100;
		} else {
			fetched = numName[num % 10];
			num /= 10;

			fetched = tensName[num % 10] + fetched;
			num /= 10;
		}
		if (num == 0)
			return fetched;
		return numName[num] + " hundred " + fetched;

	}

	//check more than thousand to 999 999 999 999 
	public static String beyondHundreed(Long num) {
		String result;
		String millions_str;
		String billions_str;
		String hundredThousand_str;
		String thousand_str;
		
		String valid_num = Long.toString(num);
		String masking = "000000000000";
		DecimalFormat df = new DecimalFormat(masking);
		valid_num = df.format(num);

		int billions = Integer.parseInt(valid_num.substring(0, 3));
		int millions = Integer.parseInt(valid_num.substring(3, 6));
		int hundredthousands = Integer.parseInt(valid_num.substring(6, 9));
		int thousands = Integer.parseInt(valid_num.substring(9, 12));
 
		//Logic for billion
		switch (billions) {
		case 0:
			billions_str = "";
			break;
		case 1:
			billions_str = convertLessThanThousand(billions) + " billions ";
			break;
		default:
			billions_str = convertLessThanThousand(billions) + " billions ";
			break;
		}
		result = billions_str;
		//
		
		//Logic for Million
		switch (millions) {
		case 0:
			millions_str = "";
			break;
		case 1:
			millions_str = convertLessThanThousand(millions) + " millions ";
			break;
		default:
			millions_str = convertLessThanThousand(millions) + " millions ";
			break;
		}
		result = result + millions_str;
        //
		
		//Logic for hundred thousand
		switch (hundredthousands) {
		case 0:
			hundredThousand_str = "";
			break;
		case 1:
			hundredThousand_str = "one thousand ";
			break;
		default:
			hundredThousand_str = convertLessThanThousand(hundredthousands) + " thousands ";
			break;
		}
		result = result + hundredThousand_str;
        //
		
		thousand_str = convertLessThanThousand(thousands);
		result = result + thousand_str;
		return result;
	}

}
