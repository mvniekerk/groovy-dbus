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
class UInt64 extends Number {
    public static final BigInteger MAX_VALUE = new BigInteger("18446744073709551615")
    public static final BigInteger MIN_VALUE = BigInteger.ZERO

    private BigInteger value

    UInt64(BigInteger val) {
        super()
        if (!val || val > MAX_VALUE || val < MIN_VALUE) {
            throw new NumberFormatException("$val is not between $MAX_VALUE and $MIN_VALUE")
        }
        this.value = val
    }

    UInt64(long val) {
        this(new BigInteger("$val"))
    }

    UInt64(long top, long bottom) {
        this((BigInteger)(new BigInteger("$top").leftShift(32) + (new BigInteger("$bottom"))))
    }

    byte byteValue()        {value.byteValue()}
    double doubleValue()    {value.doubleValue()}
    int intValue()          {value.intValue()}
    float floatValue()      {value.floatValue()}
    long longValue()        {value.longValue()}
    short shortValue()      {value.shortValue()}

    BigInteger value() {value}

    String toString() {"$value"}

    long top() {
        ((value.rightShift(32)) & 0xFFFFFFFF).longValue()
    }

    long bottom() {
        (value & 0xFFFFFFFF).longValue()
    }
}
