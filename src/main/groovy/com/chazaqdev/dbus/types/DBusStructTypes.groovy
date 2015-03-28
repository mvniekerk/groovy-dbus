package com.chazaqdev.dbus.types

import com.chazaqdev.dbus.Struct
import groovy.transform.CompileStatic

import java.lang.reflect.ParameterizedType
import java.lang.reflect.Type

/**
 * Created by mike on 15/03/28.
 */
@CompileStatic
class DBusStructTypes implements ParameterizedType {
    private Type[] contents
    DBusStructTypes(Type... contents) {
        super()
        this.contents = contents
    }

    Type[] getActualTypeArguments() { contents }
    Type getRawType() { Struct.class }
    Type getOwnerType() { null }
}
