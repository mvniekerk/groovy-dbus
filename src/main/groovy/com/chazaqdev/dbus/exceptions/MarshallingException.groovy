package com.chazaqdev.dbus.exceptions

import groovy.transform.CompileStatic
import groovy.transform.InheritConstructors

/**
 * Created by mike on 15/03/29.
 */
@InheritConstructors
@CompileStatic
class MarshallingException extends DBusException implements NonFatalException {

}
