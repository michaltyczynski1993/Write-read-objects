import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class App {

  public static void main(String[] args) throws Exception {
    SomeObject obj1 = new SomeObject("someobject 1");
    SomeObject obj2 = new SomeObject("someobject 2");

    ArrayList<SomeObject> lista = new ArrayList<SomeObject>();
    lista.add(obj1);
    lista.add(obj2);

    // save data to list
    try {
      FileOutputStream file = new FileOutputStream("savedList.txt");
      ObjectOutputStream object = new ObjectOutputStream(file);
      object.writeObject(lista);
      object.flush();
      object.close();
    } catch (IOException e) {
      e.printStackTrace();
    }

    // read data from file
    try { // define data to deserialize and readStream object
      FileInputStream readData = new FileInputStream("savedList.txt");
      ObjectInputStream readStream = new ObjectInputStream(readData);

      ArrayList<SomeObject> someOtherList = (ArrayList<SomeObject>) readStream.readObject();
      readStream.close();

      for (SomeObject object : someOtherList) {
        System.out.println(object.getName());
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
