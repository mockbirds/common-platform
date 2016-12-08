/*
 * Copyright (C) 2016 Steffen Rose
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package de.mockbirds.common.platform.impl.mac;

import de.mockbirds.common.platform.PlatformBase;

import java.io.File;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Optional;
import java.util.prefs.Preferences;
import java.util.stream.Collectors;

public class PlatformImpl extends PlatformBase {

    @Override
    public Optional<Path> getCacheDir(String appName, String appVersion) {
        return Optional.of(buildPath("/Library/Caches", appName, appVersion));
    }

    public Optional<Path> getConfigurationDir(String appName, String appVersion) {
        return getDataDir(appName, appVersion);
    }

    public Optional<Path> getDataDir(String appName, String appVersion) {
        return Optional.of(buildPath("/Library/Application Support", appName, appVersion));
    }

    @Override
    public Optional<Path> getLoggingDir(String appName, String appVersion) {
        return Optional.of(buildPath("/Library/Logs", appName, appVersion));
    }

    @Override
    public Optional<Path> getPreferencesDir() {
        return Optional.of(buildPath("/Library/Preferences"));
    }

    @Override
    public Optional<Path> getPreferencesDir(String appName, String appVersion) {
        return Optional.of(buildPath("/Library/Preferences", appName, appVersion));
    }

    @Override
    public Optional<File> getPreferencesFile(Class<?> appClass, String appName, String appVersion) {
        Optional<Path> userPreferencesDir = getPreferencesDir();
        if(userPreferencesDir.isPresent()) {
            String absolutePath = Preferences.systemNodeForPackage(appClass).absolutePath();
            String prefFile = Arrays.stream(absolutePath.split("/")).skip(1).limit(3).collect(Collectors.joining(".")) + ".plist";
            return Optional.of(userPreferencesDir.get().resolve(prefFile).toFile());
        }
        return Optional.empty();
    }

    @Override
    public Optional<Path> getUserCacheDir(String appName, String appVersion) {
        return Optional.of(buildPath(PlatformBase.USER_HOME, "/Library/Caches", appName, appVersion));
    }

    @Override
    public Optional<Path> getUserConfigurationDir(String appName, String appVersion) {
        return getUserDataDir(appName, appVersion);
    }

    @Override
    public Optional<Path> getUserDataDir(String appName, String appVersion) {
        return Optional.of(buildPath(PlatformBase.USER_HOME, "/Library/Application Support", appName, appVersion));
    }

    @Override
    public Optional<Path> getUserLoggingDir(String appName, String appVersion) {
        return Optional.of(buildPath(PlatformBase.USER_HOME, "/Library/Logs", appName, appVersion));
    }

    @Override
    public Optional<Path> getUserPreferencesDir() {
        return Optional.of(buildPath(PlatformBase.USER_HOME, "/Library/Preferences"));
    }

    @Override
    public Optional<Path> getUserPreferencesDir(String appName, String appVersion) {
        return Optional.of(buildPath(PlatformBase.USER_HOME, "/Library/Preferences", appName, appVersion));
    }

    @Override
    public Optional<File> getUserPreferencesFile(Class<?> appClass, String appName, String appVersion) {
        Optional<Path> userPreferencesDir = getUserPreferencesDir();
        if(userPreferencesDir.isPresent()) {
            String absolutePath = Preferences.userNodeForPackage(appClass).absolutePath();
            String prefFile = Arrays.stream(absolutePath.split("/")).skip(1).limit(3).collect(Collectors.joining(".")) + ".plist";
            return Optional.of(userPreferencesDir.get().resolve(prefFile).toFile());
        }
        return Optional.empty();
    }
}
