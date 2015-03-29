package com.chazaqdev.dbus

import com.chazaqdev.dbus.exceptions.DBusException
import groovy.transform.CompileStatic
import groovy.transform.EqualsAndHashCode
import groovy.transform.Sortable
import groovy.transform.ToString
import groovy.util.logging.Log4j

import java.lang.reflect.Type

/**
 * Created by mike on 15/03/28.
 */

@Log4j
@EqualsAndHashCode
@CompileStatic
@ToString
class Variant<T> {

    final T value
    final Type type
    final String sig

    /**
     * Create a Variant from a basic type object.
     * @param o The wrapped value.
     * @throws IllegalArugmentException If you try and wrap Null or an object of a non-basic type.
     */
    public Variant(T o) throws IllegalArgumentException  {
        if (!o) throw new IllegalArgumentException("Can't wrap Null in a Variant")
        type = o.class
        try {
            String[] ss = Marshalling.getDBusType(o.getClass(), true)
            if (ss.length != 1)
                throw new IllegalArgumentException("Can't wrap a multi-valued type in a Variant: $type")
            this.sig = ss[0]
        } catch (DBusException DBe) {
            log.debug "$DBe.message"
            throw new IllegalArgumentException("Can't wrap ${o.class} in an unqualified Variant (${DBe.message}).")
        }
        this.value = o
    }
    /**
     * Create a Variant.
     * @param o The wrapped value.
     * @param type The explicit type of the value.
     * @throws IllegalArugmentException If you try and wrap Null or an object which cannot be sent over DBus.
     */
    public Variant(T o, Type type) throws IllegalArgumentException
    {
        if (!o) throw new IllegalArgumentException("Can't wrap Null in a Variant")
        this.type = type
        try {
            String[] ss = Marshalling.getDBusType(type)
            if (ss.length != 1)
                throw new IllegalArgumentException("Can't wrap a multi-valued type in a Variant: $type")
            this.sig = ss[0]
        } catch (DBusException DBe) {
            log.error "${DBe.message}"
            throw new IllegalArgumentException("Can't wrap ${o.class} in an unqualified Variant (${DBe.message}).")
        }
        this.value = o
    }
    /**
     * Create a Variant.
     * @param o The wrapped value.
     * @param sig The explicit type of the value, as a dbus type string.
     * @throws IllegalArugmentException If you try and wrap Null or an object which cannot be sent over DBus.
     */
    public Variant(T o, String sig) throws IllegalArgumentException
    {
        if (!o) throw new IllegalArgumentException("Can't wrap Null in a Variant")
        this.sig = sig
        try {
            Vector<Type> ts = new Vector<Type>()
            Marshalling.getJavaType(sig, ts,1)
            if (ts.size() != 1)
                throw new IllegalArgumentException("Can't wrap multiple or no types in a Variant: $sig")
            this.type = ts[0]
        } catch (DBusException DBe) {
            log.error "$DBe.message"
            throw new IllegalArgumentException("Can't wrap ${o.class} in an unqualified Variant (${DBe.message}).")
        }
        this.value = o
    }

    @Override
    public boolean equals(Object other)
    {
        !other || !(other instanceof  Variant) ? false : this.value.equals(((Variant<?>) other).value)
    }



}
