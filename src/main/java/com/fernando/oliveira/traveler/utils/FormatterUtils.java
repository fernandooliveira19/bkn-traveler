package com.fernando.oliveira.traveler.utils;

import com.fernando.oliveira.traveler.exception.TravelerInvalidException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.swing.text.MaskFormatter;
import java.text.Normalizer;
import java.text.ParseException;

@Slf4j
@Component
public class FormatterUtils {

    private static final String CPF_MASK= "###.###.###-##";
    private static final String PHONE_MASK="#####-####";

    private FormatterUtils(){

    }

    public static String formatCpf(String cpf){
        try {
            String cpfFormatted = Normalizer.normalize(cpf, Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "");
            MaskFormatter mask = new MaskFormatter(CPF_MASK);
            mask.setValueContainsLiteralCharacters(false);
            return mask.valueToString(cpfFormatted);
        }catch (ParseException ex){
            throw new TravelerInvalidException("Erro ao formatar CPF: " + cpf);
        }

    }

    public static String formatPhoneNumber(String phoneNumber){
        try {
            String phoneNumberFormatted = Normalizer.normalize(phoneNumber, Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "");
            MaskFormatter mask = new MaskFormatter(PHONE_MASK);
            mask.setValueContainsLiteralCharacters(false);
            return mask.valueToString(phoneNumberFormatted);
        }catch (ParseException ex){
            throw new TravelerInvalidException("Erro ao formatar telefone: " + phoneNumber);
        }

    }
}
