import Criptography.Criptography;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.IOException;

public class Main {

    public static void main (String[] args) throws NoSuchAlgorithmException, IOException  {
        
        Scanner scanner = null;

        try {

            scanner = new Scanner(new FileReader("base.txt")).useDelimiter("\\||\\\n");
        } 

        catch (FileNotFoundException ex) {

            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);

        }

        long start = System.currentTimeMillis();

        while (scanner.hasNext()) {

          String name = scanner.next();
          String password = scanner.next();
          System.out.println(name);
          System.out.println(password);

          System.out.print("Cifra de Cesar: ");
          System.out.println(Criptography.decryptCaesarCipher(password, 12));

          System.out.print("SHA-1: ");
          System.out.println(Criptography.SHA1(password));

          System.out.print("SHA-256: ");
          System.out.println(Criptography.SHA256(password));

          System.out.print("MD5: ");
          System.out.println(Criptography.MD5(password));

        }

        long elapsed = System.currentTimeMillis() - start;
   
    }
    
}