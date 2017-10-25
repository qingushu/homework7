import java.io.Serializable;

public class TransientStaticVariable implements Serializable{

      public TransientStaticVariable() {
          System.out.println("Constructort");
      }
      public transient String variableOne;
      public transient String variableTwo = "V2";
      public static String variableThree;
      public static String variableFour = "V4";
      public transient static String variableFive;
      public transient static String variableSix = "V6";

}
