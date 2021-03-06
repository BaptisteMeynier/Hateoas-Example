package io.thorntail.jax.rs.rest.param;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.QueryParam;

import static io.thorntail.jax.rs.rest.pagination.PaginationConstants.*;


public class PaginationParam {

    @Min(value = 1, message = "page start at " + FIRST_PAGE)
    @QueryParam(PAGE_QUERY_PARAM)
    @DefaultValue(FIRST_PAGE_STR)
    public int page;

    @Max(value = 1, message = "per_page max is " + PER_PAGE_QUERY_PARAM)
    @QueryParam(PER_PAGE_QUERY_PARAM)
    @DefaultValue(DEFAULT_PER_PAGE_STR)
    public int per_page;
}
