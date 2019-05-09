/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.miromaric.dentalassistant.deserializer;

import com.google.protobuf.TextFormat.ParseException;
import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.json.bind.serializer.DeserializationContext;
import javax.json.bind.serializer.JsonbDeserializer;
import javax.json.stream.JsonParser;

/**
 *
 * @author MikoPC
 */
public class MyJsonDateDeserializer implements JsonbDeserializer<Date>{

    @Override
    public Date deserialize(JsonParser jp, DeserializationContext dc, Type type) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String date = jp.getString();
        try {
            return format.parse(date);
        } catch (java.text.ParseException ex) {
            throw new RuntimeException("Date must be in yyyy-MM-dd format");
        }
    }
    
}
