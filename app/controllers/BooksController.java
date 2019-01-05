package controllers;

import models.Book;
import play.data.Form;
import play.data.FormFactory;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.books.*;

import javax.inject.Inject;
import java.util.List;
import java.util.Set;

import static play.libs.Scala.asScala;

public class BooksController extends Controller {

    @Inject
    FormFactory formFactory;

    //For all books
    public Result index() {
        session("connected", "user@gmail.com");
        List<Book> books = Book.find.all();

        return ok(index.render(books));
    }

    //For all books
    public Result show(Integer id) {

        Book book = Book.find.byId(id);
        if (book == null) {
            return notFound("Book Not Found");
        }
        return ok(show.render(book));

    }

    //To create book
    public Result create() {
        String s=session("connected");
        System.out.println(s);
        Form<Book> form = formFactory.form(Book.class);

        return ok(create.render(form));
    }

    //To save book
    public Result save() {
        Form<Book> form = formFactory.form(Book.class).bindFromRequest();
        if (form.hasErrors()) {

            flash("danger","please enter values");
            return badRequest(create.render(form));
        } else {
            Book book = form.get();
            book.save();
            return redirect(routes.BooksController.index());
        }
    }

    public Result edit(Integer id) {

        Book book = Book.find.byId(id);

        if (book == null) {
            return notFound("Book Not Found");
        }

        Form<Book> bookForm = formFactory.form(Book.class).fill(book);


        return ok(edit.render(bookForm));
    }

    public Result update() {
        Book book = formFactory.form(Book.class).bindFromRequest().get();

        Book oldBook = Book.find.byId(book.id);

        if (oldBook == null) {
            return notFound("Not found");
        }

        oldBook.title = book.title;
        oldBook.price = book.price;
        oldBook.author = book.author;
        oldBook.update();

        return redirect(routes.BooksController.index());
    }

    public Result destroy(Integer id) {

        Book book = Book.find.byId(id);

        if (book == null) {
            return notFound("Book Not Found");
        }
        book.delete();
        return redirect(routes.BooksController.index());
    }

}
