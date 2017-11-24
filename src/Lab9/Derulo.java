package Lab9;

import javax.json.Json;
import javax.json.JsonWriter;
import java.io.FileWriter;

public class Derulo {

    public void create(){
        try {
            JsonWriter jsonWriter = Json.createWriter(new FileWriter("C:\\Users\\Patryk\\Documents\\FileJava\\patryk.json"));
            jsonWriter.writeObject(Json.createObjectBuilder().build());
            jsonWriter.close();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }





    }
}
