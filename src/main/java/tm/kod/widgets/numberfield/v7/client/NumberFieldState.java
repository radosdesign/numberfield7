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

import com.vaadin.v7.shared.ui.textfield.AbstractTextFieldState;

/**
 * Number field state class with shared strings
 * 
 * @author Kerim O.D.
 * 
 */
public class NumberFieldState extends AbstractTextFieldState {
	/**
	 * Generated serial version UID
	 */
	private static final long serialVersionUID = -5803268179789404932L;
	/**
	 * Is number has negative sign
	 */
	public boolean isSigned = true;
	/**
	 * Is number has grouping
	 */
	public boolean isUseGrouping = false;
	/**
	 * Grouping separator character
	 */
	public char groupingSeparator = ' ';
	/**
	 * Decimal separator character
	 */
	public char decimalSeparator = '.';
	/**
	 * Decimal similar separators
	 */
	public String decimalSimilarSeparators = ".";
	/**
	 * Length of decimal part
	 */
	public int decimalLength = 0;
}