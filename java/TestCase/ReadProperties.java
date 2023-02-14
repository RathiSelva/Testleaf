package TestCase;
	import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

		public class ReadProperties {

			public static void main(String[] args) throws IOException {
				
				// Create an object for Properties class
				Properties prop = new Properties();
				
				// Create an object for FileInputStream class
				FileInputStream fis = new FileInputStream(new File("src/main/resources/config.properties"));
				
				// Load the file
				prop.load(fis);
				
				// Read the data from the file
				String url = prop.getProperty("url");
				System.out.println(url);
				System.out.println(prop.getProperty("username"));
			}

		
	}


