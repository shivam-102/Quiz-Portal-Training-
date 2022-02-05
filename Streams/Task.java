import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;

class Trader {
    private final String name;
    private String city;

    public Trader(String name, String city) {
        this.name = name;
        this.city = city;
    }

    public String getName() {
        return this.name;
    }

    public String getCity() {
        return this.city;
    }
    public void setCity(String city){
        this.city=city;
    }

    public String toString() {
        return "Trader:" + this.name + " in " + this.city;
    }
}
class Transaction {

    private final Trader trader;
    private final int year;
    private final int value;

    public Transaction(Trader trader, int year, int value) {
        this.trader = trader;
        this.year = year;
        this.value = value;
    }

    public Trader getTrader() {
        return this.trader;
    }

    public int getYear() {
        return this.year;
    }

    public int getValue() {
        return this.value;
    }

    public String toString() {
        return "{" + this.trader + ", " + "year: " + this.year + ", " + "value:" + this.value + "}";
    }
}

public class Task {
    public static void main(String[] args){
     Trader shivam=new Trader("Shivam","Cambridge");
     Trader deepak=new Trader("Deepak","Milan");
     Trader azhar=new Trader("Azhar","Cambridge");
     Trader durga=new Trader("Durga","Hyderabad");
     Trader raj=new Trader("Raj","New York");

     List<Transaction> transactionList= Arrays.asList(
             new Transaction(shivam,2011,3000),
             new Transaction(deepak,2010,2500),
             new Transaction(azhar,2011,2890),
             new Transaction(durga,2020,4500),
             new Transaction(raj,2011,5600)

     );
     //Question1
        List<Transaction> list=transactionList.stream()
                .filter(transaction -> transaction.getYear()==2011)
                .sorted(comparing(Transaction::getValue))
                .collect(toList());
        System.out.println(list);

     //Question2
        List<String> city=transactionList.stream()
                .map(transaction -> transaction.getTrader().getCity())
                .distinct()
                .collect(Collectors.toList());
        System.out.println(city);

        //Question 3
        List<Trader> traders=transactionList.stream()
                .map(Transaction::getTrader)
                .filter(trader -> trader.getCity().equals("Cambridge"))
                .distinct()
                .sorted(comparing(Trader::getName))
                .collect(Collectors.toUnmodifiableList());
        System.out.println(traders);

        //Question 4
        String trad=transactionList.stream()
                .map(transaction -> transaction.getTrader().getName())
                .sorted()
                .reduce("",(n1,n2)->n1+n2);
        System.out.println(trad);
        //Question 5
        boolean milanTraders=transactionList.stream()
                .anyMatch(transaction -> transaction.getTrader().getCity().equals("Milan"));
        System.out.println(milanTraders);

        //Question 6
        transactionList.stream()
                .map(Transaction::getTrader)
                .filter(trader -> trader.getCity().equals("Milan"))
                .forEach(trader -> trader.setCity("Cambridge"));
        System.out.println(transactionList);

        //Question 7
        int highestValue=
                transactionList.stream()
                        .map(Transaction::getValue)
                        .reduce(0,Integer::max);
        System.out.println(highestValue);
    }
}
