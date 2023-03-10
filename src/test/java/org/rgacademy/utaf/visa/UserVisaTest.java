package org.rgacademy.utaf.visa;

import org.rgacademy.utaf.SpringBaseTestNGTest;
import org.rgacademy.utaf.entity.Customer;
import org.rgacademy.utaf.page.visa.VisaRegistrationPage;
import org.rgacademy.utaf.repository.CustomerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.ITestContext;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.sql.Date;

public class UserVisaTest extends SpringBaseTestNGTest {

    private static final Logger logger = LoggerFactory.getLogger(UserVisaTest.class);

    @Autowired
    private VisaRegistrationPage registrationPage;

    @Autowired
    private CustomerRepository customerRepository;

    @Test(dataProvider = "getData")
    public void visaTest(Customer u) throws Exception {
        this.registrationPage.goTo();
        this.registrationPage.setNames(u.getFirstName(), u.getLastName());
        this.registrationPage.setCountryFromAndTo(u.getFromCountry(), u.getToCountry());
        this.registrationPage.setBirthDate(u.getDob().toLocalDate());
        this.registrationPage.setContactDetails(u.getEmail(), u.getPhone());
        this.registrationPage.setComments(u.getComments());
        this.registrationPage.submit();
        logger.info("Request confirmation # INFO : " + this.registrationPage.getConfirmationNumber());
        logger.warn("Request confirmation # WARN : " + this.registrationPage.getConfirmationNumber());

    }

    @DataProvider
    public Object[][] getData(ITestContext context) {
        return this.customerRepository.findByDobBetween(
                        Date.valueOf("2000-01-01"),
                        Date.valueOf("2010-01-01")
                )
                .stream()
                .limit(3)
                .map(o -> new Customer[]{o})
                .toArray(Object[][]::new);
    }


}
