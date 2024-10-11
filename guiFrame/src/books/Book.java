package books;

import java.io.*;
import java.util.*;

public class Book implements Serializable {
    // class release version:

    private static final long serialVersionUID = 1L;
    // areas with prompts:
    String strISBN;
    public static final String P_STR_ISBN = "ISBN";
    String author;
    public static final String P_AUTHOR = "Author";
    String name;
    public static final String P_NAME = "Name";
    int year;
    public static final String P_YEAR = "Year";
    String publisher;
    public static final String P_PUBLISHER = "Publisher";
    double price;
    public static final String P_PRICE = "Price";
    String annotation;
    public static final String P_ANNOTATION = "Annotation";

    // validation methods:
    static boolean validISBN(String str) {
        int i = 0, ndig = 0;
        for (; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (Character.isDigit(ch)) {
                ndig++;
                continue;
            }
            if (ch != '-') {
                return false;
            }
        }
        return (ndig == 13 || ndig == 10);
    }

    private static final GregorianCalendar curCalendar = new GregorianCalendar();

    static boolean validYear(int year) {
        return year > 0 && year <= curCalendar.get(Calendar.YEAR);
    }

    public static boolean nextRead(Scanner fin, PrintStream out) {
        return nextRead(P_STR_ISBN, fin, out);
    }

    static boolean nextRead(final String prompt, Scanner fin, PrintStream out) {
        out.print(prompt);
        out.print(": ");
        return fin.hasNextLine();
    }

    public static final String AUTHOR_DEL = ",";

    public static Book read(Scanner fin, PrintStream out) throws IOException,
            NumberFormatException {
        String str;
        Book book = new Book();
        book.strISBN = fin.nextLine().trim();
        if (Book.validISBN(book.strISBN) == false) {
            throw new IOException("Invalid ISBN: " + book.strISBN);
        }
        if (!nextRead(P_AUTHOR, fin, out)) {
            return null;
        }
        book.author = fin.nextLine();
        if (!nextRead(P_NAME, fin, out)) {
            return null;
        }
        book.name = fin.nextLine();
        if (!nextRead(P_YEAR, fin, out)) {
            return null;
        }
        str = fin.nextLine();
        book.year = Integer.parseInt(str);
        if (Book.validYear(book.year) == false) {
            throw new IOException("Invalid Book.year value");
        }
        if (!nextRead(P_PUBLISHER, fin, out)) {
            return null;
        }
        book.publisher = fin.nextLine();
        if (!nextRead(P_ANNOTATION, fin, out)) {
            return null;
        }
        book.annotation = fin.nextLine();
        if (!nextRead(P_PRICE, fin, out)) {
            return null;
        }
        str = fin.nextLine();
        book.price = Double.parseDouble(str);
        return book;
    }

    public Book() {
    }
    
    public Book(String strBook) {
        String [] rows = strBook.split(Book.AREA_DEL);
        if (rows.length != 7) {
            throw new IllegalArgumentException("Illegal source string for Book");
        }
        setStrISBN(rows[0]);
        setAuthor(rows[1]);
        setName(rows[2]);
        setYear(rows[3]);
        setPublisher(rows[4]);
        setAnnotation(rows[5]);
        setPrice(rows[6]);
    }

    public static final String AREA_DEL = "\n";

    @Override
    public String toString() {
        return strISBN + AREA_DEL
                + author + AREA_DEL
                + name + AREA_DEL
                + year + AREA_DEL
                + publisher + AREA_DEL
                + annotation + AREA_DEL
                + price;
    }

    public String getStrISBN() {
        return strISBN;
    }

    public final void setStrISBN(String strISBN) {
        if (!validISBN(strISBN)) {
            throw new IllegalArgumentException("Illegal ISBN");
        }
        this.strISBN = strISBN;
    }

    public String getAuthor() {
        return author;
    }

    public final void setAuthor(String author) {
        if (author == null || author.isEmpty()) {
            throw new IllegalArgumentException("Illegal author");
        }
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public final void setName(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Illegal name");
        }
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public final void setYear(String strYear) {
        boolean isError = false;
        int y = 0;
        try {
            y = Integer.parseInt(strYear);
        } catch (Error | Exception e) {
            isError = true;
        }
        if (isError || !validYear(y)) {
            throw new IllegalArgumentException("Illegal year");
        }
        this.year = y;
    }

    public String getPublisher() {
        return publisher;
    }

    public final void setPublisher(String publisher) {
        if (publisher == null || publisher.isEmpty()) {
            throw new IllegalArgumentException("Illegal publisher");
        }
        this.publisher = publisher;
    }

    public String getAnnotation() {
        return annotation;
    }

    public final void setAnnotation(String annotation) {
        if (annotation == null || annotation.isEmpty()) {
            throw new IllegalArgumentException("Illegal annotation");
        }
        String[] strs = annotation.split(AREA_DEL);
        this.annotation = strs[0];
        for (int i = 1; i < strs.length; i++) {
            this.annotation += " " + strs[i];
        }
    }

    public double getPrice() {
        return price;
    }

    public final void setPrice(String strPrice) {
        boolean isError = false;
        double p = 0;
        try {
            p = Double.parseDouble(strPrice);
        } catch (Error | Exception e) {
            isError = true;
        }
        if (isError || p <= 0) {
            throw new IllegalArgumentException("Illegal price");
        }
        this.price = p;
    }
}
