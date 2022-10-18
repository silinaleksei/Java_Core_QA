package lesson8.project;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public class UserInterface {

    private final Controller controller = new Controller();

    public void runApplication() throws IOException {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Enter the name of the city in English");
            String city = scanner.nextLine();

            setGlobalCity(city);

            System.out.println("Enter the answer: 1 - Get the current weather, " +
                    "2 - Get the weather for the next 5 days, " +
                    "3 - Get data from BD, " +
                    "exit - over the work");
            String result = scanner.nextLine();

            checkIsExit(result);

            validateUserInput(result);

            try {
                notifyController(result);
            } catch (IOException | SQLException e) {
                e.printStackTrace();
            }

        }
    }

    private void checkIsExit(String result) {
        if (result.equalsIgnoreCase("выход") || result.equalsIgnoreCase("exit")) {
            System.out.println("Completing the work");
            System.exit(0);
        }
    }

    private void setGlobalCity(String city) {
        ApplicationGlobalState.getInstance().setSelectedCity(city);
    }


    private void validateUserInput(String userInput) throws IOException {
        if (userInput == null || userInput.length() != 1) {
            throw new IOException("Incorrect user input: expected one digit as answer, but actually get " + userInput);
        }
        int answer = 0;
        try {
            answer = Integer.parseInt(userInput);
        } catch (NumberFormatException e) {
            throw new IOException("Incorrect user input: character is not numeric!");
        }
    }

    private void notifyController(String input) throws SQLException, IOException {
        controller.onUserInput(input);
    }

}
