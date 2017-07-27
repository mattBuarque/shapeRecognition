import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

/**
 * @author Matheus Buarque
 * @version 1.0
 * @since 2017-07-27
 */
public class ImageLog {
	private static final String LOGNAME ="log/ImageLog.txt";
	
	private static BufferedWriter buffered;
	private static FileWriter writer;
	
	public static void writeInLog(String text){
		try {
			File file = new File(LOGNAME);
			if (!file.exists()) {
				file.createNewFile();
			}
			writer = new FileWriter(file, true);
			buffered = new BufferedWriter(writer);
			buffered.write(System.getProperty("line.separator") + text);
			
		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			try {
				if (buffered != null) {
					buffered.close();
				}
				if (writer != null) {
					writer.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	
}
