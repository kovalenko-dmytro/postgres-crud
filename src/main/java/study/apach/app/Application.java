package study.apach.app;

import study.apach.controllers.BookController;
import study.apach.controllers.MainController;

public class Application {

    private InputHelper helper;
    private BookController bookController;
    private MainController mainController;

    public Application() {
        helper = new InputHelper();
        bookController = new BookController();
        mainController = new MainController();
    }

    public void run () {
        mainController.index();

        String input = helper.getOperation("Enter operation: ");
        int currentId = 0;

        if (!"exit".equals(input)) {
            while (!"exit".equals(input)) {
                switch (input) {
                    case "list":
                        bookController.getBooks();
                        input = helper.getOperation("Back to index? [index], " +
                                                            "View book? [id]");
                        if ("index".equals(input)) {
                            mainController.index();
                            input = helper.getOperation("Enter operation: ");
                        } else {
                            currentId = Integer.parseInt(input);
                            bookController.viewBook(currentId);
                            input = helper.getOperation("Update? [update], " +
                                                                "Delete? [delete], " +
                                                                "Back to list? [list]");
                        }
                        break;
                    case "create":
                        bookController.createBook(helper.getInputData());
                        input = "list";
                        break;
                    case "update":
                        bookController.updateBook(currentId, helper.getInputData());
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
}
