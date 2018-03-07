package codeToInterface;

import org.junit.Assert;
import org.junit.Test;


public class codeToInterfaceTest {


    @Test
    public void TestDifferentConnections(){
        Connection mySqlConnection = new MySqlConnection();
        Connection oracleConnection = new OracleConnection();
        ModelClass1 modelClass1 =  new ModelClass1(mySqlConnection);
        ModelClass2 modelClass2 =  new ModelClass2(oracleConnection);

        Assert.assertEquals("Connected to MySql", modelClass1.connectToDB());
        Assert.assertEquals("Connected to Oracle", modelClass2.connectToDB());

    }
}
