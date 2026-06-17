package com.example.myapplication;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import org.osmdroid.config.Configuration;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.MapView;
import org.osmdroid.views.overlay.Marker;

public class MainActivity extends AppCompatActivity {

    private LocationManager locationManager;
    private TextView tv;
    private Button buttonLoc;
    private MapView mapView;
    private Marker marcadorPosicaoAtual;
    private static final int PERMISSION_REQUEST_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = findViewById(R.id.textview);
        buttonLoc = findViewById(R.id.buttonLoc);
        mapView = findViewById(R.id.mapView);

        Configuration.getInstance().setUserAgentValue(getPackageName());

        mapinit();
        locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);

        // Configura o clique do botão
        buttonLoc.setOnClickListener(v -> {
            if (hasLocationPermission()) {
                getLocation();
            } else {
                checkLocationPermission();
            }
        });
    }

    // Método auxiliar para checar se a permissão já existe
    private boolean hasLocationPermission() {
        return ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED;
    }

    private void getLocation() {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return;
        }

        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, location -> {
            tv.setText("Latitude: " + location.getLatitude() +
                        "\nLongitude: " + location.getLongitude() +
                        "\nAltitude: " + location.getLongitude() +
                        "\nVelocidade: " + location.getSpeed());
                showLocationOnMap(location);
        });

    }

    public void mapinit(){
        mapView.setMultiTouchControls(true);
    }

    public void showLocationOnMap(Location location){
        double latidude = location.getLatitude();
        double longitude = location.getLongitude();
        GeoPoint mLocation = new GeoPoint(latidude, longitude);
        mapView.getController().setCenter(mLocation);
        mapView.getController().setCenter(mLocation);
        mapView.getController().setZoom(18.0);
        mapView.getController().animateTo(mLocation);
        //adiciona um overlay para mostrar localização atual (marker)
        if(marcadorPosicaoAtual == null){
            marcadorPosicaoAtual = new Marker(mapView);
        }
        marcadorPosicaoAtual.setPosition(mLocation);
        marcadorPosicaoAtual.setTitle("Minha localização");
        mapView.getOverlays().add(marcadorPosicaoAtual);
    }
    private void checkLocationPermission() {
        if (!hasLocationPermission()) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, PERMISSION_REQUEST_CODE);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (requestCode == PERMISSION_REQUEST_CODE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                getLocation();
            } else {
                Toast.makeText(this, "Permissão de localização necessária.", Toast.LENGTH_SHORT).show();
            }
        }
    }
}