import com.ex.Repositories.AnyUserRepository;
import com.ex.GeneralUser.AnyUser;
import com.ex.Services.AnyUserService;
import com.ex.Exceptions.ListEmptyException;
import com.ex.IdGenreator;
import com.ex.Exceptions.UserNotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class UserTests {

private AnyUserService testAnyUser;
private IdGenreator IDGen;
AnyUserRepository testRepos;

//Tests to be run before every test, will name it initTest()

    @BeforeEach
    public void initTest(){
        IDGen = new IdGenreator(0);
        testRepos = new AnyUserRepository(IDGen);
        testAnyUser = new AnyUserService();
        testRepos.init();
    }
    //Test for returning General i.e. Any user with correct credentials by Implementing 'authenticate' method
    @Test
    public void ReturnUserWithRightCredentials() {
        String username = "B@nKu$eR", password = "P@$$w0rD";
        testRepos.save(new AnyUser(username, password));
        AnyUser user = null;
        try {
            user = testAnyUser.authenticate(username, password, testRepos);
        } catch (ListEmptyException e) {
            e.printStackTrace();
        }
        Assertions.assertNotNull(user);
        Assertions.assertEquals(username, user.getUsername(), "Username not matching");
        Assertions.assertEquals(password, user.getPassword(), "password not matching");
    }

    // Testing for the Incorrect username and password
    @Test
    public void TestingUserNotFoundException() throws ListEmptyException {
        UserNotFoundException ex = Assertions.assertThrows(UserNotFoundException.class, () -> {
            testAnyUser.authenticate("B@nKu$eR2", "P@$$w0rD", testRepos);
        });
        Assertions.assertEquals("User cannot be found",
                ex.getMessage(), "This not resulted into invalid username & password");
    }

    @Test
    public void UserWithNullCredentials() {
        String username = "", password = "";

        testRepos.save(new AnyUser(username, password));
        AnyUser user = null;
        try {
            user = testAnyUser.authenticate(username, password, testRepos);
        } catch (ListEmptyException e) {
            e.printStackTrace();
        }
        Assertions.assertNotNull(user);
        Assertions.assertEquals(username, user.getUsername(), "Username not matching");
        Assertions.assertEquals(password, user.getPassword(), "password not matching");
    }

    @Test
    public void shouldThrowException(){
        UserNotFoundException ex = Assertions.assertThrows(UserNotFoundException.class, ()->{testAnyUser.authenticate("B@nKu$eR2","P@$$w0rD",testRepos);});
        Assertions.assertEquals("User cannot be found",ex.getMessage(),"This method did not work out.");
    }

}


