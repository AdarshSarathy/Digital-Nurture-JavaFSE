public interface CustomerRepository { 
    void save(Customer c); 
    Customer findById(String id); 
    java.util.List<Customer> findAll(); 
    boolean delete(String id); 
}