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

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Optional;

public abstract class PlatformBase implements Platform {

    public static final String USER_HOME = System.getProperty("user.home");

    @Override
    public Optional<Path> getUserHomeDir() {
        return Optional.of(Paths.get(USER_HOME));
    }

    protected final Path buildPath(String... pathElements) {
        return Paths.get(pathElements[0], Arrays.asList(pathElements).subList(1, pathElements.length).toArray(new String[pathElements.length - 1]));
    }
}
