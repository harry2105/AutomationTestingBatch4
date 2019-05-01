import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyFileReader {

	
	public Properties readPropertyFile(String fileName) throws IOException{
		File file=new File(fileName);
		FileInputStream fis=new FileInputStream(file);
		Properties properties=new Properties();
		properties.load(fis);
		
		return properties;
		
	}
}
