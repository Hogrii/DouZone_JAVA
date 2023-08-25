import java.util.ArrayList;
import java.util.List;

enum Gender {
	Male, Female
}

enum SearchOption {
	Location, Gender
}

// DTO 객체
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

// 서비스 객체
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
		for (Customer customer : customers) {
			if (customer.getLocation().equals(location)) {
				findCustomers.add(customer);
			}
		}
		return findCustomers;
	}

	// 요구사항
	// 성별로 검색하기
	public List<Customer> searchCustomerByGender(Gender gender) {
		List<Customer> findCustomers = new ArrayList<>();
		for (Customer customer : customers) {
			if (customer.getGender().equals(gender)) {
				findCustomers.add(customer);
			}
		}
		return findCustomers;
	}

	// 요구사항
	// 지역 검색 함수와 성별 검색 함수를 통합
	public List<Customer> searchCustomerBy(SearchOption searchOption, String searchValue) {
		List<Customer> findCustomers = new ArrayList<>();
		for (Customer customer : customers) {
			if (searchOption.equals(SearchOption.Location)) {
				// 지역 검색
				if (customer.getLocation().equals(searchValue)) {
					findCustomers.add(customer);
				}
			} else if (searchOption.equals(SearchOption.Gender)) {
				// 성별 검색
				if (customer.getGender().name().equals(searchValue)) { // getGender()는 타입 반환, name()은 데이터 반환
					findCustomers.add(customer);
				}

			}
		}
		return findCustomers;
	}

	// 인터페이스를 기반으로 검색하기
	public List<Customer> searchCustomer(SearchFilter filter) {
		List<Customer> foundCustomers = new ArrayList<>();
		for (Customer customer : customers) {
			if (filter.isMatched(customer)) { // 고객 정보가 일치한다면 ..
				foundCustomers.add(customer);
			}
		}
		return foundCustomers;
	}
}

// 추가사항 ...
interface SearchFilter {
	boolean isMatched(Customer customer);
}

public class F_Program5 {
	public static void main(String[] args) {
		CustomerService service = new CustomerService();
		initData(service);

		List<Customer> results = new ArrayList<>();

		/*
		 * // 익명 객체 활용 Thread th3 = new Thread(new Runnable() { // 1회성 사용
		 * 
		 * @Override public void run() { for(int i=0; i<10000; i++) {
		 * System.out.println("Task_3 " + i); }
		 * System.out.println("Task_3 run() 함수 END"); } }); th3.start();
		 */
		results = service.searchCustomer(new SearchFilter() { // 클래스 이름이 없는 익명 객체를 일회성으로 사용
			@Override
			public boolean isMatched(Customer customer) {
				if (customer.getLocation().equals("Seoul"))
					return true;
				else
					return false;
			}
		});

		for (Customer customer : results) {
			System.out.println(customer);
		}

		// Stream 사용하기(API)
		// Stream은 람다식을 사용
		// Collection 자원을 효율적으로 필터링 조회 ..(성능)
		System.out.println("----------------------람다식-------------------------");

		List<Customer> results2 = new ArrayList<>();
		results2 = service.searchCustomer(customer -> customer.getGender().equals(Gender.Male));
		for (Customer customer : results2) {
			System.out.println(customer);
		}

		System.out.println("----------------------람다식-------------------------");

		List<Customer> results3 = new ArrayList<>();
		results3 = service.searchCustomer(customer -> customer.getLocation().equals("Seoul") && customer.getAge() > 40);
		for (Customer customer : results3) {
			System.out.println(customer);
		}
	}

	public static void initData(CustomerService service) {
		service.addCustomer(new Customer("customer01", "Seoul", Gender.Male, 30));
		service.addCustomer(new Customer("customer02", "Busan", Gender.Female, 55));
		service.addCustomer(new Customer("customer03", "Seoul", Gender.Female, 13));
		service.addCustomer(new Customer("customer04", "Gwangju", Gender.Male, 27));
		service.addCustomer(new Customer("customer05", "Gwangju", Gender.Female, 60));
		service.addCustomer(new Customer("customer06", "Incheon", Gender.Male, 29));
		service.addCustomer(new Customer("customer07", "Seoul", Gender.Male, 42));
		service.addCustomer(new Customer("customer08", "Seoul", Gender.Female, 45));
		service.addCustomer(new Customer("customer09", "Seoul", Gender.Female, 33));
		service.addCustomer(new Customer("customer10", "Seoul", Gender.Male, 20));
	}
}
