package codeToInterface;

public class OracleConnection implements Connection {
    @Override
    public String connect() {
       return "Connected to Oracle";
    }
}
