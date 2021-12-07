import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TriangleTest {

    private static Logger logger = LoggerFactory.getLogger(TriangleTest.class);

    @BeforeAll
    static void beforeALL() {
        logger.info("Log recording...");


    }

    @ParameterizedTest
    @CsvSource({"4, 5, 3, true", "4, 5, 10, false"})
    void isTriangleTest(int a, int b, int c, boolean result) throws InvalidTriangleException {
        Assertions.assertEquals(result, Triangle.isTriangle(a, b, c));
    }

    @ParameterizedTest
    @CsvSource({"4, 5, 3, 6"})
    void getAreaTest(int a, int b, int c, double result) {
        Assertions.assertEquals(result, Triangle.getArea(a, b, c));
    }

}
