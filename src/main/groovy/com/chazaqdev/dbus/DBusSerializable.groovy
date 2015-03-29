package com.chazaqdev.dbus

import com.chazaqdev.dbus.exceptions.DBusException
import groovy.transform.CompileStatic

/**
 * Custom classes may be sent over DBus if they have this trait
 */
@CompileStatic
trait DBusSerializable {
    public Object[] serialize() throws DBusException {
        [] as Object[]
    }
}
