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

import tm.kod.widgets.numberfield.v7.NumberField;

import com.vaadin.client.communication.StateChangeEvent;
import com.vaadin.v7.client.ui.textfield.TextFieldConnector;
import com.vaadin.shared.ui.Connect;

/**
 * Client side number field connector class
 *
 * @author Kerim O.D.
 *
 */
@Connect(value = NumberField.class)
public class NumberFieldConnector extends TextFieldConnector {

    /**
     * Generated serial version UID
     */
    private static final long serialVersionUID = -5531145613926511796L;

    public NumberFieldConnector() {
    }

    @Override
    public NumberFieldState getState() {
        return (NumberFieldState) super.getState();
    }

    @Override
    public NumberFieldWidget getWidget() {
        return (NumberFieldWidget) super.getWidget();
    }

    @Override
    public void onStateChanged(StateChangeEvent event) {
        NumberFieldWidget widget = getWidget();
        NumberFieldState state = getState();
        widget.setSigned(state.isSigned);
        widget.setDecimalLength(state.decimalLength);
        widget.setDecimalSeparator(state.decimalSeparator);
        widget.setDecimalSimilarSeparators(state.decimalSimilarSeparators);
        widget.setUseGrouping(state.isUseGrouping);
        widget.setGroupingSeparator(state.groupingSeparator);
        super.onStateChanged(event);
    }

}
