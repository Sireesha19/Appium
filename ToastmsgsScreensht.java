package TroopMessengerApp;

import java.io.File;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;

public class ToastmsgsScreensht {

	
public static void main(String[] args) {
		
			
			File f1= new File("/home/sireesha/Desktop/err.png");
				String result = null;
				ITesseract instance = new Tesseract();
				System.out.println("entered===>");
				instance.setDatapath("/home/sireesha/eclipse-workspace/siriProject/tessdata");
				instance.setLanguage("eng");
				try {
					result = instance.doOCR(f1);
				} catch (Exception e) {
					System.err.println(e.getMessage());
				}
				System.out.println(result);
			}

	}


