package com.chazaqdev.dbus.types

import groovy.transform.CompileStatic

import java.lang.reflect.ParameterizedType
import java.lang.reflect.Type

/**
 * Created by mike on 15/03/28.
 */
@CompileStatic
class DBusMapType implements ParameterizedType {
    private Type key
    private Type value

    DBusMapType(Type key, Type value) {
        super()
        this.key = key
        this.value = value
    }

    Type[] getActualTypeArguments() { [key, value] as Type[] }
    Type getRawType() { Map.class }
    Type getOwnerType() { null }
}
