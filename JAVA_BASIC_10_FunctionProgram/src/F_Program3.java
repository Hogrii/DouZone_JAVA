import java.util.ArrayList;
import java.util.List;
/*
enum Gender {
	Male, Female
}
 */
// DTO 객체
/*
class Customer {
	private String id;
	private String location;
	private Gender gender; // enum 열거타입
	private int age;
	
	public Customer(String id, String location, Gender gender, int age) {
		super();
		this.id = id;
		this.location = location;
		this.gender = gender;
		this.age = age;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", location=" + location + ", gender=" + gender + ", age=" + age + "]";
	}
}
 */

// 서비스 객체
/*
class CustomerService {
	private List<Customer> customers;
	
	public CustomerService() {
		this.customers = new ArrayList<>();
	}
	
	public void addCustomer(Customer newCustomer) {
		customers.add(newCustomer);
	}
	
	// 요구사항
	// location 지역으로 검색된 고객목록 추출
	// parameter location
	// 명령형(imperative)
	public List<Customer> searchCustomerByLocation(String location) {
		List<Customer> findCustomers = new ArrayList<>();
		for(Customer customer : customers) {
			if(customer.getLocation().equals(location)) {
				findCustomers.add(customer);
			}
		}
		return findCustomers;
	}
	
	// 요구사항
	// 성별로 검색하기
	public List<Customer> searchCustomerByGender(Gender gender) {
		List<Customer> findCustomers = new ArrayList<>();
		for(Customer customer : customers) {
			if(customer.getGender().equals(gender)) {
				findCustomers.add(customer);
			}
		}
		return findCustomers;
	}
}
 */

public class F_Program3 {
	public static void main(String[] args) {
		CustomerService service = new CustomerService();
		initData(service);
		
		// 지역 검색
		List<Customer> result = service.searchCustomerByLocation("Seoul");
		for(Customer customer : result) {
			System.out.println("customer : " + customer.toString());			
		}
		System.out.println("-----------------------------------------------------------------------------");
		
		// 성별로 검색
		List<Customer> result2 = service.searchCustomerByGender(Gender.Female);
		for(Customer customer : result2) {
			System.out.println("customer : " + customer.toString());
		}
	}
	
	public static void initData(CustomerService service) {
		service.addCustomer(new Customer("customer01", "Seoul",   Gender.Male, 30));
		service.addCustomer(new Customer("customer02", "Busan",   Gender.Female, 55));
		service.addCustomer(new Customer("customer03", "Seoul",   Gender.Female, 13));
		service.addCustomer(new Customer("customer04", "Gwangju", Gender.Male, 27));
		service.addCustomer(new Customer("customer05", "Gwangju", Gender.Female, 60));
		service.addCustomer(new Customer("customer06", "Incheon", Gender.Male, 29));
		service.addCustomer(new Customer("customer07", "Seoul",   Gender.Male, 42));
		service.addCustomer(new Customer("customer08", "Seoul",   Gender.Female, 45));
		service.addCustomer(new Customer("customer09", "Seoul",   Gender.Female, 33));
		service.addCustomer(new Customer("customer10", "Seoul",   Gender.Male, 20));
	}
}
