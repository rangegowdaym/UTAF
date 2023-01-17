package com.rgacademy.selenium.flights;

import org.springframework.test.context.TestPropertySource;

@TestPropertySource(properties = {"app.locale=en", "browser=chrome"})
public class EnTest extends FlightTest {
}
