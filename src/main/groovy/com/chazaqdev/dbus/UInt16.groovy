package com.chazaqdev.dbus

import groovy.transform.CompileStatic
import groovy.transform.EqualsAndHashCode
import groovy.transform.Sortable

/**
 * Created by mike on 15/03/28.
 */
@EqualsAndHashCode
@Sortable
@CompileStatic
class UInt16 extends Number {
    public static final int MAX_VALUE = 65535
    public static final int MIN_VALUE = 0


    private int value

    UInt16(int val) {
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

    int value() {value}

    String toString() {"$value"}
}
