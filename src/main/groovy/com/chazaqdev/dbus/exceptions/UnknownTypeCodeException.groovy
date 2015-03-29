package com.chazaqdev.dbus.exceptions

import groovy.transform.CompileStatic
import groovy.transform.InheritConstructors

/**
 * Created by mike on 15/03/29.
 */
@InheritConstructors
@CompileStatic
class UnknownTypeCodeException extends DBusException implements NonFatalException {
    UnknownTypeCodeException(byte code) {
        super("Not a valid D-Bus type code: $code")
    }
}
