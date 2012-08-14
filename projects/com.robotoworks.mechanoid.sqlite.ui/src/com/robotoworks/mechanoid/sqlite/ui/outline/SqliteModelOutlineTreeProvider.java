/*
* generated by Xtext
*/
package com.robotoworks.mechanoid.sqlite.ui.outline;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.xtext.ui.editor.outline.IOutlineNode;
import org.eclipse.xtext.ui.editor.outline.impl.DefaultOutlineTreeProvider;
import org.eclipse.xtext.ui.label.StylerFactory;

import com.google.inject.Inject;
import com.robotoworks.mechanoid.sqlite.sqliteModel.MigrationBlock;

/**
 * customization of the default outline structure
 * 
 */
public class SqliteModelOutlineTreeProvider extends DefaultOutlineTreeProvider {
		@Inject
		private StylerFactory stylerFactory;
	
		@Override
		protected void createNode(IOutlineNode parent, EObject modelElement) {
			super.createNode(parent, modelElement);
		}
		
		@Override
		protected Object _text(Object modelElement) {
			if(modelElement instanceof MigrationBlock) {
				return new StyledString("Migration");
			} else {
				return super._text(modelElement);
			}
		}
}
