package codeToInterface;

public class ModelClass2 {

    private  Connection connection;

    public ModelClass2(Connection connection) {
        this.connection = connection;
    }

    public String connectToDB(){

        return this.connection.connect();
    }
}
