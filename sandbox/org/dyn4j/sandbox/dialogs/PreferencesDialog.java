package org.dyn4j.sandbox.dialogs;

import java.awt.Container;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JTabbedPane;

import org.dyn4j.sandbox.panels.PreferencesPanel;
import org.dyn4j.sandbox.utilities.Icons;

/**
 * Dialog used to configure the application preferences.
 * @author William Bittle
 * @version 1.0.0
 * @since 1.0.0
 */
public class PreferencesDialog extends JDialog implements ActionListener {
	/** The version id */
	private static final long serialVersionUID = -1615642743117999224L;

	/** The dialog canceled flag */
	private boolean canceled = true;
	
	/** The preferences panel */
	private PreferencesPanel pnlPreferences;
	
	/**
	 * Full constructor.
	 * @param owner the dialog owner
	 */
	private PreferencesDialog(Window owner) {
		super(owner, "Preferences", ModalityType.APPLICATION_MODAL);
		
		this.setIconImage(Icons.PREFERENCES.getImage());
		
		this.pnlPreferences = new PreferencesPanel();
		
		JTabbedPane tabbedPane = new JTabbedPane();
		tabbedPane.addTab("Preferences", this.pnlPreferences);
		
		JButton btnCancel = new JButton("Cancel");
		JButton btnApply = new JButton("Apply");
		btnCancel.setActionCommand("cancel");
		btnApply.setActionCommand("apply");
		btnCancel.addActionListener(this);
		btnApply.addActionListener(this);
		
		Container container = this.getContentPane();
		
		GroupLayout layout = new GroupLayout(container);
		container.setLayout(layout);
		
		layout.setAutoCreateContainerGaps(true);
		layout.setAutoCreateGaps(true);
		layout.setHorizontalGroup(
				layout.createSequentialGroup()
				.addGroup(layout.createParallelGroup()
						.addComponent(tabbedPane)
						.addGroup(layout.createSequentialGroup()
								.addComponent(btnCancel)
								.addComponent(btnApply))));
		layout.setVerticalGroup(
				layout.createSequentialGroup()
				.addComponent(tabbedPane)
				.addGroup(layout.createParallelGroup()
						.addComponent(btnCancel)
						.addComponent(btnApply)));
		
		this.pack();
	}

	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent event) {
		// check the action command
		if ("cancel".equals(event.getActionCommand())) {
			// if its canceled then set the canceled flag and
			// close the dialog
			this.canceled = true;
			this.setVisible(false);
		} else {
			this.canceled = false;
			this.setVisible(false);
		}
	}
	
	/**
	 * Shows an edit preferences dialog and sets the properties if the user clicks apply.
	 * @param owner the dialog owner
	 */
	public static final void show(Window owner) {
		PreferencesDialog dialog = new PreferencesDialog(owner);
		dialog.setLocationRelativeTo(owner);
		dialog.setVisible(true);
		
		if (!dialog.canceled) {
			// set the settings
			dialog.pnlPreferences.setPreferences();
		}
	}
}