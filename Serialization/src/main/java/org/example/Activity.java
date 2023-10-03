package org.example;

enum Activity {
    HOME("сидит дома"),
    KINDERGARTEN("ходит в детский сад"),
    SCHOOL("учится в школе"),
    UNIVERSITY("учится в институте"),
    WORK("работает"),
    RETIREMENT("на пенсии");

    private final String activityName;

    Activity(String activityName) {
        this.activityName = activityName;
    }

    public String getActivityName() {
        return activityName;
    }
}
