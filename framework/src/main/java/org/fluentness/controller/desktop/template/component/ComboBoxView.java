package org.fluentness.controller.desktop.template.component;

import javax.swing.*;
import javax.swing.event.PopupMenuListener;
import javax.swing.plaf.ComboBoxUI;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;

public class ComboBoxView<E> extends AbstractComponentView<ComboBoxView, JComboBox> {

    public ComboBoxView(E... items) {
        super(new JComboBox());
        for (E item : items) {
            view.addItem(item);
        }
    }

    public ComboBoxView<E> actionListener(ActionListener l){
        view.addActionListener(l);
        return this;
    }

    public ComboBoxView<E> editable(boolean aFlag) {
        view.setEditable(aFlag);
        return this;
    }

    public ComboBoxView<E> editor(ComboBoxEditor anEditor) {
        view.setEditor(anEditor);
        return this;
    }

    public ComboBoxView<E> itemListener(ItemListener aListener){
        view.addItemListener(aListener);
        return this;
    }

    public ComboBoxView<E> keySelectionManager(JComboBox.KeySelectionManager aManager) {
        view.setKeySelectionManager(aManager);
        return this;
    }

    public ComboBoxView<E> lightWeightPopupEnabled(boolean aFlag) {
        view.setLightWeightPopupEnabled(aFlag);
        return this;
    }

    public ComboBoxView<E> maximumRowCount(int count) {
        view.setMaximumRowCount(count);
        return this;
    }

    public ComboBoxView<E> popupMenuListener(PopupMenuListener l){
        view.addPopupMenuListener(l);
        return this;
    }

    public ComboBoxView<E> popupVisible(boolean v) {
        view.setPopupVisible(v);
        return this;
    }

    public ComboBoxView<E> prototypeDisplayValue(E prototypeDisplayValue) {
        view.setPrototypeDisplayValue(prototypeDisplayValue);
        return this;
    }

    public ComboBoxView<E> renderer(ListCellRenderer<? super E> aRenderer) {
        view.setRenderer(aRenderer);
        return this;
    }

    public ComboBoxView<E> selectedIndex(int anIndex) {
        view.setSelectedIndex(anIndex);
        return this;
    }

    public ComboBoxView<E> selectedItem(Object anObject) {
        view.setSelectedItem(anObject);
        return this;
    }

    public ComboBoxView<E> uI(ComboBoxUI ui) {
        view.setUI(ui);
        return this;
    }
}
