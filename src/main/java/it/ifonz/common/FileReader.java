package it.ifonz.common;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.util.List;

import org.apache.commons.io.FileUtils;

public class FileReader {
	
	public static List<String> readLines(String fileName) throws URISyntaxException, IOException {
		File file = new File(FileReader.class.getResource(fileName).toURI());
		return FileUtils.readLines(file, Charset.defaultCharset());
	}

}
