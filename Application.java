import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Application {
    public static void main(String[] args) {
        try {
            File file = new File("note.txt");
            FileInputStream fis = new FileInputStream(file);
            System.out.println("Le fichier a été trouvé et ouvert avec succès!");

            // Création d'un BufferedReader à partir d'un FileReader
            BufferedReader br = new BufferedReader(new FileReader(file));
            FileOutputStream fos = new FileOutputStream("test.txt");

            String line;
            while ((line = br.readLine()) != null) {
                // Séparation de la ligne en parties avec ";"
                StringTokenizer tokenizer = new StringTokenizer(line, ";");
                
                // Parcourir les parties de la ligne
                String note = null;
                while (tokenizer.hasMoreTokens()) {
                    note = tokenizer.nextToken().trim(); // Récupérer la dernière partie (la note)
                }
                
                if (note != null && !note.isEmpty()) {
                    // Écrire la note dans le FileOutputStream
                    fos.write(note.getBytes());
                    fos.write(System.lineSeparator().getBytes()); // Ajouter un saut de ligne
                }
            }
            
            // Fermeture des flux
            fis.close();
            fos.close();
            System.out.println("Les notes ont été écrites avec succès dans le fichier test.txt !");
        } catch (FileNotFoundException e) {
            System.out.println("Le fichier spécifié n'a pas été trouvé dsl: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Une erreur s'est produite lors de la lecture ou de l'écriture dans le fichier : " + e.getMessage());
        }
    }
}
