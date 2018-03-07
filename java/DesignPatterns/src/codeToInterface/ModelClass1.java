package codeToInterface;

public class ModelClass1 {
    private  Connection connection;

    public ModelClass1(Connection connection) {
        this.connection = connection;
    }

    public String connectToDB(){

        return this.connection.connect();
    }
}
