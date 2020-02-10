package top.shaojie.responsibility;

/**
 * @author 少杰
 * <p>
 * 链式调用
 *
 * 当前的这个日志记录器 其实一直都是最高的级别 他需要一级一级的去判断 也就说 你传递了一个等级 过去 吐过比他小
 * 则不输出日志 若大于等于当前的的等级 则输出日志 当想到这个错误的想法时 我没有思考到一个问题 那就是在 回存在 空指针
 * 这个是考虑不周引起的 因为只有当级别最小时 他没有 设置下一级的 日志记录器 但是 实际上 获取的日志记录器 其实是最大的
 * 也就是 ErrorLogger 这时 下一级的 日志记录器肯定不会存在为空的情况 但是当最后一次时 其实还是需要判断的
 *
 * 错误的想法： 而第二个判断下一级的这个 日志记录器不能为空 其实 这里根本不会为空
 * 因为当前的这个 日志记录器的 "链条" 是一个总的 链 他被设置不可能会为空 当然 这个也取决于 设置的时候  但是这里设置的就是最大的
 * 所以只需要继续去比较下一级的 这个 "链条" 也就是日志记录器
 */
public class ChainPatternDemo {

    private static AbstractLogger getChainOfLoggers() {

        // 3
        AbstractLogger errorLogger = new ErrorLogger(AbstractLogger.ERROR);
        // 2
        AbstractLogger fileLogger = new FileLogger(AbstractLogger.DEBUG);
        // 1
        AbstractLogger consoleLogger = new ConsoleLogger(AbstractLogger.INFO);

        // 设置了下一级
        errorLogger.setNextLogger(fileLogger);
        fileLogger.setNextLogger(consoleLogger);

        return errorLogger;
    }

    public static void main(String[] args) {
        // 这里已经设置了这个等级为 3
        AbstractLogger loggerChain = getChainOfLoggers();

        // 1 第一次时 相当于设置了等级当前的记录等级 因为条件是比当前的记录等级 大于或等于 都会被 再次记录
        // 但是显然当前的这个不等级是最小的 因此会被记录一次
        loggerChain.logMessage(AbstractLogger.INFO,
                "This is an information.");

        // 2 第二次时 当前的这个等级 为 info 也就是设置的 1 于是 当 debug 级别被设置为 2 则当前的信息被记录两次
        loggerChain.logMessage(AbstractLogger.DEBUG,
                "This is a debug level information.");

        // 3
        loggerChain.logMessage(AbstractLogger.ERROR,
                "This is an error information.");
    }
}