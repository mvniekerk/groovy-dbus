package com.chazaqdev.dbus

import groovy.transform.CompileStatic

import java.lang.reflect.Field
import java.lang.reflect.Type

/**
 * Created by mike on 15/03/28.
 */
@CompileStatic
abstract class Container {
    static def typeCache = [:] as Map<Type, Type[]>

    @Lazy Object[] parameters = {
        Field[] fs = getClass().declaredFields
        Object[] args = new Object[fs.length]
        def diff = fs.collect { Field f ->
            int i = 0
            Position p = f.getAnnotation(Position.class)
            if (p) {
                try {
                    args[p.value()] = f.get(this)
                } catch (any) {}
            } else {
                i = 1
            }
            i
        }.sum() as int
        args[0..<(args.length - diff)]
    }()

    String toString() {
        def params = getParameters()
        "${getClass().name}<${parameters.collect {"$it"}.join(",")}>"
    }

    boolean equals(Object other) {
        def ret = false
        if (other instanceof Container)  {
            Container that = (Container) other
            if (this.class == that.class)
                ret = Arrays.equals(this.getParameters(), that.getParameters())
        }
        ret
    }
}
