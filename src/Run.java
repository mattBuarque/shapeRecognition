
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.imageio.ImageIO;

/**
 * @author Matheus Buarque
 * @version 1.0
 * @since 2017-07-25
 */
public class Run {
	public static void main(String[] args) throws IOException {
		System.out.println("================================================");
		System.out.println("Simple shape Recognition made by Matheus Buarque");
		System.out.println("================================================");
		
		System.out.println("\n1-10x10 Image");
		System.out.println("2-180x180 Image");
		System.out.println("3-520x520 Image");
		System.out.println("4-490x490 Diagonal Image");
		System.out.println("5-Unknown Shape Image");
		
		Scanner s = new Scanner(System.in);
		
		String image = s.nextLine();
		
		Process proc = null;
		switch (image) {
		case "1":
			proc = new Process(ImageIO.read(new File(Process.IMAGE10X10)));
			break;
		case "2":
			proc = new Process(ImageIO.read(new File(Process.IMAGE180X180)));
			break;	
		case "3":
			proc = new Process(ImageIO.read(new File(Process.IMAGE520X520)));
			break;	
		case "4":
			proc = new Process(ImageIO.read(new File(Process.IMAGEDIAGONAL490X490)));
			break;	
		case "5":
			proc = new Process(ImageIO.read(new File(Process.UNKNOWNSHAPE)));
			break;	
		default:
			System.err.println("Não Disponível.");
			break;
		}
		
		System.out.println("Image loaded: W:" + proc.getImage().getWidth() + " H:" + proc.getImage().getHeight());
		proc.startProcessing();
		
	}	
}
