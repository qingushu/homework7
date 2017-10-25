import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Serialization {

 public static void main(String[] args) throws IOException {
 TransientStaticVariable staticVariable = new TransientStaticVariable();
 staticVariable.variableOne = "V11";
 staticVariable.variableTwo = "V22";
 staticVariable.variableThree = "V33";
 staticVariable.variableFour = "V44";
 staticVariable.variableFive = "V55";
 staticVariable.variableSix = "V66";


 FileOutputStream fileOutputStream = new FileOutputStream("transientstatic.ser");
 ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
 objectOutputStream.writeObject(staticVariable);
 }

}
