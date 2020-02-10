package top.shaojie.responsibility;

/**
 * @author 少杰
 * <p>
 * 抽象日志记录器
 */
public abstract class AbstractLogger {

    // 可以理解成 log 日志记录的次数
    public static int INFO = 1;
    public static int DEBUG = 2;
    public static int ERROR = 3;

    /**
     * 等级
     */
    protected int level;

    //责任链中的下一个元素
    protected AbstractLogger nextLogger;

    // 设置责任链中的元素
    public void setNextLogger(AbstractLogger nextLogger) {
        this.nextLogger = nextLogger;
    }

    /**
     * 设置 log 的等级
     *
     * @param level   等级
     * @param message 信息
     */
    public void logMessage(int level, String message) {
        // 如果传过来的 level 比当前的大 那么输出当前的日志信息
        if (this.level <= level) {
            write(message);
        }
        // 如果下一个 日志级别记录器 不为空 则 在调用一次 不加判断可能会出现空指针
        if (nextLogger != null) {
            nextLogger.logMessage(level, message);
        }
    }

    abstract protected void write(String message);

}