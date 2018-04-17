package study.apach.app;

import study.apach.controllers.BookController;
import study.apach.controllers.CategoryController;
import study.apach.controllers.MainController;

public class Application {

    private InputHelper helper;
    private MainController mainController;
    private BookController bookController;
    private CategoryController categoryController;

    private int currentId = 0;
    private String input;

    public Application() {
        helper = new InputHelper();
        mainController = new MainController();
        bookController = new BookController();
        categoryController = new CategoryController();
    }

    public void run() {

        mainController.index();

        input = helper.getOperation("Enter operation: ");

        while (!input.equals(CommandType.EXIT.getCommandType())) {

            if (CommandType.contains(input)) {

                switch (input) {
                    case "list":
                        bookController.getBooks();
                        input = helper.getOperation("");
                        indexOrId(input);
                        break;
                    case "create":
                        categoryController.getCategories();
                        bookController.createBook(helper.getInputData());
                        input = "list";
                        break;
                    case "update":
                        categoryController.getCategories();
                        bookController.updateBook(currentId, helper.getInputData());
                        input = "list";
                        break;
                    case "delete":
                        bookController.deleteBook(currentId);
                        input = "list";
                        break;
                    case "sbn":
                        categoryController.getCategories();
                        input = helper.getOperation("Enter category: ");
                        bookController.getBooks(input);
                        input = helper.getOperation("");
                        indexOrId(input);
                        break;
                }

            } else {
                input = helper.getOperation("Operation name uncorrected. Enter operation: ");
            }

        }

    }

    private void indexOrId(String input) {
        if ("index".equals(input)) {
            mainController.index();
            this.input = helper.getOperation("Enter operation: ");
        } else {
            try {
                currentId = Integer.parseInt(input);
                bookController.viewBook(currentId);
                this.input = helper.getOperation("");
            } catch (NumberFormatException e) {
                System.out.println("WARNING!!! ID is not number! Enter correct ID");
                this.input = "list";
            }
        }
    }
}
