package com.basiliqo.weatherappbackend.response.converter;

import com.fasterxml.jackson.databind.util.StdConverter;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public class UnixTimestampToLocalDateTimeConverter extends StdConverter<Long, LocalDateTime> {

    private final static long UNIX_TO_LOCAL_DATE_TIME_MULTIPLIER = 1000;

    @Override
    public LocalDateTime convert(Long value) {
        return new Timestamp(value * UNIX_TO_LOCAL_DATE_TIME_MULTIPLIER).toLocalDateTime();
    }
}
