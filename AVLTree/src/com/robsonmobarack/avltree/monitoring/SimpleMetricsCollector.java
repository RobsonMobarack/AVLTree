package com.robsonmobarack.avltree.monitoring;

/**
 * Lightweight implementation that logs metrics to stdout.
 */
public class SimpleMetricsCollector implements MetricsCollector {

  @Override
  public void increment(String metric) {
    System.out.println("[METRIC] increment " + metric);
  }

  @Override
  public void gauge(String metric, double value) {
    System.out.println("[METRIC] gauge " + metric + " = " + value);
  }

  @Override
  public long startTimer(String metric) {
    return System.nanoTime();
  }

  @Override
  public void stopTimer(String metric, long start) {
    long elapsed = System.nanoTime() - start;
    System.out.println("[METRIC] timer " + metric + " = " + elapsed + "ns");
  }
}
