/*
 * Copyright 2015 Kerim O.D.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package tm.kod.widgets.numberfield.v7.client;

/**
 *
 * @author Kerim O.D.
 */
public class Util {

    /**
     * Meta-chars of regular expression
     */
    public static final String META_CHARS = "^$()<>[]{}|.*+?";

    /**
     * Getting character as string, method changes value if is meta-character by
     * pre-adding "\"
     *
     * @param character
     * @return character as string
     */
    public static String changeIfMetaChar(char character) {
        String string = String.valueOf(character);
        if (META_CHARS.contains(string)) { // if contains pre-add '\'
            return "\\" + character;
        }
        return string;
    }
}
