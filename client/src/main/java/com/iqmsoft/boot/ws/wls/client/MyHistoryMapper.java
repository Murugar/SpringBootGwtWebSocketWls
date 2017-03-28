package com.iqmsoft.boot.ws.wls.client;



import com.google.gwt.place.shared.PlaceHistoryMapper;
import com.google.gwt.place.shared.WithTokenizers;
import com.iqmsoft.boot.ws.wls.places.*;


@WithTokenizers({HomePlace.Tokenizer.class, SendPlace.Tokenizer.class})
public interface MyHistoryMapper extends PlaceHistoryMapper  {

}

