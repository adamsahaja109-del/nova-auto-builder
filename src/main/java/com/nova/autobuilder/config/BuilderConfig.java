package com.nova.autobuilder.config;

public class BuilderConfig {
    private static int buildSpeed = 5; // Block per tick / second multiplier
    private static boolean isPaused = false;
    private static boolean isRunning = false;

    public static int getBuildSpeed() { return buildSpeed; }
    public static void setBuildSpeed(int speed) { buildSpeed = speed; }

    public static boolean isPaused() { return isPaused; }
    public static void setPaused(boolean paused) { isPaused = paused; }

    public static boolean isRunning() { return isRunning; }
    public static void setRunning(boolean running) { isRunning = running; }
}
