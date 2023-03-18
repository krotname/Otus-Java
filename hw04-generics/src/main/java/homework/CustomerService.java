package homework;


import java.util.AbstractMap;
import java.util.Map;
import java.util.TreeMap;

public class CustomerService {

    private final Map<Customer, String> customerMap = new TreeMap<>();

    public Map.Entry<Customer, String> getSmallest() {
        Map.Entry<Customer, String> customerStringEntry = customerMap.entrySet().stream().findFirst().orElse(null);
        if (customerStringEntry == null) return null;
        return new AbstractMap.SimpleImmutableEntry<>(
                new Customer(customerStringEntry.getKey().getId(),
                        customerStringEntry.getKey().getName(),
                        customerStringEntry.getKey().getScores()),
                customerStringEntry.getValue());
    }

    public Map.Entry<Customer, String> getNext(Customer customer) {
        Map.Entry<Customer, String> customerStringEntry = customerMap.entrySet().stream()
                .filter(customerMap -> customerMap.getKey().getScores() > (customer.getScores()))
                .findFirst().orElse(null);
        if (customerStringEntry == null) return null;
        return new AbstractMap.SimpleImmutableEntry<>(
                new Customer(customerStringEntry.getKey().getId(),
                        customerStringEntry.getKey().getName(),
                        customerStringEntry.getKey().getScores()),
                customerStringEntry.getValue());
    }

    public void add(Customer customer, String data) {
        Customer customer1 = new Customer(customer.getId(), customer.getName(), customer.getScores());
        customerMap.put(customer1, data);
    }
}
