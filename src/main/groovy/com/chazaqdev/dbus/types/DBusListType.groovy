package com.chazaqdev.dbus.types

import groovy.transform.CompileStatic

import java.lang.reflect.ParameterizedType
import java.lang.reflect.Type

/**
 * The type of a list
 * Should be used whenever you need a Type variable for a list
 */
@CompileStatic
class DBusListType implements ParameterizedType {
    private Type value

    DBusListType(Type value) {
        super()
        this.value = value
    }

    public Type[] getActualTypeArguments() { [value] as Type[] }

    public Type getRawType() { List.class }

    public Type getOwnerType() { null }
}
