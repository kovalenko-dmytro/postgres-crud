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

    public void run() {

        mainController.index();

        String input = helper.getOperation("Enter operation: ");
        int currentId = 0;

        while (!input.equals(CommandType.EXIT.getCommandType())) {

            if (CommandType.contains(input)) {

                switch (input) {
                    case "list":
                        bookController.getBooks();
                        input = helper.getOperation("");
                        if ("index".equals(input)) {
                            mainController.index();
                            input = helper.getOperation("Enter operation: ");
                        } else {
                            try {
                                currentId = Integer.parseInt(input);
                                bookController.viewBook(currentId);
                                input = helper.getOperation("");
                            } catch (NumberFormatException e) {
                                System.out.println("WARNING!!! ID is not number! Enter correct ID");
                                input = "list";
                            }
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

            } else {
                input = helper.getOperation("Operation name uncorrected. Enter operation: ");
            }

        }

    }
}
