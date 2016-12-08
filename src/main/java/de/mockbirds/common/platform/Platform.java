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

package de.mockbirds.common.platform;

import java.io.File;
import java.nio.file.Path;
import java.util.Optional;

public interface Platform {

    //----------------------------------------------------------------------------------------------

    Optional<Path> getCacheDir(String appName, String appVersion);

    Optional<Path> getConfigurationDir(String appName, String appVersion);

    Optional<Path> getDataDir(String appName, String appVersion);

    Optional<Path> getLoggingDir(String appName, String appVersion);

    Optional<Path> getPreferencesDir();

    Optional<Path> getPreferencesDir(String appName, String appVersion);

    Optional<File> getPreferencesFile(Class<?> appClass, String appName, String appVersion);

    //----------------------------------------------------------------------------------------------

    Optional<Path> getUserHomeDir();

    Optional<Path> getUserCacheDir(String appName, String appVersion);

    Optional<Path> getUserConfigurationDir(String appName, String appVersion);

    Optional<Path> getUserDataDir(String appName, String appVersion);

    Optional<Path> getUserLoggingDir(String appName, String appVersion);

    Optional<Path> getUserPreferencesDir();

    Optional<Path> getUserPreferencesDir(String appName, String appVersion);

    Optional<File> getUserPreferencesFile(Class<?> appClass, String appName, String appVersion);

}
