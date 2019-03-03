package io.thorntail.jax.rs.rest.pagination;

import java.util.List;

public class Paginated<T> {

    private List<T> entities;
    private int currentPage;
    private int pageCount;
    private int totalCount;

    public Paginated() {
    }

    public Paginated(List<T> entities, int currentPage, int pageCount, int totalCount) {
        this.entities = entities;
        this.currentPage = currentPage;
        this.pageCount = pageCount;
        this.totalCount = totalCount;
    }

    public List<T> getEntities() {
        return entities;
    }

    public void setEntities(List<T> entities) {
        this.entities = entities;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }
}