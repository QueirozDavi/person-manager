package com.personmanager.manager.util;

import com.personmanager.manager.exception.BadRequestException;
import lombok.NoArgsConstructor;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@NoArgsConstructor
public class DateVerifier {

    public boolean verifyDate(String dateStr) {

        DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        format.setLenient(false);

        try {
            format.parse(dateStr);
            return true;
        } catch (ParseException e) {
            throw new BadRequestException("Error: the date pattern must be: dd/MM/yyyy .");
        }

    }
}
