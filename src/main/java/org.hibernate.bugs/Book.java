package org.hibernate.bugs;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Data
@RequiredArgsConstructor(staticName = "of")
@NoArgsConstructor
@ToString(exclude = "authors")
@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NonNull private String isbn;
    @NonNull private String title;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "book")
    private List<Author> authors = new ArrayList<>();

    public void addAuthor(Author author) {
        this.authors.add(author);
        author.setBook(this);
    }
}
