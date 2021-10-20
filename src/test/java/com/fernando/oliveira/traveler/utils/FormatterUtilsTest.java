package com.fernando.oliveira.traveler.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class FormatterUtilsTest {

    @Mock
    private FormatterUtils formatterUtils;

    @Test
    public void shouldFormatPhoneNumberWithTrace(){

        String phoneNumber = "98888-7777";
        String result  = formatterUtils.formatPhoneNumber(phoneNumber);
        Assertions.assertEquals("98888-7777", result);
    }

    @Test
    public void shouldFormatPhoneNumberWithSpace(){

        String phoneNumber = "98888 7777";
        String result  = formatterUtils.formatPhoneNumber(phoneNumber);
        Assertions.assertEquals("98888-7777", result);
    }
}
