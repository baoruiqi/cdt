package org.eclipse.rse.useractions.ui.uda;

/*******************************************************************************
 * Copyright (c) 2002, 2007 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
import org.eclipse.rse.useractions.UserActionsIcon;
import org.eclipse.swt.graphics.Image;
import org.w3c.dom.Element;

/**
 * Wraps a "Type" XML tag
 */
public class SystemUDTypeElement extends SystemXMLElementWrapper {
	private final static String TYPES_TAG = "Types"; //$NON-NLS-1$
	private final static String TYPE_TAG = "Type"; //$NON-NLS-1$

	/**
	 * Constructor
	 * @param element The actual xml document element for this action
	 * @param tm The subsystemFactory-specific manager of actions
	 * @param domainType - The integer representation of the domain this is in (or this is, for a domain element)
	 */
	public SystemUDTypeElement(Element element, SystemUDTypeManager tm, int domainType) {
		super(element, tm, null, domainType);
	}

	/**
	 * Return image to use for this item, in tree views
	 */
	public Image getImage() {
		//System.out.println("in getImage(): isIBM()="+isIBM()+", isUserChanged()="+isUserChanged());
		Image image = null;
		if (isIBM()) {
			if (isUserChanged())
				image = UserActionsIcon.USERTYPE_IBMUSR.getImage();
			else
				image = UserActionsIcon.USERTYPE_IBM.getImage();
		} else
			image = UserActionsIcon.USERTYPE_USR.getImage();
		//System.out.println("... image returned = "+image);
		return image;
	}

	/**
	 * Return our tag name
	 */
	public String getTagName() {
		return TYPE_TAG;
	}

	/**
	 * Return the list of types
	 */
	public String getTypes() {
		return getTextNode(TYPES_TAG);
	}

	/**
	 * Set the list of types
	 */
	public void setTypes(String s) {
		setUserChanged(true);
		setTextNode(TYPES_TAG, s);
	}
}
