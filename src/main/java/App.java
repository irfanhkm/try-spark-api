import com.google.inject.Guice;
import com.google.inject.Injector;
import com.irfanhkm.config.GuiceModule;
import com.irfanhkm.controller.backoffice.MovieController;
import com.irfanhkm.model.MovieRepository;

public class App {
    private static final String TEST_PERSISTENCE_UNIT_NAME = "try_spark_api";
    private static final String REPOSITORIES_BASE_PACKAGE_NAME = "com.irfanhkm.model";

    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new GuiceModule(TEST_PERSISTENCE_UNIT_NAME, REPOSITORIES_BASE_PACKAGE_NAME));

        MovieRepository movieRepository = injector.getInstance(MovieRepository.class);
        MovieController movieController = injector.getInstance(MovieController.class);
        movieController.routes();

    }
}
