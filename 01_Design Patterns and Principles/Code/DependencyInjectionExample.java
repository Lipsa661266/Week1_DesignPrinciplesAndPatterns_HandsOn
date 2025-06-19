// Step 2: Repository Interface
interface CustomerRepository {
    String findCustomerById(String id);
}

// Step 3: Concrete Repository Implementation
class CustomerRepositoryImpl implements CustomerRepository {
    @Override
    public String findCustomerById(String id) {
        // Simulate fetching customer data from a database
        return "Customer[id=" + id + ", name=Soumya Mohanty]";
    }
}

// Step 4: Service Class
class CustomerService {
    private final CustomerRepository customerRepository;

    // Step 5: Constructor Injection
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public void getCustomerDetails(String id) {
        String customer = customerRepository.findCustomerById(id);
        System.out.println("Customer Found: " + customer);
    }
}

// Step 6: Main Class
public class DependencyInjectionExample {
    public static void main(String[] args) {
        // Manually inject dependency
        CustomerRepository repository = new CustomerRepositoryImpl();
        CustomerService service = new CustomerService(repository);

        // Use service
        service.getCustomerDetails("101");
    }
}
