package codeToInterface;

public class MySqlConnection  implements Connection{

    @Override
    public String connect() {
        return "Connected to MySql";
    }
}
