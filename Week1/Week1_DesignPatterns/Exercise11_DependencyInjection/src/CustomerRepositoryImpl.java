import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class CustomerRepositoryImpl implements CustomerRepository {
    private final Map<String, Customer> db = new HashMap<String, Customer>();
    public void save(Customer c) { db.put(c.getCustomerId(), c); System.out.println("[Repo] Saved: " + c); }
    public Customer findById(String id) { return db.get(id); }
    public List<Customer> findAll() { return new ArrayList<Customer>(db.values()); }
    public boolean delete(String id) { return db.remove(id) != null; }
}