/**
 * Created by jeremypitt on 9/8/16.
 */
public class Book {
    private String title;
    private String author;
    private String genre;
    private int lengthPgs;
    private double rating;
    private String lengthInput;
    private String ratingInput;


    public void chooseTitle() {
        System.out.println("Enter the title of the book:");
        title = Main.scanner.nextLine();
    }

    public void chooseAuthor() {
        System.out.println("Enter the author's name:");
        author = Main.scanner.nextLine();
    }


    public void chooseGenre() {
        System.out.println("Enter the genre of the book:");
        genre = Main.scanner.nextLine();
    }

    public void chooseLengthPgs() {
        System.out.println("Enter the length of the book (in pages):");
        lengthInput = Main.scanner.nextLine();
        lengthPgs = Integer.parseInt(lengthInput);

    }

    public void chooseRating() {
        System.out.println("Enter the book's rating (0.0 - 10.0):");
        ratingInput = Main.scanner.nextLine();
        rating = Double.parseDouble(ratingInput);
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setLengthPgs(int lengthPgs) {
        this.lengthPgs = lengthPgs;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getGenre() {
        return genre;
    }

    public int getLengthPgs() {
        return lengthPgs;
    }

    public double getRating() {
        return rating;
    }

    @Override
    public String toString() {
        return String.format("Book title: %s | Author: %s | Genre: %s | Length: %s pages | Rating %s out of 10.0", title,
                author, genre, lengthPgs, rating);
    }


}
