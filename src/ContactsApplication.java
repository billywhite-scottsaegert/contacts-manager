import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ContactsApplication {

    public static void main(String[] args) throws IOException {

        String userInput = null;
        do {
            System.out.println(menu());
            userInput = scan.nextLine();
            String path = "src/contacts";
            switch(userInput){
                case "1":
                    System.out.println(viewContacts(path));
                    break;
                case "2":
                    addContacts(path);
                    break;
                case "3":
                    searchContacts(path);
                    break;
                case "4":
                    removeContacts(path);
                    break;
                case "5":
                    System.exit(1);;
                    break;
            }
        } while(!userInput.equals("0"));


    }

    static Scanner scan = new Scanner(System.in);




///////////Display Menu
    public static String menu() {
        return "1. View contacts.\n" + "2. Add a new contact.\n" + "3. Search a contact by name.\n" + "4. Delete an existing contact.\n" + "5. Exit.\n" + "\nEnter an option (1, 2, 3, 4 or 5):";
    }

///////////View all Contacts
    public static String viewContacts(String filepath) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get(filepath));
        StringBuilder builder = new StringBuilder();
        for (String value : lines) {
            builder.append(value + "\n");
        }
        return builder.toString();
        }

///////////Search for a Contact
    public static StringBuilder searchContacts(String filepath) throws IOException {
            System.out.println("Who are you looking for?");
            String userInput = scan.nextLine();
            List<String> lines = Files.readAllLines(Paths.get(filepath));
            StringBuilder builder = new StringBuilder();
            builder.append("Name | Phone Number\n");
            builder.append("-------------------\n");
            for (String string : lines) {
                if(string.matches("(?i)(" + userInput + ").*")){
                    builder.append(string + "\n");
                }
            }
            System.out.println(builder);
            return builder;
        }

///////////Delete a Contact
    public static void removeContacts(String filepath) throws IOException {
        System.out.println(viewContacts(filepath));
        System.out.println("What Contact would you like to delete? (Please type full name)");
        String userInput = scan.nextLine();
        List<String> lines = Files.readAllLines(Paths.get(filepath));
        ArrayList<String> builder = new ArrayList<String>();
        for (String string : lines) {
            if(! string.matches("(?i)(" + userInput + ").*")){
                builder.add(string);
            }
        }
        try {
            Files.write(Paths.get(filepath), builder, StandardOpenOption.TRUNCATE_EXISTING);
        } catch (IOException e) {
            System.out.printf("Error");
        }
        System.out.println(viewContacts(filepath));
    }

///////////Add a Contact
    public static void addContacts(String filepath) throws IOException {
        System.out.println("Please type full name");
        String name = scan.nextLine();
        System.out.println("Please contacts phone number");
        String phone = scan.nextLine();
        ArrayList<String> builder = new ArrayList<String>();
        builder.add(name + " | " + phone);

        try {
            Files.write(Paths.get(filepath), builder, StandardOpenOption.APPEND);
        } catch (IOException e) {
            System.out.printf("Error");
        }
        System.out.println(viewContacts(filepath));
    }




 }



