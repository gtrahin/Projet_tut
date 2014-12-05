package gael.projet_tut_v2;


import android.app.Activity;
import android.view.View;

public class ButtonListennerRechercheGendarmerie implements View.OnClickListener{

    GeoActivity activity;

    public ButtonListennerRechercheGendarmerie(GeoActivity activity){

        this.activity = activity;


    }


    @Override
    public void onClick(View v) {

        if(v.getId() == R.id.naviguer){

            activity.lancerNavigation();
        }

    }
}
