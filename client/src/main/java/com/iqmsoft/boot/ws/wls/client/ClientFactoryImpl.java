package com.iqmsoft.boot.ws.wls.client;

import com.google.gwt.place.shared.PlaceController;
import com.google.web.bindery.event.shared.EventBus;
import com.google.web.bindery.event.shared.SimpleEventBus;
import com.iqmsoft.boot.ws.wls.ui.MainPage;

public class ClientFactoryImpl implements ClientFactory {
	
	
	EventBus eventBus = new SimpleEventBus();
	PlaceController controller = new PlaceController(eventBus);
	MainPage mainPage = new MainPage();

	
	@Override
	public MainPage getMainPageView() {
		return mainPage;
	}

	@Override
	public EventBus getEventBus() {
		return eventBus;
	}

	@Override
	public PlaceController getPlaceController() {
		return controller;
	}

}
