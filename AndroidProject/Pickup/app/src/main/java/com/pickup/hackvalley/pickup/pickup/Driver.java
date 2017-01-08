package pickup;

public class Driver {
  
  public static MainClass system = new MainClass();
  
 
  public static void main(String [] args){
    boolean success = system.Login("catchmeonthecourt", "airgordon00");
    System.out.println("was it succesful? " + success);
  }

}
