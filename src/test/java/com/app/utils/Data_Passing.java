package com.app.utils;

import java.util.List;

import org.testng.annotations.DataProvider;

public class Data_Passing {
	@DataProvider(name = "placeData")
    public Object[][] provideData() {
        List<String[]> csvData = CSVReaderUtil.readCSV("src/test/resources/TestData/address_data.csv");
        Object[][] data = new Object[csvData.size()][4];
        for (int i = 0; i < csvData.size(); i++) {
            data[i] = csvData.get(i);
        }
        return data;
	}
}
