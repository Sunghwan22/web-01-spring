package makao.bank3.models;

public class Account {

  private String identifier;
  private String name;
  private long amount;

  public Account(String identifier, String name, long amount) {
    this.identifier = identifier;
    this.name = name;
    this.amount = amount;
  }

  public long amount() {
    return amount;
  }

  public String identifier() {
    return identifier;
  }

  public String name() {
    return name;
  }

  public void transfer(Account receiver, long amount) {
    if(amount <= 0) {
      return;
    }

    this.amount -= amount;

    receiver.amount += amount;
  }
}
