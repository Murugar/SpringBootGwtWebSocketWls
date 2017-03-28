package com.iqmsoft.boot.ws.wls.client;

import com.google.gwt.place.shared.PlaceController;
import com.google.web.bindery.event.shared.EventBus;
import com.iqmsoft.boot.ws.wls.ui.MainPage;


public interface ClientFactory {
     MainPage getMainPageView();
     EventBus getEventBus();
     PlaceController getPlaceController();
}
