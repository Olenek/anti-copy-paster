package org.jetbrains.research.anticopypaster;

import com.intellij.AbstractBundle;
import com.intellij.reference.SoftReference;
import org.jetbrains.annotations.PropertyKey;

import java.lang.ref.Reference;
import java.util.ResourceBundle;

public final class AntiCopyPasterBundle {
    private static final String BUNDLE = "AntiCopyPasterBundle";
    private static Reference<ResourceBundle> INSTANCE;

    private AntiCopyPasterBundle() {
    }

    public static String message(@PropertyKey(resourceBundle = BUNDLE) String key, Object... params) {
        return AbstractBundle.message(getBundle(), key, params);
    }

    private static ResourceBundle getBundle() {
        ResourceBundle bundle = SoftReference.dereference(INSTANCE);
        if (bundle == null) {
            bundle = ResourceBundle.getBundle(BUNDLE);
            INSTANCE = new SoftReference<>(bundle);
        }
        return bundle;
    }
}