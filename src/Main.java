import jodd.json.JsonParser;
import jodd.json.JsonSerializer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);
    public static Book book;

    public static void main(String[] args) throws Exception{
        boolean b = true;
        try{
            loadBook();
        } catch (FileNotFoundException e) {
            System.out.println("Error: no books found.");
            book = new Book();
        }
        while(b){
            System.out.println("What would you like to do? [1. New Book | 2. Update Book | 3. Exit]");
            String choice = scanner.nextLine();
            switch (choice){
                case "1":
                    newBook();
                    break;
                case "2":
                    updateBook();
                case "3":
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }

    }

    public static void newBook() throws Exception {
        book.chooseTitle();
        book.chooseAuthor();
        book.chooseGenre();
        book.chooseLengthPgs();
        book.chooseRating();
        saveBook();
    }

    public static void updateBook() throws Exception {
        System.out.println("Which category would you like to update? [1. Title | 2. Author | 3. Genre | 4. Length | 5. Rating]");
        String updateChoice = scanner.nextLine();
        switch (updateChoice) {
            case "1":
                book.chooseTitle();
                break;
            case "2":
                book.chooseAuthor();
                break;
            case "3":
                book.chooseGenre();
                break;
            case "4":
                book.chooseLengthPgs();
                break;
            case "5":
                book.chooseRating();
                break;
            default:
                System.out.println("Invalid Choice");
        }
         saveBook();
        loadBook();


    }

    public static void saveBook() throws IOException{
        JsonSerializer s = new JsonSerializer();
        String json = s.serialize(book);
        File f = new File("book.json");
        FileWriter fw = new FileWriter(f);
        fw.write(json);
        fw.close();
    }

    public static void loadBook() throws FileNotFoundException{
        File f = new File("book.json");
        Scanner s = new Scanner(f);
        s.useDelimiter("\\Z");
        String contents = s.next();
        s.close();
        JsonParser p = new JsonParser();
        book = p.parse(contents, Book.class);
        System.out.println(book);


    }

}
