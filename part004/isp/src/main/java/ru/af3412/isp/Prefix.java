package ru.af3412.isp;

import ru.af3412.isp.interfaces.MenuPrefix;

/**
 * The type Simple prefix.
 *
 * @author Filatov Alexander
 * @since 28.02.2017
 */
public class Prefix implements MenuPrefix {

    final private String prefixType;

    /**
     * Instantiates a new Simple prefix.
     *
     * @param prefixType the prefixType
     */
    public Prefix(String prefixType) {
        this.prefixType = prefixType;
    }

    @Override
    public String getPrefix() {

        return this.prefixType;

    }

}
