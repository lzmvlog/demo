package top.shaojie.responsibility;

/**
 * @author 少杰
 * <p>
 * 打印日志
 */
public class ConsoleLogger extends AbstractLogger {

    public ConsoleLogger(int level) {
        this.level = level;
    }

    @Override
    protected void write(String message) {
        System.out.println("Standard Console::Logger: " + message);
    }

}