/*
 * (c) Copyright QNX Software Systems Ltd. 2002. All Rights Reserved.
 *  
 */
package org.eclipse.cdt.debug.internal.ui.actions;

import org.eclipse.cdt.debug.core.model.ICDebugTarget;
import org.eclipse.cdt.debug.internal.ui.ICDebugHelpContextIds;
import org.eclipse.cdt.debug.ui.CDebugUIPlugin;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.debug.core.DebugException;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.ui.help.WorkbenchHelp;
import org.eclipse.ui.texteditor.IUpdate;

/**
 * Enter type comment.
 * 
 * @since: Feb 11, 2003
 */
public class LoadSymbolsForAllAction extends Action implements IUpdate {

	private Viewer fViewer = null;

	/**
	 * Constructor for LoadSymbolsForAllAction.
	 */
	public LoadSymbolsForAllAction( Viewer viewer ) {
		super( ActionMessages.getString( "LoadSymbolsForAllAction.Load_Symbols_For_All_1" ) ); //$NON-NLS-1$
		fViewer = viewer;
//		CDebugImages.setLocalImageDescriptors( this, ICDebugUIConstants.IMG_LCL_LOAD_ALL_SYMBOLS );
		setDescription( ActionMessages.getString( "LoadSymbolsForAllAction.Load_symbols_for_all_shared_libraries_1" ) ); //$NON-NLS-1$
		setToolTipText( ActionMessages.getString( "LoadSymbolsForAllAction.Load_Symbols_For_All_2" ) ); //$NON-NLS-1$
		WorkbenchHelp.setHelp( this, ICDebugHelpContextIds.LOAD_SYMBOLS_FOR_ALL );
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.texteditor.IUpdate#update()
	 */
	public void update() {
		if ( fViewer != null && fViewer.getInput() instanceof IAdaptable ) {
			ICDebugTarget target = (ICDebugTarget)((IAdaptable)fViewer.getInput()).getAdapter(ICDebugTarget.class);
			if ( target != null ) {
				setEnabled( target.isSuspended() );
				return;
			}
		}
		setEnabled( false );
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.action.IAction#run()
	 */
	public void run() {
		if ( fViewer != null && fViewer.getInput() instanceof IAdaptable ) {
			ICDebugTarget target = (ICDebugTarget)((IAdaptable)fViewer.getInput()).getAdapter(ICDebugTarget.class);
			if ( target != null ) {
				try {
					target.loadSymbols();
				}
				catch( DebugException e ) {
					CDebugUIPlugin.errorDialog( ActionMessages.getString( "LoadSymbolsForAllAction.Unable_to_load_symbols_1" ), e.getStatus() ); //$NON-NLS-1$
				}
			}
		}
	}
}
