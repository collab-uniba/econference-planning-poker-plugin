/**
 * This file is part of the eConference project and it is distributed under the 

 * terms of the MIT Open Source license.
 * 
 * The MIT License
 * Copyright (c) 2005 Collaborative Development Group - Dipartimento di Informatica, 
 *                    University of Bari, http://cdg.di.uniba.it
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this 
 * software and associated documentation files (the "Software"), to deal in the Software 
 * without restriction, including without limitation the rights to use, copy, modify, 
 * merge, publish, distribute, sublicense, and/or sell copies of the Software, and to 
 * permit persons to whom the Software is furnished to do so, subject to the following 
 * conditions:
 * 
 * The above copyright notice and this permission notice shall be included in all copies 
 * or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, 
 * INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A 
 * PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT 
 * HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF 
 * CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE 
 * OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package it.uniba.di.cdg.econference.planningpoker.utils;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.viewers.ColumnLayoutData;
import org.eclipse.jface.viewers.ColumnPixelData;
import org.eclipse.jface.viewers.ColumnWeightData;
import org.eclipse.jface.viewers.TableLayout;
import org.eclipse.swt.events.ControlEvent;
import org.eclipse.swt.events.ControlListener;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;

public class AutoResizeTableLayout extends TableLayout implements
        ControlListener {
    
    private final Table table;
    private List<ColumnLayoutData> columns = new ArrayList<ColumnLayoutData>();
    private boolean autosizing = false;
    
    public AutoResizeTableLayout(Table table) {
        this.table = table;
        table.addControlListener(this);
    }
    
    public void addColumnData(ColumnLayoutData data) {
        columns.add(data);
        super.addColumnData(data);
    }

    public void controlMoved(ControlEvent e) {
    }

    public void controlResized(ControlEvent e) {
        if (autosizing) {
            return;
        }
        autosizing = true;
        try {
            autoSizeColumns();
        } finally {
            autosizing = false;
        }
    }
    

    private void autoSizeColumns() {
        int width = table.getClientArea().width;     
        if (width <= 1) {
            return;
        }
        
        TableColumn[] tableColumns = table.getColumns();
        int size = 
            Math.min(columns.size(), tableColumns.length);
        int[] widths = new int[size];
        int fixedWidth = 0;
        int numberOfWeightColumns = 0;
        int totalWeight = 0;
        
        // First calc space occupied by fixed columns.
        for (int i = 0; i < size; i++) {
            ColumnLayoutData col = (ColumnLayoutData)columns.get(i);
            if (col instanceof ColumnPixelData) {
                int pixels = ((ColumnPixelData)col).width;
                widths[i] = pixels;
                fixedWidth += pixels;
            } else if (col instanceof ColumnWeightData) {
                ColumnWeightData cw = (ColumnWeightData)col;
                numberOfWeightColumns++;
                int weight = cw.weight;
                totalWeight += weight;
            } else {
                throw new IllegalStateException("Unknown column layout data");
            }
        }
        
        // Do we have columns that have a weight?
        if (numberOfWeightColumns > 0) {
            // Now, distribute the rest
            // to the columns with weight.
            int rest = width - fixedWidth;
            int totalDistributed = 0;
            for (int i = 0; i < size; i++) {
                ColumnLayoutData col = (ColumnLayoutData)columns.get(i);
                if (col instanceof ColumnWeightData) {
                    ColumnWeightData cw = (ColumnWeightData)col;
                    int weight = cw.weight;
                    int pixels = totalWeight == 0 ? 0 : weight * rest / totalWeight;
                    totalDistributed += pixels;
                    widths[i] = pixels;
                }
            }
            
            // Distribute any remaining pixels
            // to columns with weight.
            int diff = rest - totalDistributed;
            for (int i = 0; diff > 0; i++) {
                if (i == size) {
                    i = 0;
                }
                ColumnLayoutData col = (ColumnLayoutData)columns.get(i);
                if (col instanceof ColumnWeightData) {
                    ++widths[i];
                    --diff;
                }
            }
        }
        
        for (int i = 0; i < size; i++) {
            if (tableColumns[i].getWidth() != widths[i]) {
                tableColumns[i].setWidth(widths[i]);
            }
            
        }
        
    }

}
