package codeToInterface;

public class SqlServerConnection implements Connection{


    @Override
    public String connect() {
        return "Connected to sqlServer";
    }
}
