package com.opcoach.training.rental.ui;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.resource.FontRegistry;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.viewers.IColorProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.framework.FrameworkUtil;


/**
 * The activator class controls the plug-in life cycle
 */
public class RentalUIActivator extends AbstractUIPlugin implements  RentalUIConstants
{

	
	// The plug-in ID
	public static final String PLUGIN_ID = "com.opcoach.training.rental.ui";

	// The shared instance
	private static RentalUIActivator plugin;

	/** The map of possible color providers (read in extensions) */
	private Map<String, Palette> paletteManager = new HashMap<String, Palette>();

	/**
	 * The constructor
	 */
	public RentalUIActivator()
	{
		System.out.println("Start Rental UI Activator");  // test
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext context) throws Exception
	{
		super.start(context); 
		plugin = this;
		System.out.println("Start rental ui bundle");
		readViewExtensions();
		readColorProviderExtensions();
		// initializeFontRegistry();
				
	}


	private void initializeFontRegistry()
	{
		FontData[] fdc = new FontData[] { new FontData("times",12,SWT.NORMAL), new FontData("times",12,SWT.ITALIC), new FontData("times",14,SWT.BOLD)};
		FontData[] fdr = new FontData[] { new FontData("courier",12,SWT.NORMAL), new FontData("courier",12,SWT.ITALIC), new FontData("courier",14,SWT.BOLD)};
		FontRegistry fr = JFaceResources.getFontRegistry();
		fr.put(CUSTOMER_KEY, fdc);
		fr.put(RENTAL_OBJECT_KEY, fdr);
		
		
	}

	public void readColorProviderExtensions()
	{
		IExtensionRegistry reg = Platform.getExtensionRegistry();
		IExtensionPoint extp = reg.getExtensionPoint("com.opcoach.training.rental.ui.Palette");
		IExtension[] extensions = extp.getExtensions();

		for (IExtension ext : extensions)
		{
			IConfigurationElement[] config = ext.getConfigurationElements();
			for (IConfigurationElement elt : config)
			{
				// Create the palette for current extension.
				try
				{
					// Create the executable extension
					IColorProvider delegatedICP = (IColorProvider) elt.createExecutableExtension("paletteClass");
					
					// Add it (with its name) in the color provider map
					Palette p = new Palette(elt.getAttribute("id"));
					p.setName(elt.getAttribute("name"));
					p.setColorProvider(delegatedICP);
					paletteManager.put(p.getId(), p);
					
					// paletteManager.put(elt.getAttribute("name"), delegatedICP);
				} catch (CoreException e)
				{
					IStatus st = new Status(IStatus.ERROR, PLUGIN_ID, "Impossible de creer la classe de palette : "+
				                  elt.getAttribute("paletteClass"),e);
					getLog().log(st);
					
				}
			}
		}

	}

	
	public void readViewExtensions()
	{
		IExtensionRegistry reg = Platform.getExtensionRegistry();
	
			for (IConfigurationElement elt : reg.getConfigurationElementsFor("org.eclipse.ui.views"))
			{
				if (elt.getName().equals("view"))
					System.out.println("Plugin : " + elt.getNamespaceIdentifier() + "\t\t\tVue : " + elt.getAttribute("name"));
			}

	}

	/* @return a never null collection of overriden color providers */

	public Map<String, Palette> getPaletteManager()
	{
		return paletteManager;
	}


	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext context) throws Exception
	{
		plugin = null;
		super.stop(context);
	}

	/**
	 * Returns the shared instance
	 * 
	 * @return the shared instance
	 */
	public static RentalUIActivator getDefault()
	{
		return plugin;
	}

	/**
	 * Returns an image descriptor for the image file at the given plug-in relative path
	 * 
	 * @param path the path
	 * @return the image descriptor
	 */
	public static ImageDescriptor getImageDescriptor(String path)
	{
		return imageDescriptorFromPlugin(PLUGIN_ID, path);
	}




	@Override
	protected void initializeImageRegistry(ImageRegistry reg)
	{
		Bundle b = FrameworkUtil.getBundle(getClass());

		reg.put(CUSTOMER_KEY, ImageDescriptor.createFromURL(b.getEntry("icons/Customers.png")));
		reg.put(RENTAL_KEY, ImageDescriptor.createFromURL(b.getEntry("icons/Rentals.png")));
		reg.put(RENTAL_OBJECT_KEY, ImageDescriptor.createFromURL(b.getEntry("icons/RentalObjects.png")));
		reg.put(AGENCY_KEY, ImageDescriptor.createFromURL(b.getEntry("icons/Agency.png")));
	}
	
	public Image getMyImage(String path)
	{
		// Utilise le Registry global de JfaceResources
		ImageRegistry reg = JFaceResources.getImageRegistry();
		// Essai de r�cuperer l'image peut �tre d�j� pr�sente
		Image img = reg.get(path);
		if (img == null)
		{
			// L'image n'est pas encore stock�e dans le registry, on l'ajoute
			ImageDescriptor desc = ImageDescriptor.createFromFile(this.getClass(), path);
			// Le path sert de cl�
			reg.put(path, desc);
			img = reg.get(path);
		}
		
		return img;
			
	}
	
	
}
