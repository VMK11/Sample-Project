package Main.main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.codehaus.jackson.map.MappingIterator;
import org.json.CDL;
import org.json.JSONArray;

import au.com.bytecode.opencsv.CSVReader;



public class csvParser {

	/*
	 * Parses csv file and returns a mapped list between headers and body
	 * 
	 */
	public static List<CSVRecord> readCsv(String path) throws IOException
	{
		Reader in = new FileReader(path);
        CSVParser parser = new CSVParser(in, CSVFormat.EXCEL.withHeader());
        List<CSVRecord> csvRecords = parser.getRecords();
        System.out.println("Data parsed");
		return csvRecords;
	}
}
