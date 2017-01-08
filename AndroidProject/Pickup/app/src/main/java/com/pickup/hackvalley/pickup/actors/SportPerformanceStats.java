package actors;

public class SportPerformanceStats extends Sport {
  private int wins;
  private int losses;
  private int draws;
  
  public SportPerformanceStats(String name, int wins, int losses, int draws) {
    super(name);
    this.wins = wins;
    this.losses = losses;
    this.draws = draws;
  }

  @Override
  public String toString() {
    return "SportPerformanceStats [ " + super.getName() + " wins=" + wins + ", losses=" + losses + ", draws=" + draws + "]";
  }
}
