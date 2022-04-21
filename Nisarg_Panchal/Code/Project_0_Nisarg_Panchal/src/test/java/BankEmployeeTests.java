import com.ex.BankEmployee.BankEmployee;
import com.ex.IdGenreator;
import com.ex.Repositories.BankEmployeeRepository;
import com.ex.Services.BankEmpService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.testng.annotations.Test;

public class BankEmployeeTests {

    private BankEmployeeRepository bankEmployeeRepository;
    private BankEmpService bankEmpService;
    private IdGenreator IdGen;

    @BeforeEach
    public void initTest() {
        IdGen = new IdGenreator(0);
        bankEmployeeRepository = new BankEmployeeRepository(IdGen);
        bankEmpService = new BankEmpService(bankEmployeeRepository);
        bankEmployeeRepository.init();

    }

    @Test
    public void GivesUserWithCorrectCredentials() {
        String username = "employee1";
        String password = "Password1";
        bankEmployeeRepository.save(new BankEmployee(username, password));
        BankEmployee user = bankEmpService.EmpLogin(username, password, bankEmployeeRepository);
        Assertions.assertNotNull(user);
        Assertions.assertEquals(username, user.getUsername(), "Usernames do not match");
        Assertions.assertEquals(password, user.getPassword(), "passwords do not match");
    }
}
