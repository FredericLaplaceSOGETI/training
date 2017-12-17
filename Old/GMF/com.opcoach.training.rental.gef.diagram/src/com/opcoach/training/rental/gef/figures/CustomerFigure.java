// ------------------------------------------------
// OPCoach Training Projects
// � OPCoach 2009 http://www.opcoach.com
// ------------------------------------------------

package com.opcoach.training.rental.gef.figures;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Ellipse;
import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.XYLayout;
import org.eclipse.draw2d.geometry.Rectangle;

/**
 * @author olivier
 */
public class CustomerFigure extends Figure
{
	// Width and height for figures
	public static final int W_INIT = 90, H_INIT=75;
	private static final int W_HEAD = 20, H_HEAD = 20, W_BODY = 25, H_BODY = 30, H_NAME = 18;
	private Label name;
	private Ellipse head, body;

	public CustomerFigure(String n)
	{
		super();
		setLayoutManager(new XYLayout());

		head = new Ellipse();
		head.setBackgroundColor(ColorConstants.blue);
		add(head);

		body = new Ellipse();
		body.setBackgroundColor(ColorConstants.darkBlue);
		add(body);

		name = new Label(n);
		name.setForegroundColor(ColorConstants.blue);
		add(name);

		setBounds(new Rectangle(0, 0, W_INIT, H_INIT));

	}

	protected void paintBorder(Graphics graphics)
	{
		graphics.pushState();
		graphics.setForegroundColor(ColorConstants.black);
		Rectangle r = getBounds();
		graphics.drawRectangle(r.x, r.y, r.width - 1, r.height - 1);
		graphics.popState();
	}

	@Override
	protected boolean useLocalCoordinates() { return true; 	}

	/*
	 * (non-Javadoc)
	 * @see
	 * org.eclipse.draw2d.Figure#setBounds(org.eclipse.draw2d.geometry.Rectangle
	 * )
	 */
	@Override
	public void setBounds(Rectangle rect)
	{
		// Check minimal bounds
		if ((rect.width < W_INIT) || (rect.height < H_INIT))
			rect = new Rectangle(rect.x, rect.y, W_INIT, H_INIT);
		super.setBounds(rect);

		if (head != null)
		{
			int w = rect.width, h = rect.height;
			head.setBounds(new Rectangle((w - W_HEAD) / 2, 4, W_HEAD, H_HEAD));
			body.setBounds(new Rectangle((w - W_BODY) / 2, 4 + H_HEAD, W_BODY, H_BODY));
			name.setBounds(new Rectangle(1, h - H_NAME, w - 2, H_NAME));
		}

	}


	public void setName(String n)
	{
		name.setText(n);
	}
}
