package hu.nive.ujratervezes.kepesitovizsga.phonebook;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;

public class Phonebook {


    public void exportPhonebook(Map<String, String> contacts, String output) {
        checkParameters(contacts, output);
        try (BufferedWriter writer = Files.newBufferedWriter(Path.of(output))) {
            writeEntries(contacts, writer);
        } catch (IOException ioe) {
            throw new IllegalStateException("Cannot write file", ioe);
        }
    }

    private void writeEntries(Map<String, String> contacts, BufferedWriter writer) throws IOException {
        for (Map.Entry<String, String> entry : contacts.entrySet()) {
            String name = entry.getKey();
            String phoneNumberStr = entry.getValue();
            writer.write(name + ": " + phoneNumberStr + '\n');
        }
    }


    private void checkParameters(Map<String, String> contacts, String output) {
        if (contacts == null || output == null) {
            throw new IllegalArgumentException("Wrong parameter");
        }
    }


  

}

  /*  Egy alkalmazást írunk, ahol a megrendelő szeretné az alkalmazásban tárolt ügyfeleit és azok telefonszámát exportálni fájlba.

        Hozd létre a Phonebook osztályt, és abban az exportPhonebook(Map<String, String> contacts, String output) metódust!

        A paraméterben kapott mapben a kulcsok nevek, az értékek pedig telefonszámok. Írd ki az összes kulcs-érték párt az outputként
        megadott címre, minden kulcs-érték párt egy új sorba, az alábbi szintaxisban:

        név: telefonszám

        A kiírás sorrendje a fájlba nem fontos, de a map összes elemét pontosan egyszer írd ki a fájlba!

        Láthatod, hogy a tesztesetek a phonebookOutput könyvtárba dolgoznak. Ezt hozd létre, hogy az osztályod tudjon bele írni!

        Nem szükséges figyelni arra, hogy ne tárold a teljes fájltartalmat memóriában. Azaz használhatsz akár Files egy metódusát
        fájlba írásra, akár Writer példányt is.

        Ha a metódus akármelyik paraméternek null értéket kapna, akkor dobj IllegalArgumentException-t!*/
