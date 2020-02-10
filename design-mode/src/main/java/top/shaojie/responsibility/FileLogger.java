package top.shaojie.responsibility;

/**
 * @author 少杰
 * <p>
 * 文件日志
 */
public class FileLogger extends AbstractLogger {

    public FileLogger(int level) {
        this.level = level;
    }

    @Override
    protected void write(String message) {
        System.out.println("File  Console::Logger: " + message);
    }
}