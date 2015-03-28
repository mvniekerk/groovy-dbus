package com.chazaqdev.dbus

import groovy.transform.CompileStatic
import groovy.transform.EqualsAndHashCode
import groovy.transform.Sortable
import groovy.transform.ToString

/**
 * Created by mike on 15/03/28.
 */
@EqualsAndHashCode
@Sortable
@CompileStatic
@ToString
class UInt32 extends Number {

    public static final long MAX_VALUE = 4294967295L
    public static final long MIN_VALUE = 0L

    private long value

    UInt32(long val) {
        super()
        if (value < MIN_VALUE || value > MAX_VALUE) {
            throw new NumberFormatException("$val is not between $MAX_VALUE and $MIN_VALUE")
        }
        this.value = value
    }

    byte byteValue()        {(byte)     value}
    double doubleValue()    {(double)   value}
    int intValue()          {value}
    float floatValue()      {(float)    value}
    long longValue()        {(long)     value}
    short shortValue()      {(short)    value}

    long value() {value}

    String toString() {"$value"}
}
