import du.DuLauncher;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DuLauncherTest {

    @Test
    void launch_err() {
        String[] cmdLine = {"-c", "-h", "input/nosuchfile.txt"}; // Такого файла нет -> проверяем, что result=1
        du.DuLauncher launcher = new DuLauncher();
        launcher.launch(cmdLine);
        assertEquals(1, launcher.result);
    }

    @Test
    void launch_ok() {
        String[] cmdLine = {"-c", "-h", "input/Test/test.bin"}; // Такой файл есть -> проверяем, что result=0
        DuLauncher launcher = new DuLauncher();
        launcher.launch(cmdLine);
        assertEquals(0, launcher.result);
    }
}