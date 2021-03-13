package com.uniyaz.ui.component;

import com.uniyaz.ui.SyUI;
import com.uniyaz.ui.page.UrunListePage;
import com.vaadin.server.FontAwesome;
import com.vaadin.ui.*;

public class SearchComponent extends HorizontalLayout {

    private HorizontalLayout mainLayout;
    private TextField searchField;
    private Button searchButton;

    private ContentComponent contentComponent;

    public SearchComponent() {
        setSizeFull();

        SyUI syUI = (SyUI) UI.getCurrent();
        contentComponent = syUI.getContentComponent();

        buildMainLayout();
        addComponent(mainLayout);

        setComponentAlignment(mainLayout, Alignment.MIDDLE_CENTER);
    }

    private void buildMainLayout() {

        mainLayout = new HorizontalLayout();

        searchField = new TextField();
        searchField.setInputPrompt("Ürün Adı ve Kodunu giriniz");
        mainLayout.addComponent(searchField);

        searchButton = new Button();
        searchButton.setIcon(FontAwesome.SEARCH);
        searchButton.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {
              String aranacakDeger=  searchField.getValue();
              UrunListePage urunListePage = new UrunListePage(aranacakDeger);
              contentComponent.addComponent(urunListePage);
            }
        });
        mainLayout.addComponent(searchButton);
    }



}