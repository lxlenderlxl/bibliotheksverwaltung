/*
 *                 (C) Copyright 2005 Nilo J. Gonzalez
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser Gereral Public Licence as published by the Free
 * Software Foundation; either version 2 of the Licence, or (at your opinion) any
 * later version.
 * 
 * This library is distributed in the hope that it will be usefull, but WITHOUT ANY
 * WARRANTY; without even the implied warranty of merchantability or fitness for a
 * particular purpose. See the GNU Lesser General Public Licence for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public Licence along
 * with this library; if not, write to the Free Software Foundation, Inc., 59
 * Temple Place, Suite 330, Boston, Ma 02111-1307 USA.
 *
 * http://www.gnu.org/licenses/lgpl.html (English)
 * http://gugs.sindominio.net/gnu-gpl/lgpl-es.html (Espa�ol)
 *
 *
 * Original author: Nilo J. Gonzalez
 */

/**
 * Esta clase implementa los botones.
 * @author Nilo J. Gonzalez
 */
 
package com.nilo.plaf.nimrod;

import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.geom.RoundRectangle2D;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.AbstractButton;
import javax.swing.ButtonModel;
import javax.swing.JComponent;
import javax.swing.JToolBar;
import javax.swing.event.MouseInputAdapter;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.metal.MetalBorders;
import javax.swing.plaf.metal.MetalButtonUI;

public class NimRODButtonUI extends MetalButtonUI {
  protected MiListener miml;
  //static private NimRODButtonUI ui;
  
  protected boolean oldOpaque;

	public static ComponentUI createUI( JComponent c) {
    return new NimRODButtonUI();
    /*if ( ui == null ) {
      ui = new NimRODButtonUI();
    }
    
    return ui;
    */
  }
	
  public void installDefaults( AbstractButton button) {
    super.installDefaults( button);

    button.setBorder( NimRODBorders.getButtonBorder());
    
    selectColor = NimRODLookAndFeel.getFocusColor();
  }
  
  public void unsinstallDefaults( AbstractButton button) {
    super.uninstallDefaults( button);
    
    button.setBorder( MetalBorders.getButtonBorder());
  }
  
  public void installListeners( AbstractButton b) {
    super.installListeners( b);
    
    miml = new MiListener( b);
    b.addMouseListener( miml);
    b.addPropertyChangeListener( miml);
    b.addFocusListener( miml);
  }
  
  protected void uninstallListeners( AbstractButton b) {
    b.removeMouseListener( miml);
    b.removePropertyChangeListener( miml);
    b.removeFocusListener( miml);
  }
  
  protected void paintButtonPressed( Graphics g, AbstractButton b) {
    if ( !oldOpaque ) {
      return;
    }
    
  	if ( b.isContentAreaFilled() ) {
      Graphics2D g2D = (Graphics2D)g;
      g2D.setRenderingHint( RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
      g2D.setColor( NimRODUtils.getColorAlfa( selectColor, 100));
      RoundRectangle2D.Float boton = hazBoton( b);
      g2D.fill( boton);
      g2D.setRenderingHint( RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_DEFAULT);
	  }
	}

	protected void paintFocus( Graphics g, AbstractButton b,
														 Rectangle viewRect, Rectangle textRect, Rectangle iconRect) {
    if ( !b.isFocusPainted() || !oldOpaque ) {
      return;
    }
    if ( b.getParent() instanceof JToolBar ) {
      return;  // No se pinta el foco cuando estamos en una barra
    }
    
    NimRODUtils.paintFocus( g, 3,3, b.getWidth()-6, b.getHeight()-6, 2, 2, NimRODLookAndFeel.getFocusColor());
  }
  
  public void update( Graphics g, JComponent c) {
    oldOpaque = c.isOpaque();
    
    if ( c.getParent() instanceof JToolBar ) {
      super.update( g,c);
    }
    else {
      c.setOpaque( false);
      super.update( g,c);
      c.setOpaque( oldOpaque);
    }
  }
  
  public void paint( Graphics g, JComponent c) {  
    ButtonModel mod = ((AbstractButton)c).getModel();
    
    if ( oldOpaque ) {
      Graphics2D g2D = (Graphics2D)g;
      g2D.setRenderingHint( RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
      
      RoundRectangle2D.Float boton = hazBoton( c);
      
      // This line is a fix from Ross Judson
      g2D.clip( boton);
      
      g2D.setColor( NimRODLookAndFeel.getControl());
      g2D.fill( boton);
      
      if ( c.getParent() instanceof JToolBar ) {
        if ( mod.isRollover() || mod.isPressed() || mod.isSelected()) {
          c.setBorder( NimRODBorders.getGenBorder());
        }
        else {
          c.setBorder( NimRODBorders.getEmptyGenBorder());
        }
        
        if ( mod.isPressed() || mod.isSelected() ) {
          g2D.setColor( NimRODLookAndFeel.getFocusColor());
          g2D.fill( boton);
        }
      }
      else {
        GradientPaint grad = null;
        
        if ( mod.isPressed() || mod.isSelected() ) {
        	grad = new GradientPaint( 0,0, NimRODUtils.getSombra(), 
                                    0,c.getHeight(), NimRODUtils.getBrillo());
    		}
    		else {
        	grad = new GradientPaint( 0,0, NimRODUtils.getBrillo(), 
                                    0,c.getHeight(), NimRODUtils.getSombra());
    		}
    		
    		g2D.setPaint( grad);
        g2D.fill( boton);
        
        if ( mod.isRollover() ) {
          g2D.setColor( NimRODUtils.getRolloverColor());
          g2D.fill( boton);
        }
      }
      
      g2D.setRenderingHint( RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_DEFAULT);
    }

    super.paint( g, c);
  }
  
  private RoundRectangle2D.Float hazBoton( JComponent c) {
    RoundRectangle2D.Float boton = new RoundRectangle2D.Float(); 
    boton.x = 0;
    boton.y = 0;
    boton.width = c.getWidth();
    boton.height = c.getHeight();
    boton.arcwidth = 8;
    boton.archeight = 8;
    
    return boton;
  }
  
  /////////////////////////////////////
  
  public class MiListener extends MouseInputAdapter implements PropertyChangeListener, FocusListener {
    private AbstractButton papi;
    
    MiListener( AbstractButton b) {
      papi = b;
    }
    
    public void refresh() {
      if ( papi != null && papi.getParent() != null ) {
        papi.getParent().repaint( papi.getX()-5, papi.getY()-5, 
                                  papi.getWidth()+10, papi.getHeight()+10);
      }
    }
    
    public void mouseEntered( MouseEvent e) {
      papi.getModel().setRollover( true);
      refresh();
    }

    public void mouseExited( MouseEvent e) {
      papi.getModel().setRollover( false);
      refresh();
    }
    
    public void mousePressed(MouseEvent e) {
      papi.getModel().setRollover( false);
      refresh();
    }

    public void mouseReleased(MouseEvent e) {
      papi.getModel().setRollover( false);
      refresh();
    }

    public void propertyChange( PropertyChangeEvent evt) {
      if ( evt.getPropertyName().equals( "enabled") ) {
        refresh();
      }
    }

    public void focusGained( FocusEvent e) {
      refresh();
    }

    public void focusLost( FocusEvent e) {
      refresh();
    }
  }
}
