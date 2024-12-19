
public class Library {

    public String libraryName;
    public Book book1, book2, book3;

    public void addBook(Book book, int slot) {
        switch (slot) {
            case 1:
                book1 = book;
                break;
            case 2:
                book2 = book;
                break;
            case 3:
                book3 = book;
                break;
            default:
                break;
        }
    }

    public void removeBook(int slot) {
        switch (slot) {
            case 1:
                book1 = null;
                break;
            case 2:
                book2 = null;
                break;
            case 3:
                book3 = null;
                break;
            default:
                break;
        }
    }

    public void printLibraryDetails() {
        System.out.println("Library: "+libraryName);
        System.out.println("");
        if (book1 != null){
            book1.printDetails();
        }else{
            System.out.println("No book in this slot.");
        }
        System.out.println("");
        if (book2 != null){
            book2.printDetails();
        }else{
            System.out.println("No book in this slot.");
        }
        System.out.println("");
        if (book3 != null){
            book3.printDetails();
        }else{
            System.out.println("No book in this slot.");
        }
    }

    public void checkBookAvailability(int slot) {
        switch (slot) {
            case 1:
                if (book1 == null) {
                    System.out.println("Book in slot 1 is not available.");
                } else {
                    System.out.println(book1.title + " is available.");
                }
                break;
            case 2:
                if (book2 == null) {
                    System.out.println("Book in slot 2 is not available.");
                } else {
                    System.out.println(book2.title + " is available.");
                }
                break;
            case 3:
                if (book3 == null) {
                    System.out.println("Book in slot 3 is not available.");
                } else {
                    System.out.println(book3.title + " is available.");
                }
                break;
        }
    }
    
    public void updateBookPrice(int slot, double newPrice) {
        switch (slot) {
            case 1:
                if (book1 == null) {
                    System.out.println("No book in this slot.");
                } else {
                    book1.price = newPrice;
                    System.out.println("Updated price of " + book1.title + " to $" + newPrice + ".");
                }
                break;
            case 2:
                if (book2 == null) {
                    System.out.println("No book in this slot.");
                } else {
                    book2.price = newPrice;
                    System.out.println("Updated price of " + book2.title + " to $" + newPrice + ".");
                }
                break;
            case 3:
                if (book3 == null) {
                    System.out.println("No book in this slot.");
                } else {
                    book3.price = newPrice;
                    System.out.println("Updated price of " + book3.title + " to $" + newPrice + ".");
                }
                break;
            default:
                break;
        }
    }
    
    public void printBookDetails(Book book){
        if (book == null){
            System.out.println("No book in this slot.");
        }
        else{
            book.printDetails();
        }
    }
}