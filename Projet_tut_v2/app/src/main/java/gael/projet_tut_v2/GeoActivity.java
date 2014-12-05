package gael.projet_tut_v2;

import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageButton;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.List;

public class GeoActivity extends FragmentActivity implements LocationListener{

    private GoogleMap mMap; // Might be null if Google Play services APK is not available.

    public ImageButton butRechercheGendarmerie; //bouton de recherche de la gendarmerie la plus proche
    public ButtonListennerRechercheGendarmerie buttonListenerRechercheGendarmerie;

    public String adresses[] = {
            "1 Rue du Marechal Juin Vesoul",
            "11 Avenue de la Gare Port-sur-saone",
            "2 Faubourg de Cour Noroy-le-bourg",
            "2 Rue de la Grande-Cote Saulx",
            "2 Rue du Bourg Scey-sur-Saone-et-Saint-Albin",
            "7 Faubourg de Besancon Hericourt",
            "12 Rue Pasteur Lure",
            "Route de Lure Melisey",
            "6 Avenue de la Gare Champagney",
            "147 Rue du 13 Septembre 1944 Villersexel",
            "2 Rue du Maréchal Leclerc Luxeuil-les-Bains",
            "47 Avenue Albert Thomas Saint-Loup-sur-Semouse",
            "13 Rue des Chars Faucogney-et-la-Mer",
            "17 Rue Maurice Signard Gray",
            "37 Rue Carnot Dampierre-sur-Salon",
            "100 Grande Rue Gy",
            "Route de Chaumercenne Pesmes"
    };

    public double coordoneGPS[][]= {

            {47.644028,6.163056},
            {47.689044,6.050178},
            {47.612964,6.308509},
            {47.697663,6.285037},
            {47.664202,5.972191},
            {47.572883,6.75116},
            {47.684653,6.497184},
            {47.745024,6.560603},
            {47.704574,6.688561},
            {47.549753,6.433814},
            {47.819485,6.36448},
            {47.882318,6.289264},
            {47.837653,6.562144},
            {47.445617,5.594605},
            {47.558056,5.681848},
            {47.404151,5.809493},
            {47.27989,5.563187}

    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_geo);
        setUpMapIfNeeded();
    }

    @Override
    protected void onResume() {
        super.onResume();
        setUpMapIfNeeded();
    }

    /**
     * Sets up the map if it is possible to do so (i.e., the Google Play services APK is correctly
     * installed) and the map has not already been instantiated.. This will ensure that we only ever
     * call {@link #setUpMap()} once when {@link #mMap} is not null.
     * <p>
     * If it isn't installed {@link SupportMapFragment} (and
     * {@link com.google.android.gms.maps.MapView MapView}) will show a prompt for the user to
     * install/update the Google Play services APK on their device.
     * <p>
     * A user can return to this FragmentActivity after following the prompt and correctly
     * installing/updating/enabling the Google Play services. Since the FragmentActivity may not
     * have been completely destroyed during this process (it is likely that it would only be
     * stopped or paused), {@link #onCreate(Bundle)} may not be called again so we should call this
     * method in {@link #onResume()} to guarantee that it will be called.
     */
    private void setUpMapIfNeeded() {
        // Do a null check to confirm that we have not already instantiated the map.
        if (mMap == null) {
            // Try to obtain the map from the SupportMapFragment.
            mMap = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map))
                    .getMap();
            // Check if we were successful in obtaining the map.
            if (mMap != null) {
                setUpMap();
            }
        }
    }

    /**
     * This is where we can add markers or lines, add listeners or move the camera. In this case, we
     * just add a marker near Africa.
     * <p>
     * This should only be called once and when we are sure that {@link #mMap} is not null.
     */
    private void setUpMap() {

        buttonListenerRechercheGendarmerie = new ButtonListennerRechercheGendarmerie(this); //initalisation du listenner pour le bouton de recherche
        butRechercheGendarmerie = (ImageButton)findViewById(R.id.naviguer); //obtention du bouton de recherche de la gendarmerie la plus proche
        butRechercheGendarmerie.setOnClickListener(buttonListenerRechercheGendarmerie);

        mMap.setMyLocationEnabled(true); //affiche le point bleu de ma position


        //permet d'effectuer le zoom sur ma position a l'ouverture
        GoogleMap.OnMyLocationChangeListener myLocationChangeListener = new GoogleMap.OnMyLocationChangeListener() {
            @Override
            public void onMyLocationChange (Location location) {
                LatLng loc = new LatLng (location.getLatitude(), location.getLongitude());
                mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(loc, 16.0f));
            }
        };
        mMap.setOnMyLocationChangeListener(myLocationChangeListener);


        /*Location loc = mMap.getMyLocation(); //retourne la localisation
        double maLongitude = loc.getLongitude(); //retourne ma longitude
        double maLatitude = loc.getLatitude();


        LatLng latlng = new LatLng(maLongitude,maLatitude); //définit un latlng pour mettre un position au chargement
        float zoom = 10; //définit un zoom
        CameraUpdateFactory.newLatLngZoom(latlng,zoom);*/

        //mMap.addMarker(new MarkerOptions().position(new LatLng(nMap., 6.8395726)).title("Marker"));
    }

    public void lancerNavigation(){

        int taille = adresses.length; //renvoie la taille du tableau || nombre de gendarmerie enrengistrée

        Location myLocation = mMap.getMyLocation(); //renvoie location actuelle
        LatLng loc = new LatLng (myLocation.getLatitude(), myLocation.getLongitude()); //renvoie la location sous la forme d'un tableau [lat][long]

        float meilleursDistance = 0;
        float currentDistance =0;
        int placeMeilleursDistance = 0;

        //initialisation de la location de la premiere gendarmerie du tableau
        Location currentLocation = new Location("");
        currentLocation.setLatitude(coordoneGPS[0][0]);
        currentLocation.setLongitude(coordoneGPS[0][1]);


        meilleursDistance = myLocation.distanceTo(currentLocation);

        for(int i = 1 ; i<taille ; i++){

            currentLocation.setLatitude(coordoneGPS[i][0]);
            currentLocation.setLongitude(coordoneGPS[i][1]);
            currentDistance = myLocation.distanceTo(currentLocation);

            if(currentDistance < meilleursDistance){

                meilleursDistance = currentDistance;
                placeMeilleursDistance = i;
            }

        }

        String destination = adresses[placeMeilleursDistance];

        Geocoder geocoder = new Geocoder(this.getBaseContext());
        List<Address> listeDepart= null;

        try {
            listeDepart = geocoder.getFromLocation(myLocation.getLatitude(), myLocation.getLongitude(), 1);
        } catch (IOException e) {
            e.printStackTrace();
        }

        String depart = listeDepart.get(0).getAddressLine(0)+" "+listeDepart.get(0).getAddressLine(1); //stockage de l'adresse


        Log.e("Ma position : ",depart);


        new ItineraireTask(this, mMap, depart,  destination).execute();
    }


    @Override
    public void onLocationChanged(Location location) {


    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }
}
