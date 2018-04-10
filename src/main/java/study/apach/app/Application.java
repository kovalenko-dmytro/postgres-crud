package study.apach.app;

import study.apach.controllers.BookController;
import study.apach.model.entities.Book;

public class Application {

    InputHelper helper;
    private BookController bookController;

    public Application() {
        helper = new InputHelper();
        bookController = new BookController();
    }

    public void run () {
        menu();

        String input = helper.getOperation("Enter operation: ");
        int currentId = 0;

        if (!"exit".equals(input)) {
            while (!"exit".equals(input)) {
                switch (input) {
                    case "list":
                        bookController.getBooks();
                        input = helper.getOperation("Back to index? [index], View book? [id]");
                        if ("index".equals(input)) {
                            menu();
                            input = helper.getOperation("Enter operation: ");
                        } else {
                            currentId = Integer.parseInt(input);
                            bookController.viewBook(currentId);
                            input = helper.getOperation("Update? [update], Delete? [delete], Back to list? [list]");
                        }
                        break;
                    case "create":
                        Book newBook  = new Book();
                        newBook.setTitle(helper.getOperation("Enter a book title: "));
                        newBook.setAuthor(helper.getOperation("Enter a book author: "));
                        newBook.setCost(Double.parseDouble(helper.getOperation("Enter a book cost: ")));
                        bookController.createBook(newBook);
                        input = "list";
                        break;
                    case "update":
                        Book updateBook  = new Book();
                        updateBook.setTitle(helper.getOperation("Enter a book title: "));
                        updateBook.setAuthor(helper.getOperation("Enter a book author: "));
                        updateBook.setCost(Double.parseDouble(helper.getOperation("Enter a book cost: ")));
                        bookController.updateBook(currentId, updateBook);
                        input = "list";
                        break;
                    case "delete":
                        bookController.deleteBook(currentId);
                        input = "list";
                        break;
                }
            }
        }
    }



    private void menu() {
        System.out.println("*****************************************");
        System.out.println("|            BOOKS INDEX PAGE           |");
        System.out.println("*****************************************");
        System.out.println("| Options:                              |");
        System.out.println("|        'list'.   View list of books   |");
        System.out.println("|        'create'. Create book          |");
        System.out.println("|        'exit'.   Exit                 |");
        System.out.println("*****************************************");

    }
}
