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
import org.eclipse.core.runtime.IConfigurationElement;

/**
 * This class represents a user action read from a user action extension point
 * <p>
 * THIS CLASS IS THE BEGINNING OF SUPPORT FOR USER ACTION EXTENSION POINTS.
 * IT IS NOT COMPLETE YET AND NOT SUPPORTED YET.
 */
public class SystemUserActionExtension {
	private String types, id, vendor;
	private boolean allTypes;

	// SEE FILE plugin.xml.udaExtensionPoint.notused
	/**
	 * Constructor
	 */
	public SystemUserActionExtension(IConfigurationElement element) {
		types = element.getAttribute("systemTypes"); //$NON-NLS-1$
		if ((types == null) || types.equals("*")) //$NON-NLS-1$
			allTypes = true;
		id = element.getAttribute("id"); //$NON-NLS-1$
		vendor = element.getAttribute("vendor"); //$NON-NLS-1$
	}

	/**
	 * Return the value of the "vendor" attribute
	 */
	public String getVendor() {
		return vendor;
	}

	/**
	 * Return the value of the "id" attribute
	 */
	public String getId() {
		return id;
	}

	/**
	 * Return true if this extension's systemTypes attribute matches the given system type
	 */
	public boolean appliesToSystemType(String type) {
		//System.out.println("INSIDE APPLIESTO FOR " + type + ". allTypes = " + allTypes + ". types = " + types);
		if (allTypes)
			return true;
		else
			return (types.indexOf(type) >= 0);
	}
}
