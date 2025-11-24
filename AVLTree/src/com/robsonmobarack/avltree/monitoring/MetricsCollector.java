package com.robsonmobarack.avltree.monitoring;

/**
 * Interface to collect metrics for performance/observability.
 */
public interface MetricsCollector {

  void increment(String metric);

  void gauge(String metric, double value);

  long startTimer(String metric);

  void stopTimer(String metric, long start);
}
