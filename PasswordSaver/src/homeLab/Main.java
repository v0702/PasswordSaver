package homeLab;

import security.Key;
import security.PBKDF2;
import security.Security;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static homeLab.InputOutput.getInput;

public class Main {

    public static void main(String[] args) {
        DatabaseConnectivity db = new DatabaseConnectivity();
        db.DatabaseConnect();

        while (true) {
            Menu.printMenu();
            Menu.printSelector();
            int choice = -1;
            try {
                choice = Integer.parseInt(getInput());//TODO: temporary
            } catch (Exception ignored) {
                Menu.printError();
            }
            switch (choice) {
                case 0://exit
                    db.CloseDatabaseConnect();
                    System.exit(0);
                    break;
                case 1://add new password entry
                    DatabaseEntry entry = Menu.printAddMenu();
                    byte[] cipher = Security.encryptSecurity(entry.getPassword(),"1234567890123456".getBytes());
                    db.Insert(new DatabaseEntry(cipher,entry.getUsername(),entry.getEmail(),entry.getWebsite()));
                    break;
                case 2://remove entry
                    Menu.printRemoveMenu();
                    Menu.printSelector();
                    break;
                case 3://change existing
                    Menu.printChangeMenu();
                    Menu.printSelector();
                    break;
                case 4:// show all entries
                    Key key = PBKDF2.generateKey(getInput(),"",0,0,0);
                    System.out.println(Security.encodeBase64(key.getKey()));

                    DatabaseEntry[] values = db.Select();
                    for (DatabaseEntry value : values) {
                        System.out.println(value.toString());
                    }
                    break;
                default:
                    break;
            }
        }
    }
}
