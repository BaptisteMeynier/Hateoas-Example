package io.thorntail.jax.rs.rest;

import io.thorntail.jax.rs.model.Book;
import io.thorntail.jax.rs.repository.BookStore;
import io.thorntail.jax.rs.rest.param.PaginationParam;
import io.thorntail.jax.rs.rest.pagination.Paginated;

import javax.ws.rs.BeanParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;
import javax.ws.rs.core.*;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Path("book")
@Produces(MediaType.APPLICATION_JSON)
public class BookEndpoint {

    @Context
    private UriInfo uriInfo;
    private BookStore store = new BookStore();

    @GET
    public void doGet(
            @BeanParam PaginationParam queryParams,
            @Suspended AsyncResponse asyncResponse
    ) {
        final List<Book> allBooks = Arrays.asList(store.getBook());
        final List<Book> entities = allBooks.stream().skip(queryParams.per_page * queryParams.page).limit(queryParams.per_page).collect(Collectors.toList());
        final Paginated<Book> paginated = new Paginated<Book>(entities, queryParams.page,queryParams.per_page, allBooks.size() / queryParams.per_page, allBooks.size());

        asyncResponse.resume(paginated);
    }


}
