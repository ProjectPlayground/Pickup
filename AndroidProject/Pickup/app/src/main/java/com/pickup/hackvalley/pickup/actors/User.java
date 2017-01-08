package actors;

import java.util.List;

public class User {
  private String username;
  private String email;
  private String password; // I don't care!! it's not a real app!!
  private String fullName;
  private String phoneNumber;
  private String location;
  private String height;
  private String weight;
  private String wingspan;
  private int age;
  private String externalLink;
  private String description;
  
  private String favoriteSport;
  private List<SportPerformanceStats> playedSports;
  private List<String> eventHistory;
  public User(String username, String email, String password, String fullName, String phoneNumber, String location,
      String height, String weight, String wingspan, int age, String externalLink, String description,
      String favoriteSport, List<SportPerformanceStats> playedSports, List<String> eventHistory) {
    this.username = username;
    this.email = email;
    this.password = password;
    this.fullName = fullName;
    this.phoneNumber = phoneNumber;
    this.location = location;
    this.height = height;
    this.weight = weight;
    this.wingspan = wingspan;
    this.age = age;
    this.externalLink = externalLink;
    this.description = description;
    this.favoriteSport = favoriteSport;
    this.playedSports = playedSports;
    this.eventHistory = eventHistory;
  }
  public String getUsername() {
    return username;
  }
  public void setUsername(String username) {
    this.username = username;
  }
  public String getEmail() {
    return email;
  }
  public void setEmail(String email) {
    this.email = email;
  }
  public String getPassword() {
    return password;
  }
  public void setPassword(String password) {
    this.password = password;
  }
  public String getFullName() {
    return fullName;
  }
  public void setFullName(String fullName) {
    this.fullName = fullName;
  }
  public String getPhoneNumber() {
    return phoneNumber;
  }
  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }
  public String getLocation() {
    return location;
  }
  public void setLocation(String location) {
    this.location = location;
  }
  public String getHeight() {
    return height;
  }
  public void setHeight(String height) {
    this.height = height;
  }
  public String getWeight() {
    return weight;
  }
  public void setWeight(String weight) {
    this.weight = weight;
  }
  public String getWingspan() {
    return wingspan;
  }
  public void setWingspan(String wingspan) {
    this.wingspan = wingspan;
  }
  public int getAge() {
    return age;
  }
  public void setAge(int age) {
    this.age = age;
  }
  public String getExternalLink() {
    return externalLink;
  }
  public void setExternalLink(String externalLink) {
    this.externalLink = externalLink;
  }
  public String getDescription() {
    return description;
  }
  public void setDescription(String description) {
    this.description = description;
  }
  public String getFavoriteSport() {
    return favoriteSport;
  }
  public void setFavoriteSport(String favoriteSport) {
    this.favoriteSport = favoriteSport;
  }
  public List<SportPerformanceStats> getPlayedSports() {
    return playedSports;
  }
  public void setPlayedSports(List<SportPerformanceStats> playedSports) {
    this.playedSports = playedSports;
  }
  public List<String> getEventHistory() {
    return eventHistory;
  }
  public void setEventHistory(List<String> eventHistory) {
    this.eventHistory = eventHistory;
  }
  @Override
  public String toString() {
    return "User [username=" + username + ", email=" + email + ", password=" + password + ", fullName=" + fullName
        + ", phoneNumber=" + phoneNumber + ", location=" + location + ", height=" + height + ", weight=" + weight
        + ", wingspan=" + wingspan + ", age=" + age + ", externalLink=" + externalLink + ", description=" + description
        + ", favoriteSport=" + favoriteSport + ", playedSports=" + playedSports + ", eventHistory=" + eventHistory
        + "]";
  }

  
 
}
