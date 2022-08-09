import org.junit.jupiter.api.*;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;
import ru.netology.patient.service.alert.SendAlertServiceImpl;

public class SendAlertServiceImplTest {

    static SendAlertServiceImpl sendAlertServiceImpl;

    @BeforeAll
    public static void initSuite() {
        sendAlertServiceImpl =  Mockito.spy(SendAlertServiceImpl.class);
    }

    @AfterAll
    public static void completeSuite() {
        System.out.println("All tests complete!");
    }

    @Test
    @DisplayName("Test for method 'send()' in 'SendAlertServiceImpl' class")
    public void sendTest(TestInfo sendTestInfo) {

        ArgumentCaptor<String> argumentCaptor = ArgumentCaptor.forClass(String.class); // перехват аргументов
        sendAlertServiceImpl.send("Test"); // запускаем метод со значением "Test"
        Mockito.verify(sendAlertServiceImpl).send(argumentCaptor.capture()); // перехват
        Assertions.assertEquals("Test", argumentCaptor.getValue(),
                sendTestInfo.getDisplayName() + " is NO complete!"); // сравниваем ожидаемое значение и перехват
        System.out.println(sendTestInfo.getDisplayName() + " complete!");
    }
}