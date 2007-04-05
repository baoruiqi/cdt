/********************************************************************************
 * Copyright (c) 2006, 2007 IBM Corporation. All rights reserved.
 * This program and the accompanying materials are made available under the terms
 * of the Eclipse Public License v1.0 which accompanies this distribution, and is 
 * available at http://www.eclipse.org/legal/epl-v10.html
 * 
 * Initial Contributors:
 * The following IBM employees contributed to the Remote System Explorer
 * component that contains this file: David McKnight, Kushal Munir, 
 * Michael Berger, David Dykstal, Phil Coulthard, Don Yantzi, Eric Simpson, 
 * Emily Bruner, Mazen Faraj, Adrian Storisteanu, Li Ding, and Kent Hawley.
 * 
 * Contributors:
 * David Dykstal (IBM) - added javadoc
 * David Dykstal (IBM) - [150939] added read-only attribute
 ********************************************************************************/

package org.eclipse.rse.core.model;

/**
 * 
 */
public class Property implements IProperty {
	
	private String _name;
	private String _label;
	private String _value;
	private IPropertyType _type;
	private boolean _isEnabled = true;
	private boolean _isReadOnly = false;

	public Property(IProperty property) {
		_name = property.getKey();
		_label = property.getLabel();
		_value = property.getValue();
		_type = property.getType();
		_isEnabled = property.isEnabled();
	}

	public Property(String name, String value, IPropertyType type, boolean isEnabled) {
		_name = name;
		_value = value;
		_type = type;
		_isEnabled = isEnabled;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.rse.core.model.IProperty#getKey()
	 */
	public String getKey() {
		return _name;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.rse.core.model.IProperty#setLabel(java.lang.String)
	 */
	public void setLabel(String label) {
		_label = label;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.rse.core.model.IProperty#getLabel()
	 */
	public String getLabel() {
		if (_label == null) {
			return _name;
		}
		return _label;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.rse.core.model.IProperty#setValue(java.lang.String)
	 */
	public void setValue(String value) {
		_value = value;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.rse.core.model.IProperty#getValue()
	 */
	public String getValue() {
		return _value;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.rse.core.model.IProperty#setType(org.eclipse.rse.core.model.IPropertyType)
	 */
	public void setType(IPropertyType type) {
		_type = type;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.rse.core.model.IProperty#getType()
	 */
	public IPropertyType getType() {
		return _type;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.rse.core.model.IProperty#setEnabled(boolean)
	 */
	public void setEnabled(boolean flag) {
		_isEnabled = flag;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.rse.core.model.IProperty#isEnabled()
	 */
	public boolean isEnabled() {
		return _isEnabled;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.rse.core.model.IProperty#setReadOnly(boolean)
	 */
	public void setReadOnly(boolean flag) {
		_isReadOnly = flag;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.rse.core.model.IProperty#isReadOnly()
	 */
	public boolean isReadOnly() {
		return _isReadOnly;
	}

}