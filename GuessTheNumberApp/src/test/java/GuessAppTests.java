

import com.epam.guessapp.common.GuessApp;
import com.epam.guessapp.generators.SimpleNumberGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import com.epam.guessapp.readers.ConsoleInputReaderImpl;
import com.epam.guessapp.writers.ConsoleOutputWriterImpl;

public class GuessAppTests {

    final int Boundary = 100;

    private SimpleNumberGenerator simpleNumberGenerator;
    private ConsoleOutputWriterImpl consoleOutputWriter;
    private ConsoleInputReaderImpl consoleInputReader;

    private GuessApp app;

    @BeforeEach
    private void init()
    {
        simpleNumberGenerator = Mockito.mock(SimpleNumberGenerator.class);
        consoleOutputWriter = Mockito.mock(ConsoleOutputWriterImpl.class);
        consoleInputReader = Mockito.mock(ConsoleInputReaderImpl.class);

        app = new GuessApp(simpleNumberGenerator, consoleInputReader, consoleOutputWriter);
    }

    @Test
    public void runPrintsBingoWhenYouProvideCorrectNumber()
    {
        Mockito.when(simpleNumberGenerator.generateNextNumber(Boundary)).thenReturn(50);
        // Mockito.when(consoleOutputWriter.Print(anyString()));

        // app.run();
    }
}
