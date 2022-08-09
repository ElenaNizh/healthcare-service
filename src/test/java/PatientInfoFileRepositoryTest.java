import org.junit.jupiter.api.*;
import org.mockito.Mockito;
import ru.netology.patient.entity.BloodPressure;
import ru.netology.patient.entity.HealthInfo;
import ru.netology.patient.entity.PatientInfo;
import ru.netology.patient.repository.PatientInfoFileRepository;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.mockito.ArgumentMatchers.any;

public class PatientInfoFileRepositoryTest {

    static PatientInfoFileRepository patientInfoFileRepository;

    @BeforeAll
    public static void initSuite() {

        patientInfoFileRepository = Mockito.mock(PatientInfoFileRepository.class);

        Mockito.when(patientInfoFileRepository.getById(any())).thenReturn(new PatientInfo("1", "Ivan", "Ivanov",
                LocalDate.of(1980, 12, 21),
                new HealthInfo(new BigDecimal("36.6"),
                        new BloodPressure(140, 90))));
    }

    @AfterAll
    public static void completeSuite() {
        System.out.println("All tests complete!");
    }

    @Test
    @DisplayName("Test for method 'getById()' ")
    public void getByIdTest(TestInfo getByIdTestInfo) {

        PatientInfo patientInfo = new PatientInfo("1", "Ivan", "Ivanov", LocalDate.of(1980, 12, 21),
                new HealthInfo(new BigDecimal("36.6"), new BloodPressure(140, 90)));

        Assertions.assertEquals(patientInfo, patientInfoFileRepository.getById("1"), getByIdTestInfo.getDisplayName() + " is NO complete!");
        System.out.println(getByIdTestInfo.getDisplayName() + " complete!");

    }


}