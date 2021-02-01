package one.bestgo.customdata;

import java.util.Map;
import java.util.Optional;

public class  VendingMachine {
  private int amountAccepted;
  private Map<Product, Integer> inventory;

  private enum state {
    ERROR,              // system in error. can't serve customers
    DOWN,               // power down
    READY,              // power up. no money yet and ready to accept cash
    ACTIVATED,          // accepted some cash
    READY_TO_DISPENSE,  // accepted enough money
    DISPENSED,
    CANCELLED           // when user canceled the transaction
  }

  // for admin
  public void fillInventory(Product product, int number) {}
  public int leftoverByProduct(Product product) { return 0; }
  private void alert() {}

  // customers
  public int addCoins(Coins coin, int number) { return 0; } // -1 means not accepted.
  public int addBills(Bills bill, int number) { return 0; } // returns accepted amount
  public Optional<Product> buy(Product product) { return null; }
  public void cancel() {}  // return money when customer wants to cancel.
  public void takeProduct() {}

  // internal
  protected void dispalyError() {}    // in case insufficient cash accepted but customer tried to buy
  protected void giveBackChange() {}  // after buy, when there is some cash to return.
}
