package com.thiaghoul.workshopmongo.resources.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

//Utility class for handling URL-related operations, such as decoding parameters and converting dates.
public class URL {

    //Decodes a URL-encoded string using UTF-8 encoding.
    public static String decodeParam(String text){
        try {
            return URLDecoder.decode(text, "UTF-8");

        } catch (UnsupportedEncodingException e) {
            //returns an empty string if it fails
            return "";
        }
    }

    //Converts a date string in the format "yyyy-MM-dd" to a Date object.
    public static Date convertDate(String textDate, Date defaultValue){
        // Defines the date format to be used for parsing.
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        // Sets the time zone to GMT to ensure consistent date parsing.
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

        try {
            return sdf.parse(textDate);

        } catch (ParseException e) {
            //If parsing fails, a default Date value is returned.
            return defaultValue;

        }
    }
}
