package com.opcoach.training.rental.ui.views;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.util.IPropertyChangeListener;
import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.DragSource;
import org.eclipse.swt.dnd.RTFTransfer;
import org.eclipse.swt.dnd.TextTransfer;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.dnd.URLTransfer;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.IViewSite;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.ViewPart;

import com.opcoach.training.rental.RentalAgency;
import com.opcoach.training.rental.core.RentalCoreActivator;
import com.opcoach.training.rental.helpers.RentalAgencyGenerator;
import com.opcoach.training.rental.ui.RentalUIActivator;

public class RentalAgencyView extends ViewPart implements IPropertyChangeListener, ISelectionListener
{
	public static final String VIEW_ID = "com.opcoach.rental.ui.rentalagencyview";

	private TreeViewer agencyViewer;

	private AgencyLabelProvider labelProvider;

	public RentalAgencyView()
	{
		// TODO Auto-generated constructor stub
	}

	@Override
	public void createPartControl(Composite parent)
	{		
		agencyViewer = new TreeViewer(parent);
		agencyViewer.setContentProvider(new AgencyContentProvider());
		labelProvider = new AgencyLabelProvider();
		agencyViewer.setLabelProvider(labelProvider);
		
		
		Collection<RentalAgency> agencies = new ArrayList<RentalAgency>();
		agencies.add(RentalCoreActivator.getAgency());
		
		RentalAgency lyon = RentalAgencyGenerator.createSampleAgency();
		lyon.setName("Lyon");
		agencies.add(lyon);

		agencyViewer.setInput(agencies);
		
		
		
		// Association de la vue sur un contexte d'aide
		PlatformUI.getWorkbench().getHelpSystem().setHelp(agencyViewer.getControl(), "com.opcoach.training.rental.ui.rentalContext");


		// Autorise le popup sur le treeviewer
		MenuManager menuManager = new MenuManager();
		Menu menu = menuManager.createContextMenu(agencyViewer.getControl());
		agencyViewer.getControl().setMenu(menu);
		getSite().registerContextMenu(menuManager, agencyViewer);

		// L'arbre est draggable
		DragSource ds = new DragSource(agencyViewer.getControl(), DND.DROP_COPY);
		Transfer[] ts = new Transfer[] { TextTransfer.getInstance(), RTFTransfer.getInstance(), URLTransfer.getInstance() };
		ds.setTransfer(ts);
		ds.addDragListener(new AgencyTreeDragSourceListener(agencyViewer));

		getSite().setSelectionProvider(agencyViewer);

		
	
	}
	
	@Override
	public void init(IViewSite site) throws PartInitException
	{
		super.init(site);
		// On s'enregistre en tant que pref listener sur le preference store...
		RentalUIActivator.getDefault().getPreferenceStore().addPropertyChangeListener(this);
		
		// This treeview is now selection listener to be synchronized with the dashboard.
		getSite().getPage().addSelectionListener(this);
				
	}
	
	@Override
	public void dispose()
	{
		RentalUIActivator.getDefault().getPreferenceStore().removePropertyChangeListener(this);
		
		// This treeview must remove the selection listener 
		getSite().getPage().removeSelectionListener(this);
		
		
		super.dispose();
	}

	@Override
	public void propertyChange(PropertyChangeEvent event)
	{	
		labelProvider.initPalette();
		agencyViewer.refresh();
	}

	@Override
	public void setFocus()
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void selectionChanged(IWorkbenchPart part, ISelection selection)
	{
		// Must check if this selection is coming from this part or from another one.
		if (part != this)
		   agencyViewer.setSelection(selection, true);
		
	}

}
