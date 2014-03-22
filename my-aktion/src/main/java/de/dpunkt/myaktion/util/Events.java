package de.dpunkt.myaktion.util;

import javax.inject.Qualifier;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

public class Events {
    @Qualifier
    @Target({FIELD, PARAMETER})
    @Retention(RUNTIME)
    public @interface Added {
    }

    @Qualifier
    @Target({FIELD, PARAMETER})
    @Retention(RUNTIME)
    public @interface Deleted {
    }
}