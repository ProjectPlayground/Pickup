package actors;

import java.util.Date;

public class Event {
  
  private int id;
  private String eventTitle;
  private Date date;
  private String location; // Location class, import android.location.Location
  private String host;
  private String sport;
  private String additionalInfo;
  private boolean requiresApproval;
  private int numLookingFor; // how many participants you're looking for
  
  private double price;
  private String priceReason; // reason why there is a price
  
  public Event(int id, String eventTitle, Date date, String location, String host, String sport, String additionalInfo,
      boolean requiresApproval, int numLookingFor, double price, String priceReason) {
    this.id = id;
    this.eventTitle = eventTitle;
    this.date = date;
    this.location = location;
    this.host = host;
    this.sport = sport;
    this.additionalInfo = additionalInfo;
    this.requiresApproval = requiresApproval;
    this.numLookingFor = numLookingFor;
    this.price = price;
    this.priceReason = priceReason;
  }
  



  @Override
  public String toString() {
    return "Event [id=" + id + ", eventTitle=" + eventTitle + ", date=" + date + ", location=" + location + ", host="
        + host + ", sport=" + sport + ", additionalInfo=" + additionalInfo + ", requiresApproval=" + requiresApproval
        + ", numLookingFor=" + numLookingFor + ", price=" + price + ", priceReason=" + priceReason + "]";
  }

  
}
