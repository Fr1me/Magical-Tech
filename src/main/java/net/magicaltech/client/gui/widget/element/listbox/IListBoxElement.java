package net.magicaltech.client.gui.widget.element.listbox;

import net.magicaltech.client.gui.widget.element.ElementListBox;

public interface IListBoxElement {

	int getHeight();

	int getWidth();

	Object getValue();

	void draw(ElementListBox listBox, int x, int y, int backColor, int textColor);

}
