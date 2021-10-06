package homeLab;

import security.*;

import static homeLab.InputOutput.*;

public class Menu {
    public static void printMenu() {
        System.out.println(
                "==============================\n" +
                        "1. Add password\n" +
                        "2. Remove password\n" +
                        "3. Change password\n" +
                        "4. Show password\n" +
                        "=============================="
        );
    }

    public static void printError() {
        System.out.println(
                "==============================\n" +
                        "-* Invalid option\n" +
                        "=============================="
        );
    }

    public static void printKeyMenu() {//TODO: choice menu
        System.out.print("-. Use existing key? [y/N] ");
        boolean choice = getInputBool(false);
        if (choice) {
            System.out.println("NOT IMPLEMENTED");
        }
        else {
            System.out.println(".- Using single key...");
            System.out.println(".- Insert password:");
            String password = getInput();
            Key key = PBKDF2.generateKey(password,"",0,0,0);
        }
    }

    public static DatabaseEntry printAddMenu() {
        System.out.println("=========Add Password=========\n");
        System.out.print("-. Password:");
        String password = getInput();
        System.out.print("-. Username:");
        String username = getInput();
        System.out.print("-. Email:");
        String email = getInput();
        System.out.print("-. Website:");
        String website = getInput();
        System.out.println("==============================");

        return new DatabaseEntry(password.getBytes(),username,email,website);
    }

    public static void printRemoveMenu() {
        System.out.println(
                "========Remove Password=======\n" +
                        "-. placeholder\n" + //TODO: placeholder
                        "=============================="
        );
    }

    public static void printChangeMenu() {
        System.out.println(
                "========Change Password=======\n" +
                        "-. placeholder\n" + //TODO: placeholder
                        "=============================="
        );
    }

    public static void printSelector() {
        System.out.print(
                ">"
        );
    }
}
