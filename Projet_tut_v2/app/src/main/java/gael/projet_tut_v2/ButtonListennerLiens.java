package gael.projet_tut_v2;

import android.content.Intent;
import android.net.Uri;
import android.view.View;

public class ButtonListennerLiens  implements View.OnClickListener {

    LienActivity activity;

    public ButtonListennerLiens(LienActivity activity){

           this.activity = activity;


        }

    @Override
    public void onClick(View v) {


        if(v.getId() == R.id.facebook){

            String url = "https://www.facebook.com/Gendarmerie70";
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse(url));
            activity.startActivity(i);

        }

        if(v.getId() == R.id.ministereInterieur){

            String url = "http://www.interieur.gouv.fr";
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse(url));
            activity.startActivity(i);


        }

        if(v.getId() == R.id.gendarmerieNational){

            String url = "http://www.gendarmerie.interieur.gouv.fr";
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse(url));
            activity.startActivity(i);


        }

    }
}
