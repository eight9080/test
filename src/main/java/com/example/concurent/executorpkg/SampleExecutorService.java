package com.example.concurent.executorpkg;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class SampleExecutorService {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        simpleExecutor();
        batchCall();
    }

    private static void simpleExecutor() throws ExecutionException, InterruptedException {
        final ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.execute(() -> {
            final String name = Thread.currentThread().getName();
            System.out.println("Hello execute " + name);
        });

        //runnable
        final Future<?> submit = executorService.submit(() -> {
            final String name = Thread.currentThread().getName();
            System.out.println("Hello submit " + name);
        });
        System.out.println("Future submit value "+ submit.get()); //returns null if the task has finished successfully


        //callable
        final Future<String> submitCallable = executorService.submit(() -> "task1");
        System.out.println("Future submit callable "+ submitCallable.get()); //returns task1


    }

    private static void batchCall() throws InterruptedException, ExecutionException {
        System.out.println("******* Invoke All **********");
        // invokeAll -> batch submitting of multiple callables at once.
        // It accepts a collection of callables and returns a list of futures
        final ExecutorService executorService = Executors.newFixedThreadPool(1);

        final List<Callable<String>> callables = Arrays.asList(
                () -> "t1",
                () -> "t2"
        );

        executorService.invokeAll(callables)
                .stream()
                .map(stringFuture -> {
                    try {
                        return stringFuture.get();
                    } catch (InterruptedException | ExecutionException e) {
                        throw  new IllegalStateException(e);
                    }
                })
                .forEach(System.out::println);

        // InvokeAny - Instead of returning future objects
        // it blocks until the first callable terminates and returns the result of that callable.
        System.out.println("******* Invoke Any **********");
        final ExecutorService executorServiceStealing = Executors.newWorkStealingPool();
        final List<Callable<String>> callablesParallel = Arrays.asList(() -> {
            Thread.sleep(1000);
            return "task1";
        }, () -> "task2");
        final String result = executorServiceStealing.invokeAny(callablesParallel);
        System.out.println("Result invokeAny "+ result);


    }




}
