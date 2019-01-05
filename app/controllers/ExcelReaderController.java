package controllers;

import models.Book;
import play.mvc.Controller;
import play.mvc.Result;
import services.Counter;
import services.ExcelReader;
import views.html.books.index;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.List;

/**
 * This controller demonstrates how to use dependency injection to
 * bind a component into a controller class. The class contains an
 * action that shows an incrementing count to users. The {@link Counter}
 * object is injected by the Guice dependency injection system.
 */
@Singleton
public class ExcelReaderController extends Controller {



    @Inject
    public ExcelReaderController() {

    }

    /**
     * An action that responds with the {@link Counter}'s current
     * count. The result is plain text. This action is mapped to
     * <code>GET</code> requests with a path of <code>/count</code>
     * requests by an entry in the <code>routes</code> config file.
     */
    public Result read() {
        List<Book> books = ExcelReader.readExcel();
        return ok(index.render(books));
    }

}
