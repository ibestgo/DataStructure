package one.bestgo.customdata;

public enum Coins {
  QUARTER(25),
  DIME(10),
  Nikel(5),
  Penny(1);

  private final int value;

  // only private or package-private ctor is allowed. No public/protected ctor
  private Coins(int value) {
    this.value = value;
  }
}
