package ru.af3412.benchpost;

import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

public class UserAgregatorBenchmarkMain {
    public static void main(String[] args) throws RunnerException {
        final Options options = new OptionsBuilder()
                .include(UserAgregator.class.getSimpleName())
                .forks(1)
                .build();

        new Runner(options).run();
    }
}
