package io.thorntail.jax.rs.rest;


import io.thorntail.jax.rs.rest.provider.LinkPaginationContainerResponseFilter;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

@ApplicationPath("rest")
public class RestApplication extends Application {

    public Set<Class<?>> getClasses() {
        Set<Class<?>> classes = new HashSet<>(2);
        classes.add(BookEndpoint.class);
        classes.add(LinkPaginationContainerResponseFilter.class);
        return classes;
    }
}