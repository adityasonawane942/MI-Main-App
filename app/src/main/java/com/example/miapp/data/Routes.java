package com.example.miapp.data;

import com.example.miapp.ServerConnection.GsonModels;
import com.google.android.gms.maps.model.LatLng;

import java.time.Duration;
import java.util.List;

/**
 * Created by Mai Thanh Hiep on 4/3/2016.
 */
public class Routes {
    public Distance distance;
    public Duration duration;
    public String endAddress;
    public LatLng endLocation;
    public String startAddress;
    public LatLng startLocation;

    public List<LatLng> points;
}
