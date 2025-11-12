package com.tpms.global.config;
import org.springframework.core.convert.converter.Converter;
import java.time.LocalDate;

public class DateConverter implements Converter<String, LocalDate> {
    @Override
    public LocalDate convert(String source) {
        return LocalDate.parse(source);
        
       
    }
    
    
   
}
