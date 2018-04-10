package com.victormotogna.lilac.dependency_injection;

import android.app.Application;

public class LilacApp extends Application {
    private static LilacGraph lilacGraph;

    public static LilacGraph component() {
        return lilacGraph;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        lilacGraph = LilacComponent.Initializer.init(this);
    }
}
