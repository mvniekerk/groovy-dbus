package com.chazaqdev.dbus

import com.chazaqdev.dbus.exceptions.DBusException
import groovy.transform.TailRecursive

import java.lang.reflect.Type

@groovy.util.logging.Log4j
/**
 * Contains static methods for marshalling values
 */
class Marshalling {
    static def typeCache = [:] as Map<Type, String[]>

    public static String getDBusType(Type[] c) throws DBusException {
        c.collect { Type t ->
            (getDBusType(t)).join("")
        }.join("")
    }

    public static String[] getDBusType(Type c) throws DBusException {
        String[] cached = typeCache[c] ?: getDBusType(c, false)
        typeCache[c] = cached
        cached
    }

    public static String[] getDBusType(Type c, boolean basic) {
        recursiveGetDBusTypes c, basic, 0
    }

//    @TailRecursive
    public static List<String> recursiveGetDBusTypes(Type c, boolean basic, int level, List<String> ret) throws DBusException {


//        if (out.length <= level) {
//            def d = new StringBuffer[]
//        }

        ret
    }

    public static List<String> recursiveGetDBusTypes(Type c, boolean basic, int level) throws DBusException {
        recursiveGetDBusTypes c, basic, 0, [] as List<String>
    }
    /**
     * Converts a dbus type string into Java Type objects,
     * @param dbus The DBus type or types.
     * @param rv Vector to return the types in.
     * @param limit Maximum number of types to parse (-1 == nolimit).
     * @return number of characters parsed from the type string.
     */
    public static int getJavaType(String dbus, List<Type> rv, int limit) throws DBusException
    {
        return 0
    }
}
