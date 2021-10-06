package homeLab;

import security.Security;

public class DatabaseEntry {
    int id;
    private final byte[] password; //always ciphered
    private final String username;
    private final String email;
    private final String website;

    public DatabaseEntry(int id, String password, String username, String email, String website) {
        this.id = id;
        this.password = password.getBytes();
        this.username = username;
        this.email = email;
        this.website = website;
    }
    public DatabaseEntry(String password, String username, String email, String website) {
        this.id = -1;
        this.password = password.getBytes();
        this.username = username;
        this.email = email;
        this.website = website;
    }
    public DatabaseEntry(byte[] password, String username, String email, String website) {
        this.id = -1;
        this.password = password;
        this.username = username;
        this.email = email;
        this.website = website;
    }
    public DatabaseEntry(int id, byte[] password, String username, String email, String website) {
        this.id = id;
        this.password = password;
        this.username = username;
        this.email = email;
        this.website = website;
    }

    public int getId() {
        return id;
    }
    public byte[] getPassword() {
        return password;
    }
    public String getUsername() {
        return username;
    }
    public String getEmail() {
        return email;
    }
    public String getWebsite() {
        return website;
    }

    @Override
    public String toString() {
        return "-------------" +
                " id=" + id +
                " password=" + Security.byteArrayToString(Security.decipherSecurity(password,"1234567890123456".getBytes())) +
                " username=" + username +
                " email=" + email +
                " website=" + website;
    }
}
