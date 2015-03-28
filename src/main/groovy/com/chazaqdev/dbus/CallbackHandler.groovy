package com.chazaqdev.dbus

import com.chazaqdev.dbus.exceptions.DBusException
import groovy.transform.CompileStatic

/**
 * An Exception within DBus
 */
@CompileStatic
trait CallbackHandler<ReturnType> {
    def handle = { ReturnType r ->
    }

    def handleError = { DBusException e ->
        e.printStackTrace()
    }
}
