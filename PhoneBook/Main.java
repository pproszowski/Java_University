import java.util.TreeMap;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.*;

public class Main{
    public static void main(String[] args){

        TreeMap<PhoneNumber, Record> phoneBook = new TreeMap<PhoneNumber, Record>();

        PhoneNumber phoneNumber = new PhoneNumber("48", "505570144");
        phoneBook.put(phoneNumber, new Person("Piotr", "Proszowski", "Koralowa 13, 13-133 Łąka", phoneNumber));

        phoneNumber = new PhoneNumber("47", "2342342");
        phoneBook.put(phoneNumber, new Person("Andrzej", "Nowak", "Brzeznicka 94, 42-233 Las" , phoneNumber));

        phoneNumber = new PhoneNumber("40", "567234566");
        phoneBook.put(phoneNumber,new Company("Bocian", "Stefana Korala 13, 26-234, Jezioro" , phoneNumber));

        phoneNumber = new PhoneNumber("76","666574837");
        phoneBook.put(phoneNumber,new Person("Witold", "Pokrzywa", "Brzozowa 16, 27-859 Czarna Dziura" , phoneNumber));

        phoneNumber = new PhoneNumber("38", "2342342");
        phoneBook.put(phoneNumber,new Company("Bodziek", "Konopki 19, 97-500, Radomsko" , phoneNumber));

        phoneNumber = new PhoneNumber("23","345678765");
        phoneBook.put(phoneNumber,new Person("Karolina", "Japko", "Myszka 65, 65-678 Klawiatura", phoneNumber));

        phoneNumber = new PhoneNumber("10", "947362495");
        phoneBook.put(phoneNumber,new Company("Czerwona Latarnia", "Morska 76, 98-231, Morze" , phoneNumber));

        Collection c = phoneBook.values();
        Iterator it = c.iterator();

        while(it.hasNext()){
            Record record = (Record) it.next();
            System.out.println(record.getDescription());
        }
    }

}
