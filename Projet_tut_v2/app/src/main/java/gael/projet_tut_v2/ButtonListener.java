package gael.projet_tut_v2;



import android.app.Activity;
import android.app.AlertDialog;
import android.content.*;
import android.net.Uri;
import android.view.View;

public class ButtonListener implements View.OnClickListener{

    Activity activity;

    public ButtonListener(Activity activity){

        this.activity = activity;


    }

    @Override
    public void onClick(View v) {


        if(v.getId() == R.id.butGeo){

            Intent intent = new Intent(activity, GeoActivity.class);
            activity.startActivity(intent);

        }

        if(v.getId() ==R.id.butFiches){

            AlertDialog.Builder builder = new AlertDialog.Builder(activity);

            builder.setMessage("Etes vous a l'aise avec cette aplication ?")
                    .setTitle("Info");



            builder.setPositiveButton("Oui", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {


                    //quand on clic sur OUI
                    Intent intent = new Intent(activity, FichesConfirmeActivity.class);
                    activity.startActivity(intent);

                }
            });

            builder.setNegativeButton("Non", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {


                    //quand on clic sur NON
                    Intent intent = new Intent(activity, FichesDebutantActivity.class);
                    activity.startActivity(intent);

                }
            });

            AlertDialog dialog = builder.create();

            dialog.show();


        }

        if(v.getId() ==R.id.butLiens){

            Intent intent = new Intent(activity, LienActivity.class);
            activity.startActivity(intent);


        }

        if(v.getId() ==R.id.butUrgence){

            AlertDialog.Builder builder = new AlertDialog.Builder(activity);

            builder.setMessage("Voulez-vous vraiment contacter le 17 ?")
                    .setTitle("Appel d'urgence");



            builder.setPositiveButton("Oui", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {


                    //quand on clic sur OUI
                    Intent intent = new Intent( Intent.ACTION_CALL, Uri.parse( "tel:17" ) );
                    activity.startActivity(intent);
                }
            });

            builder.setNegativeButton("Annuler", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    // User cancelled the dialog
                }
            });

            AlertDialog dialog = builder.create();

            dialog.show();


        }

       /* if(v.getId() ==R.id.butAutres){

            //activity.toggleMenu(activity.mAutres);

        }*/

    }


}
