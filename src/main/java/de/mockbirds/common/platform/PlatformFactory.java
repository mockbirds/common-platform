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

import org.apache.commons.lang3.SystemUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class PlatformFactory {

    private static final Logger LOGGER = LoggerFactory.getLogger(PlatformFactory.class);

    private static Platform platform;

    public static Platform getPlatform() {

        if(platform == null) {
            if (SystemUtils.IS_OS_MAC) {
                platform = new de.mockbirds.common.platform.impl.mac.PlatformImpl();
            } else if (SystemUtils.IS_OS_WINDOWS) {
//                platform = new de.mockbirds.common.platform.impl.windows.PlatformImpl();
            } else {
                LOGGER.warn("Operating system not supported: {}", SystemUtils.OS_NAME);
            }
        }
        return platform;
    }
}
