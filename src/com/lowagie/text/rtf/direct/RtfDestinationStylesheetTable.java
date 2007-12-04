/*
 * $Id$
 * $Name$
 *
 * Copyright 2007 by Howard Shank (hgshank@yahoo.com)
 *
 * The contents of this file are subject to the Mozilla Public License Version 1.1
 * (the "License"); you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at http://www.mozilla.org/MPL/
 *
 * Software distributed under the License is distributed on an "AS IS" basis,
 * WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License
 * for the specific language governing rights and limitations under the License.
 *
 * The Original Code is 'iText, a free JAVA-PDF library'.
 *
 * The Initial Developer of the Original Code is Bruno Lowagie. Portions created by
 * the Initial Developer are Copyright (C) 1999-2006 by Bruno Lowagie.
 * All Rights Reserved.
 * Co-Developer of the code is Paulo Soares. Portions created by the Co-Developer
 * are Copyright (C) 2000-2006 by Paulo Soares. All Rights Reserved.
 *
 * Contributor(s): all the names of the contributors are added in the source code
 * where applicable.
 *
 * Alternatively, the contents of this file may be used under the terms of the
 * LGPL license (the ?GNU LIBRARY GENERAL PUBLIC LICENSE?), in which case the
 * provisions of LGPL are applicable instead of those above.  If you wish to
 * allow use of your version of this file only under the terms of the LGPL
 * License and not to allow others to use your version of this file under
 * the MPL, indicate your decision by deleting the provisions above and
 * replace them with the notice and other provisions required by the LGPL.
 * If you do not delete the provisions above, a recipient may use your version
 * of this file under either the MPL or the GNU LIBRARY GENERAL PUBLIC LICENSE.
 *
 * This library is free software; you can redistribute it and/or modify it
 * under the terms of the MPL as stated above or under the terms of the GNU
 * Library General Public License as published by the Free Software Foundation;
 * either version 2 of the License, or any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Library general Public License for more
 * details.
 *
 * If you didn't download this code from the following link, you should check if
 * you aren't using an obsolete version:
 * http://www.lowagie.com/iText/
 */
 
package com.lowagie.text.rtf.direct;

import com.lowagie.text.rtf.style.*;
import com.lowagie.text.Element;

/**
 * <code>RtfDestinationStylesheetTable</code> handles data destined for the 
 * Stylesheet Table destination according to the RTF Specification.
 * 
 * @author Howard Shank (hgshank@yahoo.com)
 *
 */
public class RtfDestinationStylesheetTable implements RtfDestination {
	
	/**
	 * <code>RtfParagraphStyle</code> object for setting styleshee values
	 * as they are parsed from the input.
	 */
	private RtfParagraphStyle rtfParagraphStyle = null;
	
	/**
	 * RTF Style number from stylesheet table.
	 */
	private int styleNr = 0;
	
	/**
	 * What kind of style is this, Paragraph or Character 
	 */
	private int styleType = RtfStyleTypes.PARAGRAPH;
	
	// Alignment
	/**
	 * Alignment - page 85
	 * 	\qc, \qj, \ql, \qr, \qd, \qkN, \qt 
	 */
	private int alignment = Element.ALIGN_LEFT;
	/**
	 * Percentage of line occupied by Kashida justification (0 � low, 10 � medium, 20 � high).
	 * \qkN
	 */
	private int justificationPercentage = 0;
	
	// Indentation
	/**
	 * First line indentation.
	 */
	private int firstLineIndent = 0;
	/**
	 * Left indentation
	 */
	private int leftIndent = 0;
	/**
	 * Right indentation
	 */
	private int rightIndent = 0;
	/**
	 *  Automatically adjust right indentation when docunent grid is defined 
	 */
	private int adustRightIndent = 0;
	/**
	 *  Mirror indents? 
	 */
	private int mirrorIndent = 0;
	
	// Document Foratting Properties
	/**
	 * Override orphan/widow control.
	 */
	private int overrideWidowControl = -1;
	
	// Asian Typography
	/**
	 * auto spacing betwee DBC and English
	 */
	private int AutoSpaceBetweenDBCEnglish = 0;
	/**
	 * auto spacing betwee DBC and numbers
	 */
	private int AutoSpaceBetweenDBCNumbers = 0;
	/**
	 * No Character wrapping
	 */
	private int noCharacterWrapping = 0;
	/**
	 * No Word wrapping
	 */
	private int noWordWrapping = 0;
	/**
	 * No overflow period and comma
	 */
	private int noOverflowPeriodComma = 0;
	
	
	
	//////////////////////////////////////////////////////
	/**
	 * The RtfImportHeader to add color mappings to.
	 */
	private RtfImportMgr importHeader = null;
	
	public RtfDestinationStylesheetTable(RtfImportMgr importHeader) {
		this.importHeader = importHeader;
		//this.clear();
	}
	/* (non-Javadoc)
	 * @see com.lowagie.text.rtf.direct.IRtfDestination#closeDestination()
	 */
	public boolean closeDestination() {

		return false;
	}

	/* (non-Javadoc)
	 * @see com.lowagie.text.rtf.direct.IRtfDestination#handleBinaryData(byte[])
	 */
	public boolean handleBinaryData(byte[] binData) {

		return false;
	}

	/* (non-Javadoc)
	 * @see com.lowagie.text.rtf.direct.IRtfDestination#handleControlWord(java.lang.String, int)
	 */
	public boolean handleControlWord(String ctrlWord, int param) {

		return false;
	}

	/* (non-Javadoc)
	 * @see com.lowagie.text.rtf.direct.IRtfDestination#handleControlWord(java.lang.String)
	 */
	public boolean handleControlWord(String ctrlWord) {

		return false;
	}

	/* (non-Javadoc)
	 * @see com.lowagie.text.rtf.direct.IRtfDestination#handleGroupEnd()
	 */
	public boolean handleGroupEnd() {

		return false;
	}

	/* (non-Javadoc)
	 * @see com.lowagie.text.rtf.direct.IRtfDestination#handleGroupStart()
	 */
	public boolean handleGroupStart() {

		return false;
	}
	/* (non-Javadoc)
	 * @see com.lowagie.text.rtf.direct.IRtfDestination#handleCharacter(char[])
	 */
	public boolean handleCharacter(char[] ch) {

		return false;
	}
	/* (non-Javadoc)
	 * @see com.lowagie.text.rtf.direct.IRtfDestination#handleText(char)
	 */
	public boolean handleText(char ch) {

		return false;
	}

	/* (non-Javadoc)
	 * @see com.lowagie.text.rtf.direct.IRtfDestination#handleText(java.lang.String)
	 */
	public boolean handleText(String text) {

		return false;
	}
	
	public void createNewStyle() {
		//public RtfParagraphStyle(String styleName, String fontName, int fontSize, int fontStyle, Color fontColor)
		//this.rtfParagraphStyle = new RtfParagraphStyle();
	}
	
	/**
	 * Reset the default values. 
	 */
	private void clear() {
		styleNr = 0;
		alignment = Element.ALIGN_LEFT;
		justificationPercentage = 0;
		firstLineIndent = 0;
		leftIndent = 0;
		rightIndent = 0;
		adustRightIndent = 0;
		mirrorIndent = 0;
		overrideWidowControl = -1;
		AutoSpaceBetweenDBCEnglish = 0;
		AutoSpaceBetweenDBCNumbers = 0;
		noCharacterWrapping = 0;
		noWordWrapping = 0;
		noOverflowPeriodComma = 0;
	}
	/**
	 * Set the justification percentage from parsed value.
	 * @param percent The justification percentage
	 * @return The justification percentage
	 */
	public int setJustificationPercentage(int percent) {
		this.justificationPercentage = percent;
		return this.justificationPercentage;
	}
	/**
	 * Get the justification percentage.
	 * @return The justification percentage value.
	 */
	public int getJustificationPercentage() {
		return this.justificationPercentage;
	}
	/**
	 * Set the alignment value from the parsed value.
	 * @param alignment The alignment value.
	 * @return The alignment value.
	 */
	public int setAlignment(int alignment) {
		this.alignment = alignment;
		return this.alignment;
	}
	/**
	 * Get the alignment value.
	 * @return The alignment value.
	 */
	public int getAlignment() {
		return this.alignment;
	}
	/**
	 * Get the first line indent value.
	 * 
	 * @return the firstLineIndent
	 */
	public int getFirstLineIndent() {
		return firstLineIndent;
	}
	/**
	 * Set the first line indent value.
	 * @param firstLineIndent the firstLineIndent to set
	 */
	public void setFirstLineIndent(int firstLineIndent) {
		this.firstLineIndent = firstLineIndent;
	}
	/**
	 * Get the left indent value
	 * @return the left indent
	 */
	public int getIndent() {
		return leftIndent;
	}
	/**
	 * Set the left indent value from the value parsed.
	 * @param indent the left indent value.
	 */
	public void setIndent(int indent) {
		this.leftIndent = indent;
	}
	/**
	 * Get the right indent adjustment value
	 * @return the adustRightIndent value
	 */
	public int getAdustRightIndent() {
		return adustRightIndent;
	}
	/**
	 * Set the right indent adjustment value
	 * @param adustRightIndent the adustRightIndent to set
	 */
	public void setAdustRightIndent(int adustRightIndent) {
		this.adustRightIndent = adustRightIndent;
	}
	/**
	 * Get the left indent value
	 * @return the leftIndent
	 */
	public int getLeftIndent() {
		return leftIndent;
	}
	/**
	 * Set the left indent value
	 * @param leftIndent the leftIndent to set
	 */
	public void setLeftIndent(int leftIndent) {
		this.leftIndent = leftIndent;
	}
	/**
	 * Get the value indicating if document has mirrored indents.
	 * 
	 * @return the mirrorIndent
	 */
	public int getMirrorIndent() {
		return mirrorIndent;
	}
	/**
	 * Set the mirrored indent value from the parsed value.
	 * 
	 * @param mirrorIndent the mirrorIndent to set
	 */
	public void setMirrorIndent(int mirrorIndent) {
		this.mirrorIndent = mirrorIndent;
	}
	/**
	 * Get the right indent value.
	 * 
	 * @return the rightIndent
	 */
	public int getRightIndent() {
		return rightIndent;
	}
	/**
	 * Set the right indent value.
	 * 
	 * @param rightIndent the rightIndent to set
	 */
	public void setRightIndent(int rightIndent) {
		this.rightIndent = rightIndent;
	}
	/**
	 * Get the ovirride widow control value.
	 * 
	 * @return the overrideWidowControl
	 */
	public int getOverrideWidowControl() {
		return overrideWidowControl;
	}
	/**
	 * Set the override widow control.
	 * 
	 * @param overrideWidowControl the overrideWidowControl to set
	 */
	public void setOverrideWidowControl(int overrideWidowControl) {
		this.overrideWidowControl = overrideWidowControl;
	}
	/**
	 * Get the auto space between DBC and English indicator.
	 * 
	 * @return the autoSpaceBetweenDBCEnglish
	 */
	public int getAutoSpaceBetweenDBCEnglish() {
		return AutoSpaceBetweenDBCEnglish;
	}
	/**
	 * Set the auto space between DBC and English indicator.
	 * 
	 * @param autoSpaceBetweenDBCEnglish the autoSpaceBetweenDBCEnglish to set
	 */
	public void setAutoSpaceBetweenDBCEnglish(int autoSpaceBetweenDBCEnglish) {
		AutoSpaceBetweenDBCEnglish = autoSpaceBetweenDBCEnglish;
	}
	/**
	 * Get the auto space between DBC and Numbers indicator.
	 * @return the autoSpaceBetweenDBCNumbers
	 */
	public int getAutoSpaceBetweenDBCNumbers() {
		return AutoSpaceBetweenDBCNumbers;
	}
	/**
	 * Set the auto space between DBC and Numbers indicator.
	 * @param autoSpaceBetweenDBCNumbers the autoSpaceBetweenDBCNumbers to set
	 */
	public void setAutoSpaceBetweenDBCNumbers(int autoSpaceBetweenDBCNumbers) {
		AutoSpaceBetweenDBCNumbers = autoSpaceBetweenDBCNumbers;
	}
	/**
	 * Get no character wrapping indicator.
	 * 
	 * @return the noCharacterWrapping
	 */
	public int getNoCharacterWrapping() {
		return noCharacterWrapping;
	}
	/**
	 * Set the no character wrapping indicator from parsed value
	 * 
	 * @param noCharacterWrapping the noCharacterWrapping to set
	 */
	public void setNoCharacterWrapping(int noCharacterWrapping) {
		this.noCharacterWrapping = noCharacterWrapping;
	}
	/**
	 * Get the no overflow period comma indicator.
	 * 
	 * @return the noOverflowPeriodComma
	 */
	public int getNoOverflowPeriodComma() {
		return noOverflowPeriodComma;
	}
	/**
	 * Set the no overflow period comma indicator from the parsed value.
	 * 
	 * @param noOverflowPeriodComma the noOverflowPeriodComma to set
	 */
	public void setNoOverflowPeriodComma(int noOverflowPeriodComma) {
		this.noOverflowPeriodComma = noOverflowPeriodComma;
	}
	/**
	 * Get the no word wrapping indicator.
	 * 
	 * @return the noWordWrapping
	 */
	public int getNoWordWrapping() {
		return noWordWrapping;
	}
	/**
	 * Set the no word wrapping indicator from the parsed value.
	 * 
	 * @param noWordWrapping the noWordWrapping to set
	 */
	public void setNoWordWrapping(int noWordWrapping) {
		this.noWordWrapping = noWordWrapping;
	}
	/**
	 * Get this style number.
	 * 
	 * @return the styleNr
	 */
	public int getStyleNr() {
		return styleNr;
	}
	/**
	 * Set this style number from the parsed value.
	 * 
	 * @param styleNr the styleNr to set
	 */
	public void setStyleNr(int styleNr) {
		this.styleNr = styleNr;
	}
	/**
	 * Get this style type.
	 * For example Style, Character Style, etc.
	 * 
	 * @return the styleType
	 */
	public int getStyleType() {
		return styleType;
	}
	/**
	 * Set the style type.
	 * 
	 * @param styleType the styleType to set
	 */
	public void setStyleType(int styleType) {
		this.styleType = styleType;
	}


}
