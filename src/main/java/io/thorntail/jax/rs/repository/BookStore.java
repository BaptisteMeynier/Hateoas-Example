package io.thorntail.jax.rs.repository;

import io.thorntail.jax.rs.model.Book;

import java.util.List;

public class BookStore {


    public Book[] getBook() {
        return new Book[]{
                new Book("Un drame au Mexique", 10, "Jules Verne"),
                new Book("Un drame dans les airs", 5, "Jules Verne"),
                new Book("Martin Paz ", 15, "Jules Verne"),
                new Book("Maitre Zacharius", 20, "Jules Verne"),
                new Book("Un hivernage dans les glaces ", 25, "Jules Verne"),
                new Book("Cinq semaines en ballon", 10, "Jules Verne"),
                new Book("La Fortune des Rougon", 10, "Emile Zola"),
                new Book("La Curée", 10, "Emile Zola"),
                new Book("Le Ventre de Paris", 10, "Emile Zola"),
                new Book("La Conquête de Plassans", 12, "Emile Zola"),
                new Book("La Faute de l'abbé Mouret", 7, "Emile Zola"),
                new Book("Son Excellence Eugène Rougon", 35, "Emile Zola"),
                new Book("Une vie", 7, "Maupassant"),
                new Book("Bel-Ami", 8, "Maupassant"),
                new Book("Pierre et Jean", 28, "Maupassant"),
                new Book("Mont-Oriol", 52, "Maupassant")
        };
    }
}
