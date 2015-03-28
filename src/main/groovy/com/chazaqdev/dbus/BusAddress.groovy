package com.chazaqdev.dbus

import groovy.transform.CompileStatic

import java.text.ParseException

@groovy.util.logging.Log4j
/**
 */
@CompileStatic
class BusAddress {
    private String type = ""
    private Map<String, String> parameters = [:] as Map<String, String>

    def setAddress(String address) throws ParseException {
        if (!address) throw new ParseException("Bus address is blank or null", 0)
        log.debug "Parsing bus address:$address"
        def ss = address.tokenize(":")
        if (ss.size() < 2) throw new ParseException("Bus address invalid", 0)
        type = ss[0]
        log.debug "Transport type: $type"

        def ps = ss[1].tokenize(",").each { String p ->
            def keyVal = p.tokenize "="
            parameters[keyVal[0]] = keyVal[1]
        }
        log.debug "Transport options: $parameters"
    }

    String getType() {type}
    Map<String, String> getParameters() {parameters}
}
