package org.fluentness.controller.desktop.swing.component;

import javax.swing.*;
import javax.swing.event.PopupMenuListener;
import javax.swing.plaf.ComboBoxUI;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;

public class ComboBoxView<E> extends AbstractComponentView<ComboBoxView, JComboBox> {

    private JComboBox<E> jComboBox = new JComboBox<>();

    public ComboBoxView(E... items) {
        for (E item : items) {
            jComboBox.addItem(item);
        }
    }

    @Override
    public JComboBox getSwingView() {
        return jComboBox;
    }

    public ComboBoxView<E> actionListener(ActionListener l){
        jComboBox.addActionListener(l);
        return this;
    }

    public ComboBoxView<E> editable(boolean aFlag) {
        jComboBox.setEditable(aFlag);
        return this;
    }

    public ComboBoxView<E> editor(ComboBoxEditor anEditor) {
        jComboBox.setEditor(anEditor);
        return this;
    }

    public ComboBoxView<E> itemListener(ItemListener aListener){
        jComboBox.addItemListener(aListener);
        return this;
    }

    public ComboBoxView<E> keySelectionManager(JComboBox.KeySelectionManager aManager) {
        jComboBox.setKeySelectionManager(aManager);
        return this;
    }

    public ComboBoxView<E> lightWeightPopupEnabled(boolean aFlag) {
        jComboBox.setLightWeightPopupEnabled(aFlag);
        return this;
    }

    public ComboBoxView<E> maximumRowCount(int count) {
        jComboBox.setMaximumRowCount(count);
        return this;
    }

    public ComboBoxView<E> model(ComboBoxModel<E> aModel) {
        jComboBox.setModel(aModel);
        return this;
    }

    public ComboBoxView<E> popupMenuListener(PopupMenuListener l){
        jComboBox.addPopupMenuListener(l);
        return this;
    }

    public ComboBoxView<E> popupVisible(boolean v) {
        jComboBox.setPopupVisible(v);
        return this;
    }

    public ComboBoxView<E> prototypeDisplayValue(E prototypeDisplayValue) {
        jComboBox.setPrototypeDisplayValue(prototypeDisplayValue);
        return this;
    }

    public ComboBoxView<E> renderer(ListCellRenderer<? super E> aRenderer) {
        jComboBox.setRenderer(aRenderer);
        return this;
    }

    public ComboBoxView<E> selectedIndex(int anIndex) {
        jComboBox.setSelectedIndex(anIndex);
        return this;
    }

    public ComboBoxView<E> selectedItem(Object anObject) {
        jComboBox.setSelectedItem(anObject);
        return this;
    }

    public ComboBoxView<E> uI(ComboBoxUI ui) {
        jComboBox.setUI(ui);
        return this;
    }
}
