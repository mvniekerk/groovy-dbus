package com.chazaqdev.dbus

/**
 * Created by mike on 15/03/29.
 */
trait AbstractConnection {

    static final String BUSNAME_REGEX = '''^[-_a-zA-Z][-_a-zA-Z0-9]*(\\.[-_a-zA-Z][-_a-zA-Z0-9]*)*$'''
    static final String CONNID_REGEX = '''^:[0-9]*\\.[0-9]*$'''
    static final String OBJECT_REGEX = '''^/([-_a-zA-Z0-9]+(/[-_a-zA-Z0-9]+)*)?$'''
    static final byte THREADCOUNT = 4
    static final int MAX_ARRAY_LENGTH = 67108864
    static final int MAX_NAME_LENGTH = 255
}
