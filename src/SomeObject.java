import java.io.Serializable;

public class SomeObject implements Serializable {

  private String name;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public SomeObject(String name) {
    this.name = name;
  }
}
