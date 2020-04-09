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
package tm.kod.widgets.numberfield.v7;

import tm.kod.widgets.numberfield.v7.client.NumberFieldState;

import com.vaadin.v7.ui.TextField;
import tm.kod.widgets.numberfield.v7.client.Util;

/**
 * Number input field class, which accepts only numbers and has configuration:
 * <p>
 * 1. Is signed. Default = true;
 * <p>
 * 2. Is use grouping. Default = false;
 * <p>
 * 3. Character of grouping separator. Default = ' ';
 * <p>
 * 4. Character of decimal separator. Default = '.';
 * <p>
 * 5. Is decimal. Default = false;
 * <p>
 *
 * @author Kerim O.D.
 *
 */
public class NumberField extends TextField {

    /**
     * Generated serial version UID
     */
    private static final long serialVersionUID = 7663236836018122696L;

    /**
     * Default constructor
     */
    public NumberField() {
    }

    /**
     * Constructor with caption
     *
     * @param caption
     */
    public NumberField(String caption) {
        super(caption);
    }

    @Override
    protected NumberFieldState getState() {
        return (NumberFieldState) super.getState();
    }

    @Override
    protected NumberFieldState getState(boolean markAsDirty) {
        return (NumberFieldState) super.getState(markAsDirty);
    }

    @Override
    public void setValue(String value) {
        // format value if is not empty 
        if (value != null) {
            value = formatValue(value);
        }
        super.setValue(value);
    }

    public void setDecimalSeparator(char sep) {
        getState().decimalSeparator = sep;
    }

    public char getDecimalSeparator() {
        return getState(false).decimalSeparator;
    }

    public boolean isUseGrouping() {
        return getState(false).isUseGrouping;
    }

    public void setUseGrouping(boolean use) {
        getState().isUseGrouping = use;
    }

    public boolean isSigned() {
        return getState(false).isSigned;
    }

    public void setSigned(boolean signed) {
        getState().isSigned = signed;
    }

    public int getDecimalLength() {
        return getState(false).decimalLength;
    }

    public void setDecimalLength(int decimalLength) {
        getState().decimalLength = decimalLength;
    }

    public String getDecimalSimilarSeparators() {
        return getState(false).decimalSimilarSeparators;
    }

    public void setDecimalSimilarSeparators(String decimalSimilarSeparators) {
        getState().decimalSimilarSeparators = decimalSimilarSeparators;
    }
    
    public void setGroupingSeparator(char sep) {
        getState().groupingSeparator = sep;
    }

    public char getGroupingSeparator() {
        return getState(false).groupingSeparator;
    }

    protected String formatValue(String str) {
        str = str.trim();
        String groupsep = Util.changeIfMetaChar(getGroupingSeparator());
        str = str.replaceAll(groupsep, "");
        if (str.isEmpty() || str.equals("-")) {
            return str;
        }
        if (str.equals("0") || str.equals("-0")) {
            return str;
        }
        str = removeZero(str);
        String decSep = String.valueOf(getDecimalSeparator());
        int p = str.indexOf(decSep);
        String pre, suf;
        if (p != -1) {
            pre = str.substring(0, p);
            suf = str.substring(p);
        } else {
            pre = str;
            suf = "";
        }
        if (isUseGrouping()) {
            // group numbers
            pre = useGrouping(pre);
            pre = pre.replaceAll(" ", groupsep);
        }
        str = pre + suf;
        if (str.startsWith(decSep)) {
            str = "0" + str;
        } else if (str.startsWith("-" + decSep)) {
            str = str.replaceFirst("-" + decSep, "-0" + decSep);
        }
        return str;
    }

    private String removeZero(String value) {
        if (!value.isEmpty()) {
            if (value.startsWith("0")) {
                return removeZero(value.substring(1));
            }
            if (value.startsWith("-0")) {
                return "-" + removeZero(value.substring(2));
            }
        }
        return value;
    }

    private String useGrouping(String s) {
        return s.replaceAll("(\\d{1,3})(?=(?:\\d{3})+$)", "$1 ");
    }
}
