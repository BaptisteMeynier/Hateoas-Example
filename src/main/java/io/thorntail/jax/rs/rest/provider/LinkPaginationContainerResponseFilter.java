package io.thorntail.jax.rs.rest.provider;

import io.thorntail.jax.rs.rest.pagination.LinkPagination;
import io.thorntail.jax.rs.rest.pagination.Paginated;
import io.thorntail.jax.rs.rest.pagination.PaginationConstants;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.core.Link;
import javax.ws.rs.core.UriInfo;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static io.thorntail.jax.rs.rest.pagination.PaginationConstants.X_PAGE_COUNT;
import static io.thorntail.jax.rs.rest.pagination.PaginationConstants.X_TOTAL_COUNT;
import static javax.ws.rs.core.HttpHeaders.LINK;

public class LinkPaginationContainerResponseFilter implements ContainerResponseFilter {

    @Override
    public void filter(ContainerRequestContext requestContext,
                       ContainerResponseContext responseContext) {

        if (!(responseContext.getEntity() instanceof Paginated)) {
            return;
        }

        UriInfo uriInfo = requestContext.getUriInfo();
        Paginated page = (Paginated) responseContext.getEntity();

        responseContext.setEntity(page.getEntities());
        page.getPageCount();

        Stream<Link> build = LinkPagination
                .uriInfo(uriInfo)
                .pageSize(PaginationConstants.DEFAULT_PER_PAGE)
                .pageNumber(page.getCurrentPage())
                .totalEntityCount(page.getTotalCount())
                .totalPageCount(page.getTotalCount() / page.getPageCount())
                .build();

        responseContext.getHeaders().addAll(LINK,build.collect(Collectors.toList()));
        responseContext.getHeaders().add(X_TOTAL_COUNT, page.getTotalCount());
        responseContext.getHeaders().add(X_PAGE_COUNT, page.getPageCount());
    }
}
