import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.imageio.ImageIO;

public class Run {
	public static void main(String[] args) throws IOException {
		System.out.println("================================================");
		System.out.println("Simple shape Recognition made by Matheus Buarque");
		System.out.println("================================================");
		
		System.out.println("\n1-10x10 Image");
		Scanner s = new Scanner(System.in);
		
		String image = s.nextLine();
		
		switch (image) {
		case "1":
			Process proc = new Process(ImageIO.read(new File(Process.IMAGE10X10)));
			System.out.println("Image loaded: W:" +proc.getImage().getWidth() + " H:" + proc.getImage().getHeight());
			proc.startProcessing();
			break;
			
		default:
			System.err.println("Não Disponível.");
			break;
		}
	}	
}
