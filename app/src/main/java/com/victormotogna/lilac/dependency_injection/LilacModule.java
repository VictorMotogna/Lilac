package com.victormotogna.lilac.dependency_injection;

import android.content.Context;

import dagger.Module;
import dagger.Provides;

@Module
public class LilacModule {
    private Context context;

    public LilacModule(Context context) {
        this.context = context;
    }

    @Provides
    public Context provideContext() {
        return context;
    }
}
