package dev.ali.pos;

import dev.ali.pos.entity.*;
import dev.ali.pos.mapper.ProductMapper;
import dev.ali.pos.repository.OrderRepository;
import dev.ali.pos.service.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@SpringBootTest
class PosApplicationTests {
	private static final Logger log = LoggerFactory.getLogger(PosApplicationTests.class);

	@Autowired
	private UserService userService;

	@Autowired
	private AdminService adminService;

	@Autowired
	private ManagerService managerService;

	@Autowired
	private CashierService cashierService;

	@Autowired
	private OrderService orderService;

	@Autowired
	private ItemService itemService;

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private ProductMapper productMapper;

	@Autowired
	private ProductService productService;

	@Autowired
	private SalesService salesService;

	@Test
	void contextLoads() {
	}

	@BeforeAll
	static void setup() {
		log.info("Going to perform test cases...");
	}

	@Test
	void createManager(){
		Manager manager = managerService.create("Ali", "Tariq","alibabapk@aol.com","1118174","Shalamar link road","m","alibaba_manager","pass");
		assertNotNull(manager);
		log.info("New manager created ->"+ manager);
	}
	@Test
	void createCashier(){
		Cashier cashier = cashierService.create("Ali", "Tariq","alibabapk@aol.com","1118174","Shalamar link road","m","alibaba_user","pass");
		assertNotNull(cashier);
		log.info("New manager created ->"+ cashier);
	}
	@Test
	void createAdmin(){
		Admin admin = adminService.create("Ali", "Tariq","358459340","alibaba_admin","pass");
		assertNotNull(admin);
		log.info("New manager created ->"+ admin);
	}
	@Test
	void simulateSales(){
		// ids -> 16 = Bread, 17 = Rusk, 18 = Bakarkhani
		List<Long> ids = List.of(16L,17L,18L);
		salesService.selectItems(ids);
		assertNotNull(ids);
	}
	@Test
	void calculateTotal(){
		List<Long> ids = List.of(16L,17L,18L);
		double total = salesService.calculateTotal(salesService.selectItems(ids));
		log.info("total -> "+ total);
		assertEquals(total,433.50,0.01);
	}
	@Test
	void createOrder(){
		// Pick items to buy
		List<Long> ids = List.of(16L,17L,18L);
		List<Item> items = salesService.selectItems(ids);
		double changeDue = salesService.createOrder(1000,items);
		log.info("Change due -> "+changeDue);
		assertEquals(changeDue, 565.50,0.01);
	}
}
