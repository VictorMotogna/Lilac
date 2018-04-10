package com.victormotogna.lilac.dependency_injection;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {LilacModule.class})
public interface LilacComponent extends LilacGraph {

    final class Initializer {

        public Initializer() {

        }

        public static LilacComponent init(Context context) {
            return DaggerLilacComponent.builder()
                    .lilacModule(new LilacModule(context)).build();
        }
    }
}
