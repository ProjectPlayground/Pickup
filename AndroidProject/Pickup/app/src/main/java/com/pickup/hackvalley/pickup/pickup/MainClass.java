package pickup;

import actors.Event;
import actors.Sport;
import actors.SportPerformanceStats;
import actors.User;
import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;

public class MainClass {
  
  private List<User> users = new ArrayList<User>();
  private List<Event> events = new ArrayList<Event>();
  private static User currentUser;
  
  public DateFormat sourceFormat = new SimpleDateFormat("MM/dd/yyyy kk:mm");

  public MainClass() {
    // populate with all created events
    File folder = new File(Constants.EVENTDATABASEPATH);
    for (File file : folder.listFiles()){
      if(file.length() != 0L) {
        // parse xml and make it a class
        int id;
        String eventTitle;
        Date date;
        String location; 
        String host;
        String sport;
        String additionalInfo;
        boolean requiresApproval;
        int numLookingFor; 
        
        double price;
        String priceReason;
        
        try { 
          DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
          DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
          Document doc = dBuilder.parse(file);
          doc.getDocumentElement().normalize();
          NodeList nList = doc.getElementsByTagName("eventHistory");
          for (int index = 0; index < nList.getLength(); index++) {
            Node nNode = nList.item(index);
            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
               Element element = (Element) nNode;
               id = Integer.parseInt(element.getElementsByTagName("id").item(0).getTextContent());
               eventTitle = element.getElementsByTagName("eventTitle").item(0).getTextContent();
               date = sourceFormat.parse(element.getElementsByTagName("date").item(0).getTextContent());
               location = element.getElementsByTagName("location").item(0).getTextContent();
               host = element.getElementsByTagName("host").item(0).getTextContent();
               sport = element.getElementsByTagName("sport").item(0).getTextContent();
               additionalInfo = element.getElementsByTagName("additionalInfo").item(0).getTextContent();
               requiresApproval = Integer.parseInt(element.getElementsByTagName("id").item(0).getTextContent()) == 1;
               numLookingFor = Integer.parseInt(element.getElementsByTagName("numLookingFor").item(0).getTextContent());
               String t = element.getElementsByTagName("price").item(0).getTextContent();
               price = t.equals("") ? 0 : Double.parseDouble(t);
               priceReason = element.getElementsByTagName("priceReason").item(0).getTextContent();
               Event event = new Event(id, eventTitle, date, location, host, sport, additionalInfo, requiresApproval,
                   numLookingFor, price, priceReason);
               events.add(event);
               print(event);
            }
          }
        }catch (Exception e) {
          e.printStackTrace();
        }
      }
    }
    // populate with registered users
    folder = new File(Constants.USERDATABASEPATH);
    for (File file : folder.listFiles()){
      if(file.length() != 0L) {
        // parse xml and make it a class
        String username;
        String email;
        String password; // I don't care!! it's not a real app!!
        String fullName;
        String phoneNumber;
        String location;
        String height;
        String weight;
        String wingspan;
        int age;
        String externalLink;
        String description;
        
        String favoriteSport;
        List<SportPerformanceStats> playedSports = new ArrayList<SportPerformanceStats>();
        List<String> eventHistory;
        
        try { 
          DocumentBuilderFactory dbFactory 
             = DocumentBuilderFactory.newInstance();
          DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
          Document doc = dBuilder.parse(file);
          doc.getDocumentElement().normalize();
          NodeList nList = doc.getElementsByTagName("user");
          for (int index = 0; index < nList.getLength(); index++) {
            Node nNode = nList.item(index);
            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
               Element element = (Element) nNode;
               username = element.getElementsByTagName("username").item(0).getTextContent();
               email = element.getElementsByTagName("email").item(0).getTextContent();
               password = element.getElementsByTagName("password").item(0).getTextContent();
               fullName = element.getElementsByTagName("fullName").item(0).getTextContent();
               phoneNumber = element.getElementsByTagName("phoneNumber").item(0).getTextContent();
               location = element.getElementsByTagName("location").item(0).getTextContent();
               height = element.getElementsByTagName("height").item(0).getTextContent();
               weight = element.getElementsByTagName("weight").item(0).getTextContent();
               wingspan = element.getElementsByTagName("wingspan").item(0).getTextContent();
               age = Integer.parseInt(element.getElementsByTagName("age").item(0).getTextContent());
               externalLink = element.getElementsByTagName("externalLink").item(0).getTextContent();
               description = element.getElementsByTagName("description").item(0).getTextContent();
               favoriteSport = element.getElementsByTagName("favoriteSport").item(0).getTextContent();
               eventHistory = Arrays.asList(element.getElementsByTagName("eventHistory").item(0).getTextContent().split("\\s*,\\s*"));
               NodeList perfList = element.getElementsByTagName("sportPerformance");
               for (int index2 = 0; index2 < perfList.getLength(); index2++) {
                 String name;
                 int wins;
                 int losses;
                 int draws;
                 Node nNode2 = perfList.item(index2);
                 if (nNode2.getNodeType() == Node.ELEMENT_NODE) {
                    element = (Element) nNode2;
                    name = element.getElementsByTagName("name").item(0).getTextContent();
                    wins = Integer.parseInt(element.getElementsByTagName("wins").item(0).getTextContent());
                    losses = Integer.parseInt(element.getElementsByTagName("losses").item(0).getTextContent());
                    draws = Integer.parseInt(element.getElementsByTagName("draws").item(0).getTextContent());
                    playedSports.add(new SportPerformanceStats(name, wins, losses, draws));
                 }
               }
               User user = new User(username, email, password, fullName, phoneNumber, location,
                   height, weight, wingspan, age, externalLink, description,
                   favoriteSport, playedSports, eventHistory);
               users.add(user);
            }
            
         }
        }catch (Exception e) {
          e.printStackTrace();
        }
      }
    }
  }
  
  // fed up with typing that long thing!
  public void print(Object str){
    System.out.println(str);
  }
  
  public boolean Login(String username, String password) {
    boolean success = false;
    // look for matching user
    for (int index = 0; index < users.size(); index++){
      User user = users.get(index);
      if (user.getUsername().equals(username) || user.getEmail().equals(username)) {
        // username inputted matches, check password
        if (user.getPassword().equals(password)) {
          // password matches, return true
          currentUser = user;
          success = true;
        }
        break;
      }
    }
    return success;
  }
  
  
}


