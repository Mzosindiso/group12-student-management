package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Country;

import static org.junit.jupiter.api.Assertions.*;

class CountryFactoryTest {

    @Test
    public void buildWithSuccess() {
        Country country = CountryFactory.build("219361738", "Imraan");
        System.out.println(country);
        assertNotNull(country);
    }

    @Test
    public void buildWithError() {
        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> CountryFactory.build("", ""));
        System.out.println(exception.getMessage());
        assertTrue(exception.getMessage().contains("id"));
    }

}