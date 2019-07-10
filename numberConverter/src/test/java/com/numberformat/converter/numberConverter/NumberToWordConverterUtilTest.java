package com.numberformat.converter.numberConverter;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.numberformat.converter.numberConverter.utility.NumberToWordConverterUtil;

@Test
public class NumberToWordConverterUtilTest {
	Long num = (long) 1234;
	 assertThat( NumberToWordConverterUtil.beyondHundreed(num),is("one thousand two hundred thirty four")));
	 assertEquals(NumberToWordConverterUtil.beyondHundreed(num),is("one thousand two hundred thirty four"));
}
}
