package models;

import io.ebean.Finder;
import io.ebean.Model;
import play.data.validation.Constraints;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Book extends Model {
    @Column
    @Id
    public Integer id;
    @Column
    @Constraints.Required
    public String title;
    @Column
    @Constraints.Required
    public Integer price;
    @Column
    @Constraints.Required
    public String author;

    public static Finder<Integer, Book> find = new Finder<>(Book.class);

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

}
