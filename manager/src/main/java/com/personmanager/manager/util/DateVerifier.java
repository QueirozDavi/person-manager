package com.personmanager.manager.util;

import com.personmanager.manager.exception.BadRequestException;
import lombok.NoArgsConstructor;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@NoArgsConstructor
public class DateVerifier {

    public Date verifyDate(Date date) {

        String textDate = date.toString();
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

        try {
            format.setLenient(false);
            date = format.parse(textDate);
        } catch (ParseException e) {
            throw new BadRequestException("Error: the date pattern must be: dd/MM/yyyy .");
        }

        return date;
    }
}
